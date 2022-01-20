package database;

import database.tables.Table;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class OrenDBUtil {

    /**
     * This function adds the table to the db metadata file.
     */
    public void metadataInsertTable(OrenDB orenDB, Table tbl) throws IOException {
        FileWriter fileWriter = new FileWriter(orenDB.getMetadata());
        fileWriter.write(tbl.getName() + ":" + getDirectorySize(tbl.getPath()) + System.lineSeparator());

        fileWriter.close();
    }
    public void metadataRemoveTable(){

    }

    // size of directory in bytes
    public static long getDirectorySize(String path) {

        long size = 0;

        // need close Files.walk
        try (Stream<Path> walk = Files.walk(Path.of(path))) {

            size = walk
                    //.peek(System.out::println) // debug
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            System.out.printf("Failed to get size of %s%n%s", p, e);
                            return 0L;
                        }
                    })
                    .sum();

        } catch (IOException e) {
            System.out.printf("IO errors %s", e);
        }

        return size;

    }
}
