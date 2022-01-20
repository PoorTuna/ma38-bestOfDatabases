package database.tables;

import database.objects.FileLimiter;
import database.objects.OrenDBObj;

import java.io.*;

@SuppressWarnings("ALL")
public class TableUtil {
    FileLimiter limiter = new FileLimiter(100);
    /**
     * This function creates a metadata file for the table
     */
    protected void createMetaDataFile(Table tbl) throws IOException {
        FileWriter fileWriter = new FileWriter(tbl.getMetaData());
        fileWriter.write("colCount:" + tbl.getObjModel().getVariablesNames().split(",").length + "," +
                "rowCount: 0" + System.lineSeparator());
        fileWriter.write(tbl.getObjModel().getVariablesNames() + System.lineSeparator());
        fileWriter.close();
    }

    /**
     * This function updates the table's metadata file.
     */
    //TODO : Needs to update db metadata as well.
    protected void updateMetaDataFile() {

    }

    /**
     * This function creates a formatted index file.
     */
    protected <T extends OrenDBObj> void addIndex(Table tbl, T obj) throws IOException {
        // if already exists throw an exception
        //String
        if (this.validatePrimaryKey(this.loadFile(tbl.getIndexFile()), obj)) {
            FileWriter fileWriter = new FileWriter(tbl.getIndexFile(), true);
            fileWriter.write(limiter.getRecordCount() + ":" + obj.getPrimaryKeyValue() + System.lineSeparator());
            limiter.increment();
            fileWriter.close();
        }
        else{
            throw new IOException();
        }

    }

    protected <T extends OrenDBObj> String removeIndex(Table tbl, T obj) throws IOException {

        String line;
        while ((line = loadFile(tbl.getIndexFile()).readLine()) != null) {
            if (line.split(":")[1].equals(obj.getPrimaryKeyValue())){
                line.trim();
                return line.split(":")[0];
            }
        }
        return "null";

    }

    /**
     * This function updates the table's index file.
     */
    protected void updateIndexFile() {

    }

    protected <T extends OrenDBObj> boolean validateRecord(T obj, Table table) {
        return obj.getVariables().equals(table.getDataFile());
    }

    protected BufferedReader loadFile(File file) throws IOException {
        return new BufferedReader(new FileReader(file));
    }

    protected <T extends OrenDBObj> boolean validatePrimaryKey(BufferedReader indexFile, T obj) throws IOException {
        String line;
        while ((line = indexFile.readLine()) != null) {
            if (line.split(":")[1].equals(obj.getPrimaryKeyValue())){
                return false;
            }
        }
        return true;
    }

}
