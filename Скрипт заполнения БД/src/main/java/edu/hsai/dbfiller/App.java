package edu.hsai.dbfiller;

import static edu.hsai.dbfiller.DbFiller.*;

public class App {
    public static void main(String[] args) {
        String parameter = args[0];
        String path = args.length == 2 ? args[1] : null;
        switch (parameter) {
            case "-i" -> {  // print info
                printDictionariesCount();
            }
            case "-s" -> {  // fill small tables
                writeOpening(path);
                fillSmallTables(path);
            }
            case "-l" -> {  // fill large tables
                writeOpening(path);
                fillLargeTables(path);
            }
            case "-a" -> { // fill all tables
                writeOpening(path);
                fillSmallTables(path);
                fillLargeTables(path);
            }
        }
    }
}
