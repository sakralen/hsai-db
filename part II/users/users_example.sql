USE kill_team_db_v1;

-- Подготовили БД:
DELETE FROM session_rounds WHERE id > 80000;
DELETE FROM player WHERE id > 1000;
DELETE FROM game_session WHERE id > 10000;

-- (1) Представление до манипуляций:
SELECT * FROM sessions_per_player ORDER BY sessions_played ASC LIMIT 5;

-- Добавили новую сессию:
INSERT INTO game_session VALUES (DEFAULT, 1, '2023-01-01', 'Somewhere', 1, 2, 1);

SET @session_id = (SELECT max(id) FROM game_session);

-- Добавили новых игроков:
INSERT INTO player VALUES 
(DEFAULT, 'surname', 'name', 'middlename'),
(DEFAULT, 'surname', 'name', 'middlename');

SET @player_1_id = (SELECT max(id) - 1 FROM player);
SET @player_2_id = (SELECT max(id) FROM player);

-- (2) Представление после добавления новых игроков:
SELECT * FROM sessions_per_player ORDER BY sessions_played ASC LIMIT 5;

-- Добавили раунды для новых игроков:
INSERT INTO session_rounds VALUES(DEFAULT, @session_id, @player_1_id, 1, 1, 0);
INSERT INTO session_rounds VALUES(DEFAULT, @session_id, @player_2_id, 1, 1, 0);

-- (3) Представления после добавления раундов для новых игроков:
SELECT * FROM sessions_per_player ORDER BY sessions_played ASC LIMIT 5;

-- Заменили значения раундов; так как подсчет происходит по round_id = 1,
-- у новых игроков снова будет 0 сыграных партий:
UPDATE session_rounds SET round_id = 2 WHERE player_id > 1000;

-- (4) Представление после замены значений в раундах:
SELECT * FROM sessions_per_player ORDER BY sessions_played ASC LIMIT 5;

-- Удалили новых игроков:
DELETE FROM session_rounds WHERE id > 80000;
DELETE FROM player WHERE id > 1000;
DELETE FROM game_session WHERE id > 10000;

-- (5) Представление после удаления игроков:
SELECT * FROM sessions_per_player ORDER BY sessions_played ASC LIMIT 5;

-- (6) Проверка привилегий на остальные таблицы:
SELECT * FROM miniature ORDER BY id ASC LIMIT 5;
