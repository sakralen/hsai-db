package edu.hsai.dbfiller;

public class App {
    public static void main(String[] args) {
        String parameter = args[0];
        String path = args.length == 2 ? args[1] : null;
        switch (parameter) {
            case "-i" -> {  // print info
                DbFiller.printDictionariesCount();
            }
            case "-s" -> {  // fill small tables
                DbFiller.writeOpening(path);
                DbFiller.fillSmallTables(path);
                DbFiller.writeClosing(path);
            }
            case "-l" -> {  // fill large tables
                DbFiller.writeOpening(path);
                DbFiller.fillLargeTables(path);
                DbFiller.writeClosing(path);
            }
            case "-a" -> { // fill all tables
                DbFiller.writeOpening(path);
                DbFiller.fillSmallTables(path);
                DbFiller.fillLargeTables(path);
                DbFiller.writeClosing(path);
            }
        }
    }
}
