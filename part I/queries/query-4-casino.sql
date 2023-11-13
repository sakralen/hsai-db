UPDATE session_rounds SET session_rounds.mission_card_id = 18
WHERE session_rounds.id IN (
    SELECT id FROM (
        SELECT session_rounds.id FROM session_rounds
        WHERE session_rounds.mission_card_id = 16
        ORDER BY id ASC  
        LIMIT 9
    ) tmp
)  

-- SELECT 
-- 	mission_card.id,
-- 	mission_card.name,
-- 	COUNT(*)
-- FROM mission_card
-- INNER JOIN session_rounds 
-- 	ON mission_card.id = session_rounds.mission_card_id
-- GROUP BY mission_card.id, mission_card.name
-- ORDER BY COUNT(*) DESC