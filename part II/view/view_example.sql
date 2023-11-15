USE kill_team_db_v1;

SELECT 
	p.name "Имя", 
	p.surname "Фамилия", 
	spp.sessions_played "Число партий"
FROM sessions_per_player spp
INNER JOIN player p
	ON spp.player_id = p.id;
