USE kill_team_db_v1;

DROP TABLE IF EXISTS sessions_log;

CREATE TABLE sessions_log (
	id INT PRIMARY KEY AUTO_INCREMENT,
    session_id INT NOT NULL,
    type CHAR(10) NOT NULL,
	date TIMESTAMP NOT NULL,
    user CHAR(50) NOT NULL
);

DROP TRIGGER IF EXISTS insert_session_trigger;

DELIMITER //
CREATE TRIGGER insert_session_trigger
AFTER INSERT
ON game_session FOR EACH ROW
BEGIN
	INSERT INTO sessions_log VALUES (DEFAULT, NEW.id, "insert", now(), user());
END; //
DELIMITER ;

DROP TRIGGER IF EXISTS update_session_trigger;

DELIMITER //
CREATE TRIGGER update_session_trigger
AFTER UPDATE
ON game_session FOR EACH ROW
BEGIN
	INSERT INTO sessions_log VALUES (DEFAULT, NEW.id, "update", now(), user());
END; //
DELIMITER ;