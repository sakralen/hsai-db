package edu.hsai.dbfiller;

import static edu.hsai.dbfiller.DbFiller.*;

public class App {
    public static void main(String[] args) {
        switch (args[0]) {
            case "-i" -> printDictionariesCount(); // print info
            case "-s" -> fillSmallTables(args[1]); // fill small tables
            case "-l" -> fillLargeTables(args[1]); // fill large tables
            case "-a" -> { // fill all tables
                fillSmallTables(args[1]);
                fillLargeTables(args[1]);
            }
        }
    }
}
