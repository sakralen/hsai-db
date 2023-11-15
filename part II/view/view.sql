USE kill_team_db_v1;

CREATE OR REPLACE VIEW sessions_per_player AS
SELECT 
	player_id, 
	COUNT(*) as sessions_played
FROM session_rounds
WHERE session_rounds.round_id = 1
GROUP BY player_id
ORDER BY player_id ASC;
