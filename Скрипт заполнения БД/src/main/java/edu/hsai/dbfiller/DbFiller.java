package edu.hsai.dbfiller;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static edu.hsai.dbfiller.data.KillTeamData.*;
import static edu.hsai.dbfiller.data.DataBaseData.*;
import static edu.hsai.dbfiller.fileio.FileIO.*;

public class DbFiller {
    private static final String INSERT_INTO = "INSERT INTO ";
    private static final String VALUES = "VALUES ";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String APOSTROPHE = "'";
    private static final String DEFAULT = "DEFAULT";
    private static final Random RANDOM = new Random();

    public static void printDictionariesCount() {
        System.out.printf(""" 
                        ПРИОРИТЕТ 1:
                            Производителей: %d
                            Фракций: %d
                            Карт миссий: %d
                            Раундов: %d
                            Игровых полей: %d
                        ПРИОРИТЕТ 2:
                            Миниатюр: %d
                            Отрядов: %d
                            Элементов ландшафта: %d
                        ПРИОРИТЕТ 3:
                            Миниатюр в отряде: %d
                            Ландшафтов полей: %d
                            Ростеров игроков: %d
                        ПРИОРИТЕТ 4:
                            Игровых партий: %d
                        ПРИОРИТЕТ 5:
                            Раундов партий: %d""", MANUFACTURERS_COUNT, FACTIONS_COUNT, MISSION_CARDS_COUNT,
                ROUNDS_COUNT, GAME_FIELDS_COUNT, MINIATURES_COUNT, SQUADS_COUNT, TERRAIN_PIECES_COUNT,
                MINIATURE_IN_SQUAD_COUNT, FIELD_TERRAIN_COUNT, PLAYER_ROSTERS_COUNT, GAME_SESSION_COUNT,
                SESSION_ROUNDS_COUNT);
    }

    public static void writeOpening(String path) {
        String preamble = "USE " + DB_NAME + ";" + LINE_SEPARATOR + LINE_SEPARATOR
                + "SET FOREIGN_KEY_CHECKS = 0;" + LINE_SEPARATOR + LINE_SEPARATOR;
        writeToFile(preamble, path);
    }

    public static void writeClosing(String path) {
        writeToFile("SET FOREIGN_KEY_CHECKS = 1;" + LINE_SEPARATOR, path);
    }

    public static void fillSmallTables(String path) {
        /*PRIORITY 1*/
        /*MANUFACTURERS*/
        StringBuilder manufacturersInsertSb = new StringBuilder();
        manufacturersInsertSb.append(INSERT_INTO).append(MANUFACTURER_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < MANUFACTURERS_COUNT; i++) {
            manufacturersInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(MANUFACTURERS_VALUES[i]).append(APOSTROPHE)
                    .append(")").append((i != (MANUFACTURERS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(manufacturersInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!MANUFACTURERS*/

        /*FACTIONS*/
        StringBuilder factionsInsertSb = new StringBuilder();
        factionsInsertSb.append(INSERT_INTO).append(FACTION_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < FACTIONS_COUNT; i++) {
            factionsInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(FACTION_VALUES[i]).append(APOSTROPHE)
                    .append(")").append((i != (FACTIONS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(factionsInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!FACTIONS*/

        /*GAME FIELDS*/
        StringBuilder fieldsInsertSb = new StringBuilder();
        fieldsInsertSb.append(INSERT_INTO).append(GAME_FIELD_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < GAME_FIELDS_COUNT; i++) {
            fieldsInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(GAME_FIELDS_TYPES_VALUES[i]).append(APOSTROPHE)
                    .append(")").append((i != (GAME_FIELDS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(fieldsInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!GAME FIELDS*/

        /*ROUNDS*/
        StringBuilder roundsInsertSb = new StringBuilder();
        roundsInsertSb.append(INSERT_INTO).append(ROUND_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(ROUNDS_VALUES[i])
                    .append(")").append((i != (ROUNDS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(roundsInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!ROUNDS*/

        /*MISSION CARDS*/
        StringBuilder missionCardsInsertSb = new StringBuilder();
        missionCardsInsertSb.append(INSERT_INTO).append(MISSION_CARD_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < MISSION_CARDS_COUNT; i++) {
            missionCardsInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(MISSION_CARDS_VALUES[i][0]).append(APOSTROPHE).append(", ")
                    .append(APOSTROPHE).append(MISSION_CARDS_VALUES[i][1]).append(APOSTROPHE).append(", ")
                    .append(MISSION_CARDS_VALUES[i][2])
                    .append(")").append((i != (MISSION_CARDS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(missionCardsInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!MISSION CARDS*/

        /*PRIORITY 2*/
        /*TERRAIN PIECES*/
        StringBuilder terrainPiecesInsertSb = new StringBuilder();
        terrainPiecesInsertSb.append(INSERT_INTO).append(TERRAIN_PIECE_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < TERRAIN_PIECES_COUNT; i++) {
            terrainPiecesInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(TERRAIN_PIECES_VALUES[i][0]).append(APOSTROPHE).append(", ")
                    .append(APOSTROPHE).append(TERRAIN_PIECES_VALUES[i][1]).append(APOSTROPHE).append(", ")
                    .append(TERRAIN_PIECES_VALUES[i][2]).append(", ")
                    .append(RANDOM.nextInt(MANUFACTURERS_COUNT) + 1)
                    .append(")").append((i != (TERRAIN_PIECES_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(terrainPiecesInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!TERRAIN PIECES*/

        /*MINIATURES*/
        StringBuilder miniaturesInsertSb = new StringBuilder();
        miniaturesInsertSb.append(INSERT_INTO).append(MINIATURE_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < MINIATURES_COUNT; i++) {
            miniaturesInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(MINIATURES_VALUES[i][0]).append(APOSTROPHE).append(", ")
                    .append(Stream.of(MINIATURES_VALUES[i]).skip(1).limit(5)
                            .collect(Collectors.joining(", "))).append(", ")
                    .append(RANDOM.nextInt(MANUFACTURERS_COUNT) + 1)
                    .append(")").append((i != (MINIATURES_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(miniaturesInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!MINIATURES*/

        /*SQUADS*/
        StringBuilder squadsInsertSb = new StringBuilder();
        squadsInsertSb.append(INSERT_INTO).append(SQUAD_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < SQUADS_COUNT; i++) {
            squadsInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(SQUAD_VALUES[i]).append(APOSTROPHE).append(", ")
                    .append(RANDOM.nextInt(FACTIONS_COUNT) + 1)
                    .append(")").append((i != (SQUADS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(squadsInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!SQUADS*/

        /*PLAYERS*/
        StringBuilder playersInsertSb = new StringBuilder();
        playersInsertSb.append(INSERT_INTO).append(PLAYER_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            String name;
            String surname;
            if (RANDOM.nextBoolean()) {
                name = MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)];
                surname = MALE_SURNAMES[RANDOM.nextInt(MALE_SURNAMES.length)];
            } else {
                name = FEMALE_NAMES[RANDOM.nextInt(FEMALE_NAMES.length)];
                surname = FEMALE_SURNAMES[RANDOM.nextInt(FEMALE_SURNAMES.length)];
            }

            playersInsertSb.append("(").append(DEFAULT).append(", ")
                    .append(APOSTROPHE).append(name).append(APOSTROPHE).append(", ")
                    .append(APOSTROPHE).append(surname).append(APOSTROPHE).append(", ")
                    .append(RANDOM.nextInt(FACTIONS_COUNT) + 1)
                    .append(")").append((i != (PLAYERS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
        }
        writeToFile(playersInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!PLAYERS*/

        /*PRIORITY 3*/
        /*FIELD TERRAIN*/
        StringBuilder fieldTerrainInsertSb = new StringBuilder();
        fieldTerrainInsertSb.append(INSERT_INTO).append(FIELD_TERRAIN_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < GAME_FIELDS_COUNT; i++) {
            for (int j = 0; j < FIELD_TERRAIN_MULTIPLIER; j++) {
                fieldTerrainInsertSb.append("(").append(DEFAULT).append(", ")
                        .append(i + 1).append(", ")
                        .append(RANDOM.nextInt(TERRAIN_PIECES_COUNT) + 1)
                        .append(")")
                        .append(((i * j) != ((GAME_FIELDS_COUNT - 1) * (FIELD_TERRAIN_MULTIPLIER - 1))) ? "," : ";")
                        .append(LINE_SEPARATOR);
            }
        }
        writeToFile(fieldTerrainInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!FIELD TERRAIN*/

        /*MINIATURE IN SQUAD*/
        StringBuilder miniInSquadInsertSb = new StringBuilder();
        miniInSquadInsertSb.append(INSERT_INTO).append(MINIATURE_IN_SQUAD_TABLE).append(LINE_SEPARATOR)
                .append(VALUES).append(LINE_SEPARATOR);
        for (int i = 0; i < SQUADS_COUNT; i++) {
            for (int j = 0; j < MINIATURE_IN_SQUAD_MULTIPLIER; j++) {
                miniInSquadInsertSb.append("(").append(DEFAULT).append(", ")
                        .append(i + 1).append(", ")
                        .append(RANDOM.nextInt(MINIATURES_COUNT) + 1)
                        .append(")")
                        .append(((i * j) != ((SQUADS_COUNT - 1) * (MINIATURE_IN_SQUAD_MULTIPLIER - 1))) ? "," : ";")
                        .append(LINE_SEPARATOR);
            }
        }
        writeToFile(miniInSquadInsertSb.append(LINE_SEPARATOR).toString(), path);
        /*!MINIATURE IN SQUAD*/
    }

   public static void fillLargeTables(String path) {
       for (int i = 0; i < GAME_SESSION_COUNT; i++) {
           int player1Id = RANDOM.nextInt(PLAYERS_COUNT) + 1;
           int player2Id;
           do {
               player2Id = RANDOM.nextInt(PLAYERS_COUNT) + 1;
           } while (player1Id == player2Id);

           int player1SquadId = RANDOM.nextInt(SQUADS_COUNT) + 1;
           int player2SquadId;
           do {
               player2SquadId = RANDOM.nextInt(SQUADS_COUNT) + 1;
           } while (player1SquadId == player2SquadId);

           Stack<Integer> missionCardIds = new Stack<>();
           for (int j = 0; j < MISSION_CARDS_COUNT; j++) {
               missionCardIds.add(j + 1);
           }
           Collections.shuffle(missionCardIds);

           ArrayList<Integer> player1CardIds = new ArrayList<>();
           ArrayList<Integer> player2CardIds = new ArrayList<>();
           for (int j = 0; j < ROUNDS_COUNT; j++) {
               player1CardIds.add(missionCardIds.pop());
               player2CardIds.add(missionCardIds.pop());
           }

           StringBuilder playerRosterSb = new StringBuilder();
           playerRosterSb.append(INSERT_INTO).append(PLAYER_ROSTER_TABLE).append(LINE_SEPARATOR)
                   .append(VALUES).append(LINE_SEPARATOR)
                   .append("(").append(DEFAULT).append(", ")
                   .append(player1Id).append(", ").append(player1SquadId)
                   .append(")").append(",").append(LINE_SEPARATOR)
                   .append("(").append(DEFAULT).append(", ")
                   .append(player2Id).append(", ").append(player2SquadId)
                   .append(")").append(";").append(LINE_SEPARATOR);
           writeToFile(playerRosterSb.append(LINE_SEPARATOR).toString(), path);

           int player1RosterId = (2 * i + 1);
           int player2RosterId = player1RosterId + 1;
           LocalDate sessionDate = LocalDate.ofEpochDay(DATE_LOW + RANDOM.nextLong(DATE_HIGH - DATE_LOW));

           StringBuilder gameSessionSb = new StringBuilder();
           gameSessionSb.append(INSERT_INTO).append(GAME_SESSION_TABLE).append(LINE_SEPARATOR)
                   .append(VALUES).append(LINE_SEPARATOR)
                   .append("(").append(DEFAULT).append(", ")
                   .append(RANDOM.nextInt(RULES_EDITION_HIGH) + 1).append(", ")
                   .append(APOSTROPHE).append(sessionDate).append(APOSTROPHE).append(", ")
                   .append(APOSTROPHE)
                   .append(LOCATION_VALUES[RANDOM.nextInt(LOCATION_VALUES.length)])
                   .append(APOSTROPHE).append(", ")
                   .append(player1RosterId).append(", ")
                   .append(player2RosterId).append(", ")
                   .append(RANDOM.nextInt(GAME_FIELDS_COUNT) + 1)
                   .append(")").append(";").append(LINE_SEPARATOR);
           writeToFile(gameSessionSb.append(LINE_SEPARATOR).toString(), path);

           int sessionId = i + 1;
           StringBuilder sessionRoundsSb = new StringBuilder();
           sessionRoundsSb.append(INSERT_INTO).append(SESSION_ROUNDS_TABLE).append(LINE_SEPARATOR)
                   .append(VALUES).append(LINE_SEPARATOR);
           for (int j = 0; j < ROUNDS_COUNT; j++) {
               sessionRoundsSb.append("(").append(DEFAULT).append(", ")
                       .append(sessionId).append(", ")
                       .append(player1Id).append(", ")
                       .append(j + 1).append(", ")
                       .append(player1CardIds.get(j)).append(", ")
                       .append(RANDOM.nextInt(ROUND_POINTS_HIGH))
                       .append(")").append(",").append(LINE_SEPARATOR)
                       .append("(").append(DEFAULT).append(", ")
                       .append(sessionId).append(", ")
                       .append(player2Id).append(", ")
                       .append(j + 1).append(", ")
                       .append(player2CardIds.get(j)).append(", ")
                       .append(RANDOM.nextInt(ROUND_POINTS_HIGH))
                       .append(")")
                       .append((j != (ROUNDS_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
           }
           writeToFile(sessionRoundsSb.append(LINE_SEPARATOR).toString(), path);
       }
   }

    // public static void fillLargeTables(String path) {
    //     int[][] playerIds = new int[GAME_SESSION_COUNT][2];
    //     for (int i = 0; i < GAME_SESSION_COUNT; i++) {
    //         playerIds[i][0] = RANDOM.nextInt(PLAYERS_COUNT) + 1;
    //         do {
    //             playerIds[i][1] = RANDOM.nextInt(PLAYERS_COUNT) + 1;
    //         } while (playerIds[i][0] == playerIds[i][1]);
    //     }

    //     StringBuilder playerRosterSb = new StringBuilder();
    //     playerRosterSb.append(INSERT_INTO).append(PLAYER_ROSTER_TABLE).append(LINE_SEPARATOR)
    //             .append(VALUES).append(LINE_SEPARATOR);
    //     for (int i = 0; i < GAME_SESSION_COUNT; i++) {
    //         int player1SquadId = RANDOM.nextInt(SQUADS_COUNT) + 1;
    //         int player2SquadId;
    //         do {
    //             player2SquadId = RANDOM.nextInt(SQUADS_COUNT) + 1;
    //         } while (player1SquadId == player2SquadId);

    //         playerRosterSb.append("(").append(DEFAULT).append(", ")
    //                 .append(playerIds[i][0]).append(", ").append(player1SquadId)
    //                 .append(")").append(",").append(LINE_SEPARATOR)
    //                 .append("(").append(DEFAULT).append(", ")
    //                 .append(playerIds[i][1]).append(", ").append(player2SquadId)
    //                 .append(")")
    //                 .append((i != (GAME_SESSION_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
    //     }
    //     writeToFile(playerRosterSb.append(LINE_SEPARATOR).toString(), path);

    //     StringBuilder gameSessionSb = new StringBuilder();
    //     gameSessionSb.append(INSERT_INTO).append(GAME_SESSION_TABLE).append(LINE_SEPARATOR)
    //             .append(VALUES).append(LINE_SEPARATOR);
    //     for (int i = 0; i < GAME_SESSION_COUNT; i++) {
    //         LocalDate sessionDate = LocalDate.ofEpochDay(DATE_LOW + RANDOM.nextLong(DATE_HIGH - DATE_LOW));
    //         int player1RosterId = 2 * i + 1;
    //         int player2RosterId = player1RosterId + 1;

    //         gameSessionSb.append("(").append(DEFAULT).append(", ")
    //                 .append(RANDOM.nextInt(RULES_EDITION_HIGH) + 1).append(", ")
    //                 .append(APOSTROPHE).append(sessionDate).append(APOSTROPHE).append(", ")
    //                 .append(APOSTROPHE)
    //                 .append(LOCATION_VALUES[RANDOM.nextInt(LOCATION_VALUES.length)])
    //                 .append(APOSTROPHE).append(", ")
    //                 .append(player1RosterId).append(", ")
    //                 .append(player2RosterId).append(", ")
    //                 .append(RANDOM.nextInt(GAME_FIELDS_COUNT) + 1)
    //                 .append(")")
    //                 .append((i != (GAME_SESSION_COUNT - 1)) ? "," : ";").append(LINE_SEPARATOR);
    //     }
    //     writeToFile(gameSessionSb.append(LINE_SEPARATOR).toString(), path);

    //     StringBuilder sessionRoundsSb = new StringBuilder();
    //     sessionRoundsSb.append(INSERT_INTO).append(SESSION_ROUNDS_TABLE).append(LINE_SEPARATOR)
    //             .append(VALUES).append(LINE_SEPARATOR);
    //     for (int i = 0; i < GAME_SESSION_COUNT; i++) {
    //         int sessionId = i + 1;

    //         Stack<Integer> missionCardIds = new Stack<>();
    //         for (int j = 0; j < MISSION_CARDS_COUNT; j++) {
    //             missionCardIds.add(j + 1);
    //         }
    //         Collections.shuffle(missionCardIds);

    //         ArrayList<Integer> player1CardIds = new ArrayList<>();
    //         ArrayList<Integer> player2CardIds = new ArrayList<>();
    //         for (int j = 0; j < ROUNDS_COUNT; j++) {
    //             player1CardIds.add(missionCardIds.pop());
    //             player2CardIds.add(missionCardIds.pop());
    //         }

    //         for (int j = 0; j < ROUNDS_COUNT; j++) {
    //             sessionRoundsSb.append("(").append(DEFAULT).append(", ")
    //                     .append(sessionId).append(", ")
    //                     .append(playerIds[i][0]).append(", ")
    //                     .append(j + 1).append(", ")
    //                     .append(player1CardIds.get(j)).append(", ")
    //                     .append(RANDOM.nextInt(ROUND_POINTS_HIGH))
    //                     .append(")").append(",").append(LINE_SEPARATOR)
    //                     .append("(").append(DEFAULT).append(", ")
    //                     .append(sessionId).append(", ")
    //                     .append(playerIds[i][1]).append(", ")
    //                     .append(j + 1).append(", ")
    //                     .append(player2CardIds.get(j)).append(", ")
    //                     .append(RANDOM.nextInt(ROUND_POINTS_HIGH))
    //                     .append(")")
    //                     .append(((i * j) != ((GAME_SESSION_COUNT - 1) * (ROUNDS_COUNT - 1))) ? "," : ";")
    //                     .append(LINE_SEPARATOR);
    //         }
    //     }
    //     writeToFile(sessionRoundsSb.append(LINE_SEPARATOR).toString(), path);
    // }
}
