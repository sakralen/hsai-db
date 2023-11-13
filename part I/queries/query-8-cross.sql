SELECT 
	game_field.type AS 'Game fields''s type', 
    mission_card.name AS 'Card''s name',
    (SELECT 
		COUNT(*)
	FROM game_session
	INNER JOIN session_rounds 
		ON game_session.id = session_rounds.game_session_id
	WHERE game_session.game_field_id = game_field.id
		AND session_rounds.mission_card_id = mission_card.id) 'Usage count'
FROM game_field
CROSS JOIN mission_card
    
