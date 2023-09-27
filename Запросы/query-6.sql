-- Найти игроков, сыгравших большее (меньшее) число партий, чем игрок А.

SELECT 
	player.name AS 'Имя игрока', 
	player.surname AS 'Фамилия игрока', 
	COUNT(*) AS 'Сыгранное число партий'
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
	HAVING session_rounds.player_id = 147);

SELECT 
	player.name AS 'Имя игрока', 
	player.surname AS 'Фамилия игрока', 
	COUNT(*) AS 'Сыгранное число партий'
FROM player
INNER JOIN session_rounds 
	ON player.id = session_rounds.player_id
WHERE session_rounds.round_id = 1
GROUP BY session_rounds.player_id
HAVING COUNT(*) < (
	SELECT 
		COUNT(*)
	FROM session_rounds
	WHERE session_rounds.round_id = 1
	GROUP BY session_rounds.player_id
	HAVING session_rounds.player_id = 147)
