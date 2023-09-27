-- Найти карту (карты), которые использованы максимальное (минимальное) число раз.

SELECT 
	mission_card.name AS 'Card''s name',
	COUNT(*) AS 'Usage count'
FROM mission_card
INNER JOIN session_rounds 
	ON mission_card.id = session_rounds.mission_card_id
GROUP BY mission_card.name
HAVING COUNT(*) = (
	SELECT 
		COUNT(*)
	FROM mission_card
	INNER JOIN session_rounds 
		ON mission_card.id = session_rounds.mission_card_id
	GROUP BY mission_card.name
	ORDER BY COUNT(*) DESC
	LIMIT 1);
