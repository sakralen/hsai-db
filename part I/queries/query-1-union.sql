EXPLAIN SELECT 
	union_table.gf_type AS 'Game field''s type', 
    union_table.m_name AS 'Manufacturer''s name'
FROM (SELECT 
		game_field.type AS gf_type,
		manufacturer.name AS m_name
	FROM game_field
	INNER JOIN game_session 
		ON game_field.id = game_session.game_field_id 
	INNER JOIN player_roster 
		ON game_session.player_1_roster_id = player_roster.id 
	INNER JOIN squad 
		ON player_roster.squad_id = squad.id
	INNER JOIN miniature_in_squad 
		ON squad.id = miniature_in_squad.squad_id
	INNER JOIN miniature 
		ON miniature_in_squad.miniature_id = miniature.id
	INNER JOIN manufacturer 
		ON miniature.manufacturer_id = manufacturer.id
	WHERE game_field.id = 4    
	UNION
	SELECT 
		game_field.type AS gf_type, 
		manufacturer.name AS m_name
	FROM game_field
	INNER JOIN game_session 
		ON game_field.id = game_session.game_field_id 
	INNER JOIN player_roster 
		ON game_session.player_2_roster_id = player_roster.id 
	INNER JOIN squad 
		ON player_roster.squad_id = squad.id
	INNER JOIN miniature_in_squad 
		ON squad.id = miniature_in_squad.squad_id
	INNER JOIN miniature 
		ON miniature_in_squad.miniature_id = miniature.id
	INNER JOIN manufacturer 
		ON miniature.manufacturer_id = manufacturer.id
	WHERE game_field.id = 4) as union_table
    