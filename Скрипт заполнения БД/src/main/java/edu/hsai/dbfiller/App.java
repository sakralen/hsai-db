package edu.hsai.dbfiller;

import static edu.hsai.dbfiller.DbFiller.*;
public class App {
    public static void main(String[] args) {
        String pathToOutputFile = args[0];

//        if (args[1].equals("-i")) { // For given numbers
//            printDictionariesCount();
//            return;
//        }

        if (args[1].equals("-d")) { // For filling dictionaries only
            fillDictionaries(pathToOutputFile);
            return;
        }

        if (args[1].equals("-o")) { // For filling other tables only
            fillOtherTables(pathToOutputFile);
            return;
        }

        if (args[1].equals("-a")) { // For all tables
            fillDictionaries(pathToOutputFile);
            fillOtherTables(pathToOutputFile);
        }
    }
}
