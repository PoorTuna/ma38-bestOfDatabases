package database;

import database.tables.Table;

import java.io.File;
import java.util.List;

public class DB {
    private File metadata;
    private List<Table> tables;

    public DB(dbBuilder dbBuilder){
        this.metadata = dbBuilder.metadata;
        this.tables = dbBuilder.tables;
    }

    public void updateTable(){

    }

    public void removeTable(){

    }

    public void createTable(){

    }


    public static class dbBuilder{
        public File metadata;
        public List<Table> tables;

        public dbBuilder addTable(Table table){
            this.tables.add(table);
            return this;
        }

        public dbBuilder setMetadata(File metadata){
            this.metadata = metadata;
            return this;
        }

        public DB build() {
            DB database =  new DB(this);
            validateDBObject(database);
            return database;
        }

        private void validateDBObject(DB database) {

        }

    }



}
