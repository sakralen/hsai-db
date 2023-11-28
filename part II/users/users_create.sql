USE kill_team_db_v1;

DROP USER IF EXISTS 'r'@'localhost';
DROP USER IF EXISTS 'rw'@'localhost';

CREATE USER 'r'@'localhost' IDENTIFIED BY 'pass';
GRANT SELECT ON sessions_per_player TO 'r'@'localhost';

CREATE USER 'rw'@'localhost' IDENTIFIED BY 'pass';
GRANT SELECT ON sessions_per_player TO 'rw'@'localhost';
GRANT ALL PRIVILEGES ON game_session TO 'rw'@'localhost';
GRANT ALL PRIVILEGES ON session_rounds TO 'rw'@'localhost';
GRANT ALL PRIVILEGES ON player TO 'rw'@'localhost';
