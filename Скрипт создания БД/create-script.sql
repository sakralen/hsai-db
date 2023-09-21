DROP DATABASE IF EXISTS kill_team_db_v1;

CREATE DATABASE kill_team_db_v1;

USE kill_team_db_v1;

CREATE TABLE Manufacturer (
manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
name CHAR(20) NOT NULL
);

CREATE TABLE Faction (
faction_id INT PRIMARY KEY AUTO_INCREMENT,
name CHAR(20) NOT NULL
);

CREATE TABLE Round (
round_id INT PRIMARY KEY AUTO_INCREMENT,
number TINYINT UNSIGNED NOT NULL,
);

CREATE TABLE Mission_card (
mission_card_id INT PRIMARY KEY AUTO_INCREMENT,
name CHAR(30) NOT NULL,
prerequisite VARCHAR(400) NOT NULL,
points TINYINT UNSIGNED NOT NULL
);

CREATE TABLE Game_field (
game_field_id INT PRIMARY KEY AUTO_INCREMENT,
type VARCHAR(20) NOT NULL
);

CREATE TABLE Terrain_piece (
terrain_piece_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
type VARCHAR(20) NOT NULL,
saving_throw_modifier TINYINT UNSIGNED NOT NULL,
manufacturer_id INT NOT NULL,

FOREIGN KEY (manufacturer_id) 
REFERENCES Manufacturer (manufacturer_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Miniature (
miniature_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
movement TINYINT UNSIGNED NOT NULL,
action_points TINYINT UNSIGNED NOT NULL,
defense TINYINT UNSIGNED NOT NULL,
saving_throw TINYINT UNSIGNED NOT NULL,
wounds TINYINT UNSIGNED NOT NULL,
manufacturer_id INT NOT NULL,

FOREIGN KEY (manufacturer_id) 
REFERENCES Manufacturer (manufacturer_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Squad (
squad_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
faction_id INT NOT NULL,

FOREIGN KEY (faction_id) 
REFERENCES Faction (faction_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Player (
player_id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
prefered_faction_id INT NOT NULL,

FOREIGN KEY (prefered_faction_id) 
REFERENCES Faction (faction_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Field_terrain (
field_terrain_id INT PRIMARY KEY AUTO_INCREMENT,
game_field_id INT NOT NULL,
terrain_piece_id INT NOT NULL,

FOREIGN KEY (game_field_id) 
REFERENCES Game_field (game_field_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (terrain_piece_id) 
REFERENCES Terrain_piece (terrain_piece_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Miniature_in_squad (
miniature_in_squad_id INT PRIMARY KEY AUTO_INCREMENT,
squad_id INT NOT NULL,
miniature_id INT NOT NULL,

FOREIGN KEY (squad_id) 
REFERENCES Squad (squad_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (miniature_id) 
REFERENCES Miniature (miniature_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Player_roster (
player_roster_id INT PRIMARY KEY AUTO_INCREMENT,
player_id INT NOT NULL,
squad_id INT NOT NULL,

FOREIGN KEY (player_id) 
REFERENCES Player (player_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (squad_id) 
REFERENCES Squad (squad_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Game_session (
game_session_id INT PRIMARY KEY AUTO_INCREMENT,
rules_edition TINYINT UNSIGNED NOT NULL,
date DATE NOT NULL,
location VARCHAR(100) NOT NULL,
player_1_roster_id INT NOT NULL,
player_2_roster_id INT NOT NULL,
game_field_id INT NOT NULL,

FOREIGN KEY (player_1_roster_id) 
REFERENCES Player_roster (player_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (player_2_roster_id) 
REFERENCES Player_roster (player_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (game_field_id) 
REFERENCES Game_field (game_field_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);

CREATE TABLE Session_rounds (
session_rounds_id INT PRIMARY KEY AUTO_INCREMENT,
game_session_id INT NOT NULL,
player_id INT NOT NULL,
round_id INT NOT NULL,
mission_card_id INT NOT NULL,
acquired_points TINYINT UNSIGNED NOT NULL,

FOREIGN KEY (game_session_id) 
REFERENCES Game_session (game_session_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (player_id) 
REFERENCES Player (player_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (round_id) 
REFERENCES Round (round_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT,

FOREIGN KEY (mission_card_id) 
REFERENCES Mission_card (mission_card_id) 
ON DELETE RESTRICT ON UPDATE RESTRICT
);
