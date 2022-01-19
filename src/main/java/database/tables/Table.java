package database.tables;

import java.io.File;
import java.util.Map;

public class Table {

    private String path;
    private File dataFile;
    private File indexFile;
    private File metaData;

    /**
     * This function gets an object to insert, validates the contents, adds it to the table data and updates the metadata.
     */
    public <T> void insert(T obj) {

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
     * @return
     */
    public Map<String, String> select(String columnName) {
        return null;
    }

    /**
     * This function takes the files and combines it into a single map which contains the table data.
     * @return
     */
    public Map<String, String> selectAll() {
        return null;
    }

}
