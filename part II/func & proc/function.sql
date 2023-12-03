DROP FUNCTION IF EXISTS get_full_name;

CREATE FUNCTION get_full_name (surname VARCHAR(30), name VARCHAR(30), middlename VARCHAR(30))
RETURNS VARCHAR(90) 
DETERMINISTIC NO SQL
RETURN CONCAT(surname, ' ' , name, ' ', middlename);

SELECT 
	p.id,
	get_full_name(p.surname, p.name, p.middlename) 'ФИО'
FROM player p;
