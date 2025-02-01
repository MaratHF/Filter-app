package com.example.filter_app;

import java.io.BufferedWriter; 
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.List; 

public class FileCreater {
    
	public void createFile(String outputDir, String prefix, List<Integer> integers, List<Float> floats, List<String> strings, boolean append) throws IOException {
        // Запись целых чисел
        if (!integers.isEmpty()) {
            writeListToFile(outputDir, prefix + "integers.txt", integers, append);
        }

        // Запись дробных чисел
        if (!floats.isEmpty()) {
            writeListToFile(outputDir, prefix + "floats.txt", floats, append);
        }

        // Запись строк
        if (!strings.isEmpty()) {
            writeListToFile(outputDir, prefix + "strings.txt", strings, append);
        }
    }

    private <T> void writeListToFile(String outputDir, String fileName, List<T> list, boolean append) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputDir + "/" + fileName, append))) {
            for (T item : list) {
                writer.write(item.toString()); 
                writer.newLine(); 
            }
        }
    }
}

	
    