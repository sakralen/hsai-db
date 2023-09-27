-- Для каждого поля и каждой карты миссии посчитать число их использований. Построить трёхмерную диаграмму.

SELECT 
    game_field.type AS 'Тип поля', 
    mission_card.name AS 'Название карты миссии', 
    COUNT(*) AS 'Число использований'
FROM game_field
INNER JOIN game_session 
    ON game_field.id = game_session.game_field_id
INNER JOIN session_rounds 
    ON game_session.id = session_rounds.game_session_id
INNER JOIN mission_card 
    ON session_rounds.mission_card_id = mission_card.id
GROUP BY game_field.type, mission_card.name
