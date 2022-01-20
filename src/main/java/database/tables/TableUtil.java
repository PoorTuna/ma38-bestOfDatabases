package database.tables;

import database.objects.OrenDBObj;

import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("ALL")
public class TableUtil {

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
        FileWriter fileWriter = new FileWriter(tbl.getIndexFile(), true);
        fileWriter.write(0 + ":" + obj.getPrimaryKeyValue() +  System.lineSeparator());
        fileWriter.close();
    }

    /**
     * This function updates the table's index file.
     */
    protected void updateIndexFile() {

    }

    protected <T extends OrenDBObj> boolean validateRecord(T obj, Table table) {
        return obj.getVariables().equals(table.getDataFile());
    }

}
