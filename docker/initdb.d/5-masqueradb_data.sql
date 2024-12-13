SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';
SET @old_autocommit=@@autocommit;

USE masqueradb;

INSERT INTO attributes (name)
VALUES
    ('Charisma'),
    ('Composure'),
    ('Dexterity'),
    ('Intelligence'),
    ('Manipulation'),
    ('Resolve'),
    ('Stamina'),
    ('Strength'),
    ('Wits');

INSERT INTO skills (name)
VALUES
    ('Academics'),
    ('Animal Ken'),
    ('Athletics'),
    ('Awareness'),
    ('Brawl'),
    ('Craft'),
    ('Drive'),
    ('Etiquette'),
    ('Finance'),
    ('Firearms'),
    ('Insight'),
    ('Intimidation'),
    ('Investigation'),
    ('Larceny'),
    ('Leadership'),
    ('Melee'),
    ('Medicine'),
    ('Occult'),
    ('Performance'),
    ('Persuasion'),
    ('Politics'),
    ('Science'),
    ('Stealth'),
    ('Streetwise'),
    ('Subterfuge'),
    ('Survival'),
    ('Technology');

INSERT INTO users (name, password, email) VALUES
('Alice', 'securepassword123', 'alice@example.com'),
('Bob', 'anotherpassword456', 'bob@example.com'),
('Charlie', 'password789', 'charlie@example.com'),
('Ana', 'contraseñasegura', 'anamartinezperdomo@gmail.com');

INSERT INTO chronicles (name) VALUES
('Chicago by Night'),
('The Fall of London'),
('Las Islas Manchadas en Sangre'),
('Blood and Betrayal');

INSERT INTO chronicles_permissions (chronicle_id, user_id, permission_type) VALUES
(1, 1, 'admin'),
(1, 2, 'player'),
(2, 3, 'player'),
(3, 1, 'player');

-- Personajes de prueba
INSERT INTO characters (name, description, sire, predator, clan, concept, ambition, desire, generation, inventory_id, chronicle_id) VALUES
('Tyrandel', 'A noble vampire with a strong sense of leadership.', 'Hardestadt', 'Manipulative', 'Ventrue', 'Noble Leader', 'Rule the Kindred', 'Maintain Control', '7th', 1, 1),
('Riss', 'An artistically inclined vampire with a passion for beauty.', 'Helena', 'Alluring', 'Toreador', 'Artistic Muse', 'Create Masterpieces', 'Find Eternal Love', '8th', 2, 2),
('Helenah', 'A rebellious vampire with a penchant for anarchy.', 'Troile', 'Aggressive', 'Brujah', 'Rebel Leader', 'Overthrow Oppressors', 'Destroy the Establishment', '9th', 3, 3);
INSERT INTO touchstones (character_id, name) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), 'Sarah, the Loyal Retainer'),
((SELECT id FROM characters WHERE name='Riss'), 'Julian, the Art Critic'),
((SELECT id FROM characters WHERE name='Helenah'), 'Max, the Anarch Leader');

INSERT INTO convictions (character_id, name) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), 'Power is everything'),
((SELECT id FROM characters WHERE name='Riss'), 'Beauty is eternal'),
((SELECT id FROM characters WHERE name='Helenah'), 'Freedom above all');

INSERT INTO origins (character_id, real_age, seeming_age, date_of_birth, date_of_death, notable_features, appearance, lore) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), 300, 30, '1723-05-15', '1753-08-10', 'Piercing blue eyes', 'Tall and regal', 'Fought in the French Revolution'),
((SELECT id FROM characters WHERE name='Riss'), 150, 25, '1873-11-20', '1898-06-15', 'Long flowing hair', 'Graceful and elegant', 'Renowned painter in the late 19th century'),
((SELECT id FROM characters WHERE name='Helenah'), 200, 35, '1824-02-12', '1859-10-21', 'Scar across the left cheek', 'Muscular and intense', 'Led a rebellion in the early 20th century');

INSERT INTO statistics (character_id, health, humanity, willpower, hunger, resonance, hunting, blood_potency) VALUES
(1, 10, 7, 8, 2, 'Choleric', 'Manipulation', 1),
(2, 9, 8, 7, 1, 'Sanguine', 'Seduction', 2),
(3, 8, 6, 9, 3, 'Melancholic', 'Intimidation', 3);

INSERT INTO characters_attributes (character_id, attribute_id, value) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), (SELECT id FROM attributes WHERE name='Strength'), 4),
((SELECT id FROM characters WHERE name='Tyrandel'), (SELECT id FROM attributes WHERE name='Charisma'), 5),
((SELECT id FROM characters WHERE name='Riss'), (SELECT id FROM attributes WHERE name='Dexterity'), 3),
((SELECT id FROM characters WHERE name='Riss'), (SELECT id FROM attributes WHERE name='Composure'), 4),
((SELECT id FROM characters WHERE name='Helenah'), (SELECT id FROM attributes WHERE name='Strength'), 5),
((SELECT id FROM characters WHERE name='Helenah'), (SELECT id FROM attributes WHERE name='Wits'), 3);
INSERT INTO characters_skills (character_id, skill_id, value) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), (SELECT id FROM skills WHERE name='Leadership'), 4),
((SELECT id FROM characters WHERE name='Tyrandel'), (SELECT id FROM skills WHERE name='Investigation'), 3),
((SELECT id FROM characters WHERE name='Riss'), (SELECT id FROM skills WHERE name='Insight'), 4),
((SELECT id FROM characters WHERE name='Riss'), (SELECT id FROM skills WHERE name='Technology'), 2),
((SELECT id FROM characters WHERE name='Helenah'), (SELECT id FROM skills WHERE name='Brawl'), 5),
((SELECT id FROM characters WHERE name='Helenah'), (SELECT id FROM skills WHERE name='Intimidation'), 4);

INSERT INTO disciplines (name, character_id) VALUES
('Dominate', (SELECT id FROM characters WHERE name='Tyrandel')),
('Presence', (SELECT id FROM characters WHERE name='Riss')),
('Potence', (SELECT id FROM characters WHERE name='Helenah'));

INSERT INTO advantages (character_id, name, value) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), 'Resources', 3),
((SELECT id FROM characters WHERE name='Riss'), 'Contacts', 2),
((SELECT id FROM characters WHERE name='Helenah'), 'Allies', 4);

INSERT INTO flaws (character_id, name, value) VALUES
((SELECT id FROM characters WHERE name='Tyrandel'), 'Enemy', -2),
((SELECT id FROM characters WHERE name='Riss'), 'Addiction', -1),
((SELECT id FROM characters WHERE name='Helenah'), 'Prey Exclusion', -3);

INSERT INTO inventory (id) VALUES (1), (2), (3), (4), (5);

INSERT INTO items (name, description, weight) VALUES
('Axe', 'A tool typically used for chopping wood.', 5),
('Hammer', 'A tool for driving nails into wood or other materials.', 3),
('Screwdriver', 'A tool for turning screws.', 1),
('Pliers', 'A hand tool used to hold objects firmly.', 2),
('Wrench', 'A tool used for gripping and turning nuts and bolts.', 3),
('Chainsaw', 'A portable mechanical saw with a toothed chain.', 10),
('Shovel', 'A tool with a broad blade used for digging.', 5),
('Pickaxe', 'A tool with a pointed end for breaking up hard ground or rock.', 7),
('Crowbar', 'A tool consisting of a metal bar with a curved end.', 4),
('Sledgehammer', 'A large heavy hammer with a long handle.', 8),
('Flashlight', 'A hand-held portable electric light.', 1),
('Lantern', 'A lamp with a transparent case protecting the flame or electric bulb.', 3),
('Oil Lamp', 'A lamp that burns oil for light.', 2),
('Candle', 'A cylinder or block of wax or tallow with a central wick.', 1),
('Matches', 'A small stick of wood or strip of cardboard with a solidified mixture of flammable chemicals on one end.', 1),
('Firestarter', 'A device used to start a fire.', 1),
('Torch', 'A portable light source.', 2),
('Flare', 'A device used to produce a bright light for signaling or illumination.', 1),
('Signal Mirror', 'A mirror designed to reflect sunlight to attract attention.', 1),
('Whistle', 'A small wind instrument that produces a loud sound when blown.', 0),
('Compass', 'An instrument for determining directions.', 1),
('Map', 'A representation of an area depicting physical features.', 1),
('GPS Device', 'A device that receives signals from satellites to determine location.', 2),
('Radio', 'A device for receiving and transmitting radio signals.', 3),
('Walkie-Talkie', 'A handheld portable two-way radio.', 2),
('Binoculars', 'An optical instrument for viewing distant objects.', 2),
('Telescope', 'An optical instrument for viewing distant objects.', 5),
('Microscope', 'An optical instrument used for viewing small objects.', 3),
('Magnifying Glass', 'A convex lens used to produce a magnified image of an object.', 1),
('Camera', 'A device used to capture images.', 3),
('Tripod', 'A three-legged stand for supporting a camera or other apparatus.', 2),
('Drone', 'A remote-controlled flying device.', 4),
('Satellite Phone', 'A mobile phone that communicates via satellites.', 2),
('Laptop', 'A portable computer.', 5),
('Tablet', 'A mobile computer with a touchscreen display.', 2),
('Smartphone', 'A mobile phone with advanced features.', 1),
('E-reader', 'A handheld electronic device for reading digital books.', 1),
('Power Bank', 'A portable charger for electronic devices.', 1),
('Solar Charger', 'A charger that converts solar energy into electrical power.', 1),
('Portable Generator', 'A device that converts mechanical energy into electrical energy.', 10),
('Solar Panel', 'A device that converts sunlight into electricity.', 5),
('Battery', 'A device consisting of one or more electrochemical cells.', 1),
('Inverter', 'A device that converts direct current (DC) into alternating current (AC).', 2),
('Extension Cord', 'A flexible electrical cable with a plug at one end and one or more sockets at the other end.', 2),
('Power Strip', 'An electrical socket with multiple outlets.', 2),
('Camping Stove', 'A portable stove used for cooking outdoors.', 5),
('Portable Grill', 'A portable device used for cooking food over an open flame.', 6),
('Cookware Set', 'A set of pots, pans, and other cooking utensils.', 8),
('Cooler', 'A container used to keep food and drinks cool.', 5),
('Ice Pack', 'A plastic bag filled with a gel that stays cold when frozen.', 1),
('Tent', 'A portable shelter for camping.', 10),
('Sleeping Bag', 'A padded bag designed to be slept in outdoors.', 8),
('Air Mattress', 'A inflatable mattress for sleeping on.', 3),
('Camping Chair', 'A portable chair used for outdoor activities.', 4),
('Folding Table', 'A collapsible table for outdoor dining.', 5),
('Hiking Boots', 'Boots designed for walking on rough terrain.', 2),
('Backpack', 'A bag with shoulder straps for carrying items on the back.', 5),
('Trekking Pole', 'A long stick used for support and balance while hiking.', 2),
('Canteen', 'A container for carrying water.', 1),
('Water Purifier', 'A device used to remove impurities from water.', 2),
('Water Bottle', 'A container for carrying water.', 1),
('Hydration Pack', 'A backpack with a built-in water reservoir.', 2),
('First Aid Kit', 'A collection of medical supplies for treating minor injuries.', 3),
('Emergency Blanket', 'A lightweight, reflective blanket used to retain body heat.', 1),
('Whistle', 'A small wind instrument for making a loud, high-pitched sound.', 0),
('Survival Kit', 'A collection of tools and supplies for surviving in the wilderness.', 5),
('Multi-tool', 'A versatile tool with multiple functions.', 1),
('Fire Starter', 'A device used to start a fire.', 1),
('Emergency Radio', 'A portable radio for receiving emergency broadcasts.', 2),
('Solar Charger', 'A charger that uses solar energy to charge electronic devices.', 1),
('Portable Water Filter', 'A device for filtering water in the field.', 1),
('Emergency Flare', 'A pyrotechnic device used for signaling in emergencies.', 1),
('Signal Mirror', 'A mirror designed to reflect sunlight for signaling.', 1),
('Emergency Whistle', 'A loud whistle for attracting attention in emergencies.', 0),
('Survival Rope', 'A strong and durable rope for various survival tasks.', 3),
('Emergency Tent', 'A lightweight, compact tent for emergency shelter.', 5),
('Survival Blanket', 'A lightweight, reflective blanket for retaining body heat.', 1),
('Solar Blanket', 'A blanket that absorbs solar energy to provide warmth.', 1),
('Emergency Food Rations', 'Pre-packaged food for emergency situations.', 2),
('Waterproof Matches', 'Matches designed to ignite even in wet conditions.', 1),
('Fire Starter Rod', 'A rod used to produce sparks for starting fires.', 1),
('Waterproof Tarp', 'A large sheet of waterproof material for shelter.', 5),
('Emergency Fire Starter', 'A compact device for starting fires in emergencies.', 1);

INSERT INTO characters (name, description, clan, sire, predator, concept, ambition, desire, generation, inventory_id, chronicle_id)
VALUES ('Carmilla', 'A powerful and cunning vampire queen.', 'Toreador', NULL, 'Unknown', 'Queen of Styria', 'To establish dominance over her territory', 'To expand her influence and power', 'Unknown', 4, 1);

INSERT INTO advantages (character_id, name, value)
VALUES
((SELECT id FROM characters WHERE name='Carmilla'), 'Eidetic Memory', 2),
((SELECT id FROM characters WHERE name='Carmilla'), 'Influential Sire', 3);

INSERT INTO flaws (character_id, name, value)
VALUES
((SELECT id FROM characters WHERE name='Carmilla'), 'Obsession: Styria', -2),
((SELECT id FROM characters WHERE name='Carmilla'), 'Soft Spot: Humans', -1);


INSERT INTO disciplines (name, character_id)
VALUES
('Presence', (SELECT id FROM characters WHERE name='Carmilla')),
('Dominate', (SELECT id FROM characters WHERE name='Carmilla'));

INSERT INTO characters (name, description, clan, sire, predator, concept, ambition, desire, generation, inventory_id, chronicle_id)
VALUES ('Dracula', 'An ancient and formidable vampire lord.', 'Tzimisce', NULL, 'Unknown', 'Lord of Darkness', 'To conquer and dominate all', 'To unleash chaos and darkness upon the world', 'Unknown', 5, 1);

INSERT INTO advantages (character_id, name, value)
VALUES
((SELECT id FROM characters WHERE name='Dracula'), 'Ancient Blood', 4),
((SELECT id FROM characters WHERE name='Dracula'), 'Unyielding Will', 3);


INSERT INTO flaws (character_id, name, value)
VALUES
((SELECT id FROM characters WHERE name='Dracula'), 'Hatred: Humanity', -3),
((SELECT id FROM characters WHERE name='Dracula'), 'Enemy: Belmonts', -2);

INSERT INTO disciplines (name, character_id)
VALUES
('Auspex', (SELECT id FROM characters WHERE name='Dracula')),
('Vicissitude', (SELECT id FROM characters WHERE name='Dracula'));

INSERT INTO characters_attributes (character_id, attribute_id, value) VALUES
((SELECT id FROM characters WHERE name='Carmilla'), (SELECT id FROM attributes WHERE name='Strength'), 5),
((SELECT id FROM characters WHERE name='Carmilla'), (SELECT id FROM attributes WHERE name='Manipulation'), 4),
((SELECT id FROM characters WHERE name='Dracula'), (SELECT id FROM attributes WHERE name='Strength'), 6),
((SELECT id FROM characters WHERE name='Dracula'), (SELECT id FROM attributes WHERE name='Resolve'), 5);

INSERT INTO statistics (character_id, health, humanity, willpower, hunger, resonance, hunting, blood_potency) VALUES
((SELECT id FROM characters WHERE name='Carmilla'), 9, 5, 7, 3, 'Choleric', 'Subjugation', 2),
((SELECT id FROM characters WHERE name='Dracula'), 10, 3, 9, 1, 'Sanguine', 'Domination', 4);
INSERT INTO origins (lore, character_id)
VALUES 
('Carmilla is a powerful and cunning vampire queen, known for her dominion over the territory of Styria and her influence over those around her. Her lineage and motivations remain shrouded in mystery, but her ambition to expand her power is undeniable.', (SELECT id FROM characters WHERE name='Carmilla'));

INSERT INTO origins (lore, character_id)
VALUES 
('Dracula is an ancient and formidable vampire lord, whose desire for conquest and domination is insatiable. Shrouded in darkness and legend, his mere presence inspires terror and obedience among those who serve him or cross his path.', (SELECT id FROM characters WHERE name='Dracula'));
SET AUTOCOMMIT=0;
COMMIT;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
SET autocommit=@old_autocommit;
