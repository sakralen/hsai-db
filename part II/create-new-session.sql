-- DELETE FROM session_rounds WHERE id > 10000;
-- DELETE FROM session_rounds WHERE id > 80000;

INSERT INTO game_session VALUES (DEFAULT, 1, "2023-01-01", "Knowhere", "1", "2", "1");
SET @session_id = (SELECT max(id) FROM game_session);
SET @player_1_id = (SELECT player_id FROM player_roster WHERE id = 1);
SET @player_2_id = (SELECT player_id FROM player_roster WHERE id = 2);

INSERT INTO session_rounds VALUES
(DEFAULT, @session_id, @player_1_id, 1, 1, 0),
(DEFAULT, @session_id, @player_2_id, 1, 2, 0),
(DEFAULT, @session_id, @player_1_id, 2, 3, 0),
(DEFAULT, @session_id, @player_2_id, 2, 4, 0),
(DEFAULT, @session_id, @player_1_id, 3, 5, 0),
(DEFAULT, @session_id, @player_2_id, 3, 6, 0),
(DEFAULT, @session_id, @player_1_id, 4, 7, 0),
(DEFAULT, @session_id, @player_2_id, 4, 8, 0);

-- SELECT * FROM session_rounds WHERE id > 10000;
-- SELECT * FROM session_rounds WHERE id > 80000;
