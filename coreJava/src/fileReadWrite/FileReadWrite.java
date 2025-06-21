package filereadwrite;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class FileReadWrite {
    public static void main(String[] args) {

        // 1. TEXT FILE (Write and Read)
        String textFile = "src/filereadwrite/sample.txt"; 
        // Writing a new text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write("Java File I/O");
            writer.newLine();
            writer.write("This is a plain text file.");
        } catch (IOException e) {
            System.out.println("Error writing text file: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) { // Reading the text file
            System.out.println("Reading from text file:");
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading text file: " + e.getMessage());
        }

        // 2. CSV FILE
        String csvFile = "src/filereadwrite/data.csv";
        // Writing a new CSV file
        try (PrintWriter pw = new PrintWriter(csvFile)) {
            pw.println("ID,Name");
            pw.println("1,Piyush");
            pw.println("2,Atharva");
            pw.println("3,Shashwat");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) { // Reading the CSV file
            System.out.println("\nCSV Contents:");
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }

        // 3. JSON FILE
        String jsonFile = "src/filereadwrite/employee.json";
        JSONObject employee = new JSONObject();
        employee.put("id", 101);
        employee.put("name", "Piyush");
        employee.put("department", "Engineering");
        employee.put("skills", new JSONArray(Arrays.asList("Java", "SQL", "Python")));

        // Writing a new JSON file
        try (FileWriter writer = new FileWriter(jsonFile)) {
            writer.write(employee.toString(4)); 
            System.out.println("\nJSON File written: " + jsonFile);
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
        
        System.out.println("\nReading JSON file:");
        // Reading the JSON file
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFile)));
            System.out.println(jsonContent);
        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }


        // 4. DIRECTORY OPERATIONS
        File dir = new File("src/filereadwrite/outputfolder");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("\nDirectory created: " + dir.getName());
            }
        }

        // 5. Copy files to outputfolder
        try {
            Files.copy(Paths.get(textFile), Paths.get("src/filereadwrite/outputfolder/sample.txt"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(csvFile), Paths.get("src/filereadwrite/outputfolder/data.csv"), StandardCopyOption.REPLACE_EXISTING);
            Files.copy(Paths.get(jsonFile), Paths.get("src/filereadwrite/outputfolder/employee.json"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\nFiles copied to outputFolder.");
        } catch (IOException e) {
            System.out.println("Error copying files: " + e.getMessage());
        }
        
        // 6. Listing contents of the directory
        File[] contents = dir.listFiles();
        System.out.println("\nContents of " + dir.getName() + ":");
        if (contents != null && contents.length == 0) {
            System.out.println("(empty)");
        } else if (contents != null) {
            for (File file : contents) {
                System.out.println(file.getName());
            }
        }
    }
}