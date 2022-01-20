import database.OrenDB;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        OrenDB orenDB = new OrenDB.dbBuilder("src\\dbs\\OrenDB").build();
        orenDB.createTable("xd");
    }
}
