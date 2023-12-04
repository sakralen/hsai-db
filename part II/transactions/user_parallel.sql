DROP USER IF EXISTS 'parallel'@'localhost';

CREATE USER 'parallel'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON kill_team_db_v1.* TO 'parallel'@'localhost';
