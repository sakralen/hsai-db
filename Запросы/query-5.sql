-- Посчитать число игроков с одинаковым числом партий. Нарисовать гистограмму.

SELECT 
	played_per_player.sessions_played as 'Число партий',
	COUNT(*) as 'Число игроков'
FROM (
	SELECT 
		player_id, 
		COUNT(*) as sessions_played
	FROM session_rounds
	WHERE session_rounds.round_id = 1
	GROUP BY player_id) as played_per_player
GROUP BY played_per_player.sessions_played
ORDER BY COUNT(*) ASC
