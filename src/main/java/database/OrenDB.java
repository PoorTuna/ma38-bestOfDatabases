package database;

import database.tables.Table;

import java.io.File;
import java.util.List;

public class OrenDB {
    private String absPath;
    private File metadata;
    private List<Table> tables;

    public OrenDB(dbBuilder dbBuilder){
        this.metadata = dbBuilder.metadata;
        this.tables = dbBuilder.tables;
        this.absPath = dbBuilder.absPath;
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
        public String absPath;

        public dbBuilder(String absPath){
            this.absPath = absPath;
        }
        public dbBuilder addTable(Table table){
            this.tables.add(table);
            return this;
        }

        public dbBuilder setMetadata(File metadata){
            this.metadata = metadata;
            return this;
        }

        public dbBuilder setAbsPath(String path){
            this.absPath = path;
            return this;
        }

        public OrenDB build() {
            //validateDBObject(database);
            return new OrenDB(this);
        }

        private void validateDBObject(OrenDB database) {

        }

    }



}
