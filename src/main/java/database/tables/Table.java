package database.tables;

import database.objects.OrenDBObj;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Data
public class Table extends TableUtil{

    private String name;
    private String path;
    private File dataFile; //Todo : turn into a list
    private File indexFile; //Todo : turn into a list
    private File metaData;

    public Table(String name, String path, File metaData) throws IOException {
        this.name = name;
        this.path = path;
        this.metaData = metaData;

        this.dataFile = new File(this.path + "\\data.db");
        this.indexFile = new File(this.path + "\\index.data");

        this.createFiles();

    }
    private void createFiles() throws IOException {
        this.dataFile.createNewFile();
        this.indexFile.createNewFile();
        this.metaData.createNewFile();
    }

    //Todo: add last file object that will monitor current state of data file?

    /**
     * This function gets an object to insert, validates the contents, adds it to the table data and updates the metadata.
     */
    public <T extends OrenDBObj> void insert(T obj){

    }

    /**
     * This function takes a column id and data. The function checks input validity, changes the value in the table and updates the metadata.
     */
    public void update(String columnName, String value) {

    }

    /**
     * This function takes a record primary key and checks if it exists in the index files. if it does it removes it from the records, metadata and index.
     */
    public void remove(String primaryKey) {

    }

    /**
     * This function takes a given primary key and returns the whole record if it finds it in the index file.
     *
     * @return
     */
    public Map<String, String> select(String columnName) {
        return null;
    }

    /**
     * This function takes the files and combines it into a single map which contains the table data.
     *
     * @return
     */
    public Map<String, String> selectAll() {
        return null;
    }

}
