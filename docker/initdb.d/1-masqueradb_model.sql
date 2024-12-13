SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE chronicles (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE inventory (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    current_weight INT,
    max_weight INT
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE characters (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(500),
    sire VARCHAR(100),
    predator VARCHAR(100),
    clan VARCHAR(100) NOT NULL,
    concept VARCHAR(100),
    ambition VARCHAR(100),
    desire VARCHAR(100),
    generation VARCHAR(20),
    inventory_id INT,
    chronicle_id INT,
    FOREIGN KEY (inventory_id) REFERENCES inventory(id),
    FOREIGN KEY (chronicle_id) REFERENCES chronicles(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE chronicles_permissions (
    chronicle_id INT NOT NULL,
    user_id INT NOT NULL,
    permission_type ENUM('player', 'admin') NOT NULL,
    PRIMARY KEY (chronicle_id, user_id),
    FOREIGN KEY (chronicle_id) REFERENCES chronicles(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE touchstones (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    character_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE convictions (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    character_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE origins (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    real_age INT,
    seeming_age INT,
    date_of_birth DATE,
    date_of_death DATE,
    notable_features VARCHAR(200),
    appearance VARCHAR(1000),
    lore VARCHAR(2000),
    character_id INT NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE statistics (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    health INT,
    humanity INT,
    willpower INT,
    hunger INT,
    resonance VARCHAR(20),
    hunting VARCHAR(50),
    blood_potency INT,
    character_id INT NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE attributes (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE skills (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE characters_attributes (
    character_id INT NOT NULL,
    attribute_id INT NOT NULL,
    value INT NOT NULL,
    PRIMARY KEY (character_id, attribute_id),
    FOREIGN KEY (character_id) REFERENCES characters(id),
    FOREIGN KEY (attribute_id) REFERENCES attributes(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE characters_skills (
    character_id INT NOT NULL,
    skill_id INT NOT NULL,
    value INT NOT NULL,
    PRIMARY KEY (character_id, skill_id),
    FOREIGN KEY (character_id) REFERENCES characters(id),
    FOREIGN KEY (skill_id) REFERENCES skills(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE disciplines (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    character_id INT NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE advantages (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    value INT,
    character_id INT NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE flaws (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    value INT,
    character_id INT NOT NULL,
    FOREIGN KEY (character_id) REFERENCES characters(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE items (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    weight INT DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE inventory_items (
    inventory_id INT NOT NULL,
    item_id INT NOT NULL,
    PRIMARY KEY (inventory_id, item_id),
    FOREIGN KEY (inventory_id) REFERENCES inventory(id),
    FOREIGN KEY (item_id) REFERENCES items(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--PARA PODER HACER CAMBIOS DESDE JAVA SIN IMPLEMENTAR TODAS LAS TABLAS

ALTER TABLE touchstones
ADD CONSTRAINT fk_character_id_touchstones
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

ALTER TABLE convictions
ADD CONSTRAINT fk_character_id_convictions
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

ALTER TABLE origins
ADD CONSTRAINT fk_character_id_origins
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

ALTER TABLE statistics
ADD CONSTRAINT fk_character_id_statistics
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

ALTER TABLE disciplines
ADD CONSTRAINT fk_character_id_disciplines
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

ALTER TABLE advantages
ADD CONSTRAINT fk_character_id_advantages
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

ALTER TABLE flaws
ADD CONSTRAINT fk_character_id_flaws
FOREIGN KEY (character_id)
REFERENCES characters(id)
ON DELETE CASCADE;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

