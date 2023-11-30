CREATE OR REPLACE VIEW sessions_per_player AS
SELECT 
	p.id player_id, 
	COUNT(sr.id) sessions_played
FROM player p
LEFT JOIN session_rounds sr
	ON p.id = sr.player_id
WHERE sr.round_id = 1 OR sr.round_id is NULL	
GROUP BY p.id
ORDER BY p.id
