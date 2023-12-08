DROP PROCEDURE IF EXISTS show_winner;

DELIMITER //
CREATE PROCEDURE show_winner(IN session_id INT)
READS SQL DATA
BEGIN
    SELECT
		session_id 'Session',
		get_initials(p.surname, p.name, p.middlename) 'Player',
        SUM(acquired_points) 'Score'
    FROM session_rounds sr
    INNER JOIN player p
		ON sr.player_id = p.id
    WHERE game_session_id = session_id
	GROUP BY player_id
    HAVING SUM(acquired_points) = (
        SELECT
            SUM(acquired_points)
        FROM session_rounds sr
        WHERE game_session_id = session_id
        GROUP BY player_id
        ORDER BY player_id DESC
        LIMIT 1);
END //
DELIMITER ;

CALL show_winner(127);