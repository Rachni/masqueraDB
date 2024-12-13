DELIMITER //

CREATE TRIGGER set_max_weight_based_on_strength_insert
AFTER INSERT ON characters_attributes FOR EACH ROW
IF NEW.attribute_id = (
    SELECT id FROM attributes WHERE name = 'Strength'
) THEN
    UPDATE inventory
    SET max_weight = NEW.value * 5
    WHERE id = (
        SELECT inventory_id FROM characters WHERE id = NEW.character_id
    );
END IF//

CREATE TRIGGER set_max_weight_based_on_strength_update
AFTER UPDATE ON characters_attributes FOR EACH ROW
IF NEW.attribute_id = (
    SELECT id FROM attributes WHERE name = 'Strength'
) THEN
    UPDATE inventory
    SET max_weight = NEW.value * 5
    WHERE id = (
        SELECT inventory_id FROM characters WHERE id = NEW.character_id
    );
END IF//

CREATE TRIGGER calculate_inventory_weight_on_insert
BEFORE INSERT ON inventory_items FOR EACH ROW
BEGIN
    DECLARE total_weight INT;
    
    SELECT SUM(items.weight) INTO total_weight
    FROM items
    JOIN inventory_items ON items.id = inventory_items.item_id
    WHERE inventory_items.inventory_id = NEW.inventory_id;

    UPDATE inventory
    SET current_weight = total_weight
    WHERE id = NEW.inventory_id;
END//

CREATE TRIGGER recalculate_inventory_weight_on_delete
BEFORE DELETE ON inventory_items FOR EACH ROW
BEGIN
    DECLARE total_weight INT;
    
    SELECT SUM(items.weight) INTO total_weight
    FROM items
    JOIN inventory_items ON items.id = inventory_items.item_id
    WHERE inventory_items.inventory_id = OLD.inventory_id;

    UPDATE inventory
    SET current_weight = total_weight
    WHERE id = OLD.inventory_id;
END//

CREATE PROCEDURE check_inventory_weight_within_max (IN character_id INT)
BEGIN
    DECLARE current_weight INT;
    DECLARE max_weight INT;

    SELECT total_weight INTO current_weight
    FROM inventory
    WHERE id = (
        SELECT inventory_id
        FROM characters
        WHERE id = character_id
    );

    SELECT max_weight INTO max_weight
    FROM inventory
    WHERE id = (
        SELECT inventory_id
        FROM characters
        WHERE id = character_id
    );

    IF current_weight > max_weight THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Character is carrying too much.';
    END IF;
END//

DELIMITER ;
