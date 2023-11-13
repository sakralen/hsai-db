#INSERT INTO game_session VALUES (DEFAULT, 1, "2021-02-06", "knowhere", "100", "200", "5");
#UPDATE game_session SET date = "2021-02-05" WHERE date = "2021-02-06";
#DELETE FROM game_session WHERE date = "2021-02-05";

SELECT * FROM game_session ORDER BY id DESC;
SELECT * FROM day_stat;
SELECT * FROM month_stat;
SELECT * FROM year_stat;

#UPDATE game_session SET date = "2021-02-06" WHERE date = "2021-02-06"; # checking for new == old