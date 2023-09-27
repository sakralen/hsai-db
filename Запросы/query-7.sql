-- Найти производителя, миниатюрами которого не играл игрок А.

SELECT 
    manufacturer.name AS 'Название производителя'
FROM manufacturer
WHERE manufacturer.id NOT IN (
    SELECT manufacturer.id 
    FROM manufacturer
    INNER JOIN miniature 
        ON manufacturer.id = miniature.manufacturer_id
    INNER JOIN miniature_in_squad 
        ON miniature.id = miniature_in_squad.miniature_id
    INNER JOIN squad 
        ON miniature_in_squad.squad_id = squad.id
    INNER JOIN player_roster 
        ON squad.id = player_roster.squad_id
    INNER JOIN player 
        ON player_roster.player_id = player.id
    WHERE player.id = 742
    GROUP BY manufacturer.name)
