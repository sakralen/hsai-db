DROP FUNCTION IF EXISTS get_full_name;

CREATE FUNCTION get_full_name (surname VARCHAR(30), name VARCHAR(30), middlename VARCHAR(30))
RETURNS VARCHAR(90) 
DETERMINISTIC NO SQL
RETURN CONCAT(surname, ' ' , name, ' ', middlename);

SELECT
	get_full_name(p.surname, p.name, p.middlename) 'Player'
FROM player p
LIMIT 10;

DROP FUNCTION IF EXISTS get_initials;

CREATE FUNCTION get_initials (surname VARCHAR(30), name VARCHAR(30), middlename VARCHAR(30))
RETURNS VARCHAR(40)
DETERMINISTIC NO SQL
RETURN CONCAT(surname, ' ' , LEFT(name, 1), '. ', LEFT(middlename, 1), '.');

SELECT
	get_initials(p.surname, p.name, p.middlename) 'Player'
FROM player p
LIMIT 10;
