-- Для каждой фракции посчитать число сыгранных карт миссий. Нарисовать гистограмму.

EXPLAIN SELECT 
	faction.name AS 'Faction''s name',
    COUNT(*) AS 'Cards played'
FROM session_rounds
INNER JOIN game_session
	ON session_rounds.game_session_id = game_session.id
INNER JOIN player_roster
	ON (game_session.player_1_roster_id = player_roster.id
			OR game_session.player_2_roster_id = player_roster.id)
        AND session_rounds.player_id = player_roster.player_id
INNER JOIN squad
	ON player_roster.squad_id = squad.id
INNER JOIN faction
	ON squad.faction_id = faction.id
GROUP BY faction.name
