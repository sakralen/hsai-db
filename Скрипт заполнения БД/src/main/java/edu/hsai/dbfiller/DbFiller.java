package edu.hsai.dbfiller;

import java.util.Random;
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

    public static void writePreamble(String path) {
        String preamble = "USE " + DB_NAME + LINE_SEPARATOR + LINE_SEPARATOR;
        writeToFile(preamble, path);
    }

    public static void fillDictionaries(String path) {
        /*PRIORITY 1*/
        for (int i = 0; i < MANUFACTURERS_COUNT; i++) {
            String singleInsert = INSERT_INTO + MANUFACTURER_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + MANUFACTURERS_VALUES[i] + APOSTROPHE + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        for (int i = 0; i < FACTIONS_COUNT; i++) {
            String singleInsert = INSERT_INTO + FACTION_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + FACTION_VALUES[i] + APOSTROPHE + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        for (int i = 0; i < GAME_FIELDS_COUNT; i++) {
            String singleInsert = INSERT_INTO + GAME_FIELD_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + GAME_FIELDS_TYPES_VALUES[i] + APOSTROPHE + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String singleInsert = INSERT_INTO + ROUND_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + ROUNDS_VALUES[i] + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        for (int i = 0; i < MISSION_CARDS_COUNT; i++) {
            String singleInsert = INSERT_INTO + MISSION_CARD_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + MISSION_CARDS_VALUES[i][0] +
                    APOSTROPHE + ", " + APOSTROPHE + MISSION_CARDS_VALUES[i][1] +
                    APOSTROPHE + ", " + MISSION_CARDS_VALUES[i][2] + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        /*PRIORITY 2*/
        for (int i = 0; i < TERRAIN_PIECES_COUNT; i++) {
            String singleInsert = INSERT_INTO + TERRAIN_PIECE_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + TERRAIN_PIECES_VALUES[i][0] +
                    APOSTROPHE + ", " + APOSTROPHE + TERRAIN_PIECES_VALUES[i][1] +
                    APOSTROPHE + ", " + TERRAIN_PIECES_VALUES[i][2] + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        for (int i = 0; i < MINIATURES_COUNT; i++) {
            String singleInsert = INSERT_INTO + MINIATURE_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + MINIATURES_VALUES[i][0]
                    + APOSTROPHE + ", " +
                    Stream.of(MINIATURES_VALUES[i]).skip(1).limit(5)
                            .collect(Collectors.joining(", "))
                    + ")" + ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

        for (int i = 0; i < SQUADS_COUNT; i++) {
            String singleInsert = INSERT_INTO + SQUAD_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + SQUAD_VALUES[i] + APOSTROPHE +
                    ", " + (RANDOM.nextInt(FACTIONS_COUNT) + 1) + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }

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

            String singleInsert = INSERT_INTO + PLAYER_TABLE + LINE_SEPARATOR +
                    VALUES + "(" + APOSTROPHE + name + APOSTROPHE +
                    ", " + APOSTROPHE + surname + APOSTROPHE + ", " +
                    (RANDOM.nextInt(FACTIONS_COUNT) + 1) + ")" +
                    ";" + LINE_SEPARATOR + LINE_SEPARATOR;
            writeToFile(singleInsert, path);
        }
    }

    public static void fillOtherTables(String path) {

    }
}
