package database;

import database.tables.Table;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrenDB {
    private String absPath;
    private File metadata;
    private List<Table> tables;

    public OrenDB(dbBuilder dbBuilder) throws IOException {
        this.metadata = dbBuilder.metadata;
        this.tables = dbBuilder.tables;
        this.absPath = dbBuilder.absPath;

        if(this.tables == null){
            this.tables = new ArrayList<>();
        }
        if(this.metadata == null){
            this.metadata = new File(this.absPath + "\\db_metadata.data");
        }

        this.createFiles();
    }

    public void createFiles() throws IOException {
        File temp = new File(absPath + "\\tables");
        temp.mkdir();
        this.metadata.createNewFile();
    }
    /**
     * This function creates a new table, adds it to the metadata, adds it to the table list.
     */
    public void createTable(String name) throws IOException {
        File tempFile = new File(this.absPath + "\\tables\\" + name);
        tempFile.mkdir();
        Table tempTable = new Table(name, this.absPath + "\\tables\\" + name, new File(this.absPath + "\\tables\\" + name + "\\tb_metadata.data"));
        this.tables.add(tempTable);
        //Todo : update the metadata file.
    }

    public void updateTable(){

    }

    public void removeTable(){

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

        public OrenDB build() throws IOException {
            //validateDBObject(database);
            return new OrenDB(this);
        }

        private void validateDBObject(OrenDB database) {

        }

    }



}
