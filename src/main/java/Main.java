import database.OrenDB;
import database.objects.dbObjExamples.Person;
import database.tables.Table;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        OrenDB orenDB = new OrenDB.dbBuilder("src\\dbs\\OrenDB").build();
        orenDB.createTable("xd", new Person("car", null, null, null, null));
        Table monkey = orenDB.getTables().get("xd");
        for (int i = 0; i < 100; i++) {
            monkey.insert(new Person("car", "Audi" + i, "oren" + i, i, "Audi" + i));
        }

    }
}
