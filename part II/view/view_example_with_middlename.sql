USE kill_team_db_v1;

SELECT 
	p.surname "Фамилия",
	p.name "Имя",
	p.middlename "Отчество",
	spp.sessions_played "Число партий"
FROM sessions_per_player spp
INNER JOIN player p
	ON spp.player_id = p.id;
    
INSERT INTO player VALUES (DEFAULT, "surname", "name", "middlename");

SELECT 
	p.surname "Фамилия",
	p.name "Имя",
	p.middlename "Отчество",
	spp.sessions_played "Число партий"
FROM sessions_per_player spp
INNER JOIN player p
	ON spp.player_id = p.id;
