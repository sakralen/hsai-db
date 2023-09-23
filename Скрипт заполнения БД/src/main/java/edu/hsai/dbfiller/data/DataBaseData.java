package edu.hsai.dbfiller.data;

public class DataBaseData {
    public static final String DB_NAME = "kill_team_db_v1";

    /*TABLE NAMES*/
    /*PRIORITY 1*/
    public static final String MANUFACTURER_TABLE = "Manufacturer";
    public static final String FACTION_TABLE = "Faction";
    public static final String ROUND_TABLE = "Round";
    public static final String MISSION_CARD_TABLE = "Mission_card";
    public static final String GAME_FIELD_TABLE = "Game_field";

    /*PRIORITY 2*/
    public static final String TERRAIN_PIECE_TABLE = "Terrain_piece";
    public static final String MINIATURE_TABLE = "Miniature";
    public static final String SQUAD_TABLE = "Squad";
    public static final String PLAYER_TABLE = "Player";

    /*PRIORITY 3*/
    public static final String FIELD_TERRAIN_TABLE = "Field_terrain";
    public static final String MINIATURE_IN_SQUAD_TABLE = "Miniature_in_squad";
    public static final String PLAYER_ROSTER_TABLE = "Player_roster";

    /*PRIORITY 4*/
    public static final String GAME_SESSION_TABLE = "Game_session";

    /*PRIORITY 5*/
    public static final String SESSION_ROUNDS_TABLE = "Session_rounds";
    /*!TABLE NAMES*/


    /*GIVEN NUMBERS*/
    /*PRIORITY 1*/
    public static final int MANUFACTURERS_COUNT;
    public static final int FACTIONS_COUNT;
    public static final int ROUNDS_COUNT;
    public static final int MISSION_CARDS_COUNT;
    public static final int GAME_FIELDS_COUNT;

    /*PRIORITY 2*/
    public static final int TERRAIN_PIECES_COUNT;
    public static final int MINIATURES_COUNT;
    public static final int SQUADS_COUNT;
    public static final int PLAYERS_COUNT = 1000;

    /*PRIORITY 3*/
    public static final int FIELD_TERRAIN_COUNT = 10;
    public static final int MINIATURE_IN_SQUAD_COUNT = 10;
    public static final int PLAYER_ROSTERS_COUNT;

    /*PRIORITY 4*/
    public static final int GAME_SESSION_COUNT = 10000;

    /*PRIORITY 5*/
    public static final int SESSION_ROUNDS_COUNT;
    /*!GIVEN NUMBERS*/

    static {
        MANUFACTURERS_COUNT = KillTeamData.MANUFACTURERS_VALUES.length;
        FACTIONS_COUNT = KillTeamData.FACTION_VALUES.length;
        ROUNDS_COUNT = KillTeamData.ROUNDS_IN_SESSION_COUNT;
        MISSION_CARDS_COUNT = KillTeamData.MISSION_CARDS_VALUES.length;
        GAME_FIELDS_COUNT = KillTeamData.GAME_FIELDS_TYPES_VALUES.length;
        TERRAIN_PIECES_COUNT = KillTeamData.TERRAIN_PIECES_VALUES.length;
        MINIATURES_COUNT = KillTeamData.MINIATURES_VALUES.length;
        SQUADS_COUNT = KillTeamData.SQUAD_VALUES.length;
        PLAYER_ROSTERS_COUNT = GAME_SESSION_COUNT * KillTeamData.PLAYERS_IN_SESSION_COUNT;
        SESSION_ROUNDS_COUNT = GAME_SESSION_COUNT * KillTeamData.ROUNDS_IN_SESSION_COUNT
                * KillTeamData.PLAYERS_IN_SESSION_COUNT;
    }
}
