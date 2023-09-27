-- Найти всех производителей, миниатюры которых участвовали на игровом поле А.

SELECT 
    game_field.type AS 'Тип игрового поля', 
    manufacturer.name AS 'Название производителя'
FROM game_field
INNER JOIN game_session 
    ON game_field.id = game_session.game_field_id 
        AND game_field.id = 4
INNER JOIN player_roster 
    ON game_session.player_1_roster_id = player_roster.id 
        OR game_session.player_2_roster_id = player_roster.id
INNER JOIN squad 
    ON player_roster.squad_id = squad.id
INNER JOIN miniature_in_squad 
    ON squad.id = miniature_in_squad.squad_id
INNER JOIN miniature 
    ON miniature_in_squad.miniature_id = miniature.id
INNER JOIN manufacturer 
    ON miniature.manufacturer_id = manufacturer.id
GROUP BY manufacturer.name
