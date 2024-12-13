CREATE VIEW character_stats_view AS
SELECT 
    characters.id AS character_id,
    characters.name AS character_name,
    statistics.health,
    statistics.humanity,
    statistics.willpower,
    statistics.hunger,
    statistics.resonance,
    statistics.hunting,
    statistics.blood_potency
FROM
    characters
LEFT JOIN 
    statistics ON characters.id = statistics.character_id;

CREATE VIEW character_lore_view AS
SELECT 
    characters.name AS character_name,
    origins.lore AS character_lore
FROM
    characters
JOIN 
    origins ON characters.id = origins.character_id;
