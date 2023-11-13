USE kill_team_db_v1;

DROP TABLE IF EXISTS day_stat, month_stat, year_stat;
DROP TRIGGER IF EXISTS insert_session_trigger;
DROP TRIGGER IF EXISTS update_session_trigger;
DROP TRIGGER IF EXISTS delete_session_trigger;

CREATE TABLE day_stat (
	id INT PRIMARY KEY AUTO_INCREMENT,
    value INT NOT NULL,
    amount INT NOT NULL
);

CREATE TABLE month_stat (
	id INT PRIMARY KEY AUTO_INCREMENT,
    value INT NOT NULL,
    amount INT NOT NULL
);

CREATE TABLE year_stat (
	id INT PRIMARY KEY AUTO_INCREMENT,
    value INT NOT NULL,
    amount INT NOT NULL
);

DELIMITER //
CREATE TRIGGER insert_session_trigger
AFTER INSERT
ON game_session FOR EACH ROW
BEGIN    
	IF NOT EXISTS (SELECT value FROM day_stat WHERE value = DAY(NEW.date)) THEN
		INSERT INTO day_stat VALUES (DEFAULT, DAY(NEW.date), 1);
	ELSE
		UPDATE day_stat SET amount = amount + 1 WHERE value = DAY(NEW.date);
	END IF;
    #
	IF NOT EXISTS (SELECT value FROM month_stat WHERE value = MONTH(NEW.date)) THEN
		INSERT INTO month_stat VALUES (DEFAULT, MONTH(NEW.date), 1);
	ELSE
		UPDATE month_stat SET amount = amount + 1 WHERE value = MONTH(NEW.date);
	END IF;
    #
	IF NOT EXISTS (SELECT value FROM year_stat WHERE value = YEAR(NEW.date)) THEN
		INSERT INTO year_stat VALUES (DEFAULT, YEAR(NEW.date), 1);
	ELSE
		UPDATE year_stat SET amount = amount + 1 WHERE value = YEAR(NEW.date);
	END IF;
END; //
DELIMITER ;

DELIMITER //
CREATE TRIGGER update_session_trigger
AFTER UPDATE
ON game_session FOR EACH ROW
BEGIN  
	IF NEW.date <> OLD.date THEN
		UPDATE day_stat SET amount = amount - 1 WHERE value = DAY(OLD.date);
		UPDATE month_stat SET amount = amount - 1 WHERE value = MONTH(OLD.date);
        UPDATE year_stat SET amount = amount - 1 WHERE value = YEAR(OLD.date);
        #
		IF NOT EXISTS (SELECT value FROM day_stat WHERE value = DAY(NEW.date)) THEN
			INSERT INTO day_stat VALUES (DEFAULT, DAY(NEW.date), 1);
		ELSE
			UPDATE day_stat SET amount = amount + 1 WHERE value = DAY(NEW.date);
		END IF;
        #
        IF NOT EXISTS (SELECT value FROM month_stat WHERE value = MONTH(NEW.date)) THEN
			INSERT INTO month_stat VALUES (DEFAULT, MONTH(NEW.date), 1);
		ELSE
			UPDATE month_stat SET amount = amount + 1 WHERE value = MONTH(NEW.date);
		END IF;
        #
		IF NOT EXISTS (SELECT value FROM year_stat WHERE value = YEAR(NEW.date)) THEN
			INSERT INTO year_stat VALUES (DEFAULT, YEAR(NEW.date), 1);
		ELSE
			UPDATE year_stat SET amount = amount + 1 WHERE value = YEAR(NEW.date);
		END IF;
	END IF;
END; //
DELIMITER ;

DELIMITER //
CREATE TRIGGER delete_session_trigger
AFTER DELETE
ON game_session FOR EACH ROW
BEGIN
	IF EXISTS (SELECT value FROM day_stat WHERE value = DAY(OLD.date)) THEN
		UPDATE day_stat SET amount = amount - 1 WHERE value = DAY(OLD.date);
	END IF;
    #
    IF EXISTS (SELECT value FROM month_stat WHERE value = MONTH(OLD.date)) THEN
		UPDATE month_stat SET amount = amount - 1 WHERE value = MONTH(OLD.date);
	END IF;
    #
    IF EXISTS (SELECT value FROM year_stat WHERE value = YEAR(OLD.date)) THEN
		UPDATE year_stat SET amount = amount - 1 WHERE value = YEAR(OLD.date);
	END IF;
END; //
DELIMITER ;
