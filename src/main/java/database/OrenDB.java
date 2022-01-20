package database;

import database.tables.Table;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Data
public class OrenDB extends OrenDBUtil{
    private String absPath;
    private File metadata;
    private Map<String, Table> tables;

    public OrenDB(dbBuilder dbBuilder) throws IOException {
        this.metadata = dbBuilder.metadata;
        this.tables = dbBuilder.tables;
        this.absPath = dbBuilder.absPath;

        if(this.tables == null){
            this.tables = new HashMap<>(){{

            }};
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
        File tempFolder = new File(this.absPath + "\\tables\\" + name);
        tempFolder.mkdir();
        Table tempTable = new Table(name, this.absPath + "\\tables\\" + name);
        this.tables.put(tempTable.getName(), tempTable);
        //Todo : update the metadata file.
        this.metadataInsertTable(this, tempTable);
    }

    public String removeTable(String name) throws IOException {
        if (tables.containsKey(name)){
            this.tables.get(name).removeFiles();
            this.tables.remove(name);

            File tempFolder = new File(this.absPath + "\\tables\\" + name);
            tempFolder.delete();

            return "Table : " + name + " removed successfully";
        }
        return "Invalid table!";
    }


    public static class dbBuilder{
        public File metadata;
        public Map<String, Table> tables;
        public String absPath;

        public dbBuilder(String absPath){
            this.absPath = absPath;
        }
        public dbBuilder addTable(Table table){
            this.tables.put(table.getName(), table);
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
