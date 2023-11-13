USE kill_team_db_v1;

DROP TABLE IF EXISTS faction_stat;

CREATE TABLE faction_stat (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name CHAR(20) NOT NULL,
    amount INT NOT NULL
);

DROP TRIGGER IF EXISTS prefered_faction_trigger;

DELIMITER //
CREATE TRIGGER prefered_faction_trigger AFTER INSERT
ON player FOR EACH ROW
BEGIN
    SET @new_faction_name = (SELECT f.name FROM faction f WHERE f.id = NEW.prefered_faction_id);
    IF NOT EXISTS(SELECT fs.name FROM faction_stat fs WHERE fs.name = @new_faction_name) THEN
        INSERT INTO faction_stat(name, amount) VALUES (@new_faction_name, 1);
    ELSE 
        UPDATE faction_stat SET amount = amount + 1 WHERE name = @new_faction_name;
	END IF; 
END; //
DELIMITER ;
