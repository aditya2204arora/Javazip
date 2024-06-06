import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MapDataToZip {

    public static void main(String[] args) {
        // Create a map to store data
        Map<String, String> mapData = new HashMap<>();
        mapData.put("key1", "value1");
        mapData.put("key2", "value2");
        // Add more data as needed

        // Specify the path for the output ZIP file
        String zipFilePath = "map_data.zip";

        try {
            // Create a FileOutputStream to write data to the ZIP file
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            // Create a ZipOutputStream to write ZIP entries
            ZipOutputStream zos = new ZipOutputStream(fos);

            // Iterate over the map entries and add them to the ZIP file
            for (Map.Entry<String, String> entry : mapData.entrySet()) {
                // Create a new ZipEntry for the map entry
                ZipEntry zipEntry = new ZipEntry(entry.getKey() + ".txt");
                // Add the ZipEntry to the ZipOutputStream
                zos.putNextEntry(zipEntry);
                // Write the map value to the ZipOutputStream
                zos.write(entry.getValue().getBytes());
                // Close the current ZipEntry
                zos.closeEntry();
            }

            // Close the ZipOutputStream
            zos.close();

            System.out.println("Map data has been successfully written to the ZIP file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
