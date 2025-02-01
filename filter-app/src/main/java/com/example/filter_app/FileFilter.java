package com.example.filter_app;


import java.io.BufferedReader; 
import java.io.FileReader; // 
import java.io.IOException; // 
import java.util.List; // 

public class FileFilter {
    
    public void filterFile(String inputFile, List<Integer> integers, List<Float> floats, List<String> strings) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) { 
            String line; 
            
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                try {
                	if (line.contains(".")) {
                		floats.add(Float.parseFloat(line));
                		continue;
                	}
                	
                    integers.add(Integer.parseInt(line));
                    
                } catch (NumberFormatException e) {
                    strings.add(line);
                }
            }
            
        }
    }
}