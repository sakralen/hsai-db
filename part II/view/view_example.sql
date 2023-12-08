USE kill_team_db_v1;

SELECT 
	p.surname "Surname",
	p.name "Name",
	p.middlename "Middlename",
	spp.sessions_played "Sessions played"
FROM sessions_per_player spp
INNER JOIN player p
	ON spp.player_id = p.id
WHERE spp.sessions_played < 10;
