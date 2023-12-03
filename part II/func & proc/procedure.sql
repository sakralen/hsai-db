DROP PROCEDURE IF EXISTS show_winner;

DELIMITER //
CREATE PROCEDURE show_winner(IN session_id INT)
READS SQL DATA
BEGIN
	SET @winner_id = (
		SELECT
			winner_score.pid
		FROM (
			SELECT
				player_id pid,
				SUM(acquired_points) ap
			FROM session_rounds sr
			WHERE game_session_id = session_id
			GROUP BY pid
			ORDER BY pid DESC
			LIMIT 1) winner_score);
            
	SET @squad_id = (
		SELECT
			session_roster.sid
		FROM (    
			SELECT
				pr.player_id pid,
				pr.squad_id sid
			FROM game_session gs
			INNER JOIN player_roster pr
				ON gs.player_1_roster_id = pr.id
			WHERE gs.id = session_id  
			UNION
			SELECT
				pr.player_id pid,
				pr.squad_id sid
			FROM game_session gs
			INNER JOIN player_roster pr
				ON gs.player_2_roster_id = pr.id
			WHERE gs.id = session_id) session_roster
		WHERE session_roster.pid = @winner_id);
        
	SELECT
		get_full_name(p.surname, p.name, p.middlename) 'ФИО',
        s.name 'Отряд'
	FROM player p
    INNER JOIN squad s
	WHERE p.id = @winner_id 
		AND s.id = @squad_id;
	END //
DELIMITER ;

CALL show_winner(123);
