-- Посчитать число карт миссий, сыгранных игроком А.

SELECT 
    player.name AS 'Player''s name', 
    player.surname AS 'Player''s surname', 
    COUNT(*) AS 'Cards played'
FROM player
INNER JOIN session_rounds 
    ON player.id = session_rounds.player_id
INNER JOIN mission_card 
    ON session_rounds.mission_card_id = mission_card.id
GROUP BY player.id
HAVING player.id = 23
