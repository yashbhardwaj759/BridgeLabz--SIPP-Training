package JavaRegexAndJunit;

public package com.junit.examples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcessor {
    
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }
    
    public String readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                if (reader.ready()) {
                    content.append(System.lineSeparator());
                }
            }
            return content.toString();
        }
    }
    
    public boolean fileExists(String filename) {
        return Files.exists(Paths.get(filename));
    }
} {
    
}
