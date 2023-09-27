-- Найти игроков, сыгравших большее (меньшее) число партий, чем игрок А.

EXPLAIN SELECT 
	player.name AS 'Player''s name', 
	player.surname AS 'Player''s surname', 
	COUNT(*) AS 'Sessions played'
FROM player
INNER JOIN session_rounds 
	ON player.id = session_rounds.player_id
WHERE session_rounds.round_id = 1
GROUP BY session_rounds.player_id
HAVING COUNT(*) > (
	SELECT 
		COUNT(*)
	FROM session_rounds
	WHERE session_rounds.round_id = 1
	GROUP BY session_rounds.player_id
	HAVING session_rounds.player_id = 147)
ORDER BY COUNT(*) ASC