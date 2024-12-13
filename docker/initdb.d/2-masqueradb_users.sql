
CREATE USER 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON masqueradb.* TO 'admin'@'%';
CREATE USER 'app'@'%' IDENTIFIED BY 'app';
GRANT SELECT, INSERT, UPDATE, DELETE ON masqueradb.* TO 'app'@'%';
FLUSH PRIVILEGES;