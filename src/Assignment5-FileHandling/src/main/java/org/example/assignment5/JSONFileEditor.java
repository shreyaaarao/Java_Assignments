package org.example.assignment5;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONFileEditor {
    public static void main(String[] args) {
        // Replace "path_to_input_file.json" with the actual path of the JSON file
        String inputFilePath = "C:\\Users\\237868\\IdeaProjects\\Java-Assignments\\src\\main\\resources\\input.json";

        // Replace "path_to_output_folder/output.json" with the desired output file location
        String outputFilePath = "C:\\Users\\237868\\IdeaProjects\\Java-Assignments\\src\\main\\resources\\output.json";

        try {
            // Read JSON file
            String jsonContent = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // Parse JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonContent);

            // Edit values of any two keys
            ((ObjectNode) rootNode).put("name", "gomathi");
            ((ObjectNode) rootNode).put("skill", ".Net");

            // Add two additional keys and their values
            ((ObjectNode) rootNode).put("salary", "5000");
            ((ObjectNode) rootNode).put("lastname", "S");

            // Write JSON to output file
            objectMapper.writeValue(new File(outputFilePath), rootNode);

            System.out.println("Output file saved successfully at: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
