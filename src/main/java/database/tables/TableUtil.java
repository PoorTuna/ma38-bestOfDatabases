package database.tables;

import database.objects.OrenDBObj;

public class TableUtil {

    /**
     * This function creates a metadata file for the table
     */
    protected void createMetaDataFile(){

    }

    /**
     * This function updates the table's metadata file.
     */
    //TODO : Needs to update db metadata as well.
    protected void updateMetaDataFile(){

    }

    /**
     * This function creates a formatted index file.
     */
    protected void createIndexFile(){

    }

    /**
     * This function updates the table's index file.
     */
    protected void updateIndexFile(){

    }

    protected <T extends OrenDBObj> boolean validateRecord(T obj, Table table){
        return obj.getVariables().equals(table.getDataFile());
    }

}
