package com.example.filter_app;

import org.apache.commons.cli.*; 

import java.util.ArrayList; 
import java.util.List; 

public class Main {
    
    public static void main(String[] args) {  	
        Options options = createOptions();
        CommandLine cmd = parseCommandLine(options, args);
        if (cmd == null) 
        	return;
        
        String outputDir = cmd.getOptionValue('o', ".");
        String prefix = cmd.getOptionValue('p', "");
        boolean append = cmd.hasOption("a");
        boolean shortStats = cmd.hasOption('s');
        boolean fullStats = cmd.hasOption('f');
        
        List<String> inputFiles = getInputFiles(cmd);

        fileProcessing(inputFiles, outputDir, prefix, append, shortStats, fullStats);
    }
    
    private static Options createOptions() {
    	Options options = new Options();
        options.addOption("o", "output", true, "Output directory (default: current directory)"); 
        options.addOption("p", "prefix", true, "File prefix (default: no prefix)");
        options.addOption("a", "append", false, "Append to existing files (default: overwrite)"); 
        options.addOption("s", "short", false, "Display short statistics"); 
        options.addOption("f", "full", false, "Display full statistics"); 
        return options;
    }
    
    private static CommandLine parseCommandLine(Options options, String[] args) {
    	CommandLineParser parser = new DefaultParser();
    	try {
    		return parser.parse(options, args);
    	} catch (ParseException e) {
    		System.out.println("Error parsing command line: " + e.getMessage());
        	printHelp(options);
        	return null;
    	}
    }
    
    private static List<String> getInputFiles(CommandLine cmd) {
    	List<String> inputFiles = new ArrayList<>();
    	String[] files = cmd.getArgs();
    	
    	for (String file : files) {
    		inputFiles.add(file);
    	}
    	
    	if (inputFiles.isEmpty()) {
    		System.out.println("No input files");
    	}
    	return inputFiles;
    }
    
    private static void fileProcessing(List<String> inputFiles, String outputDir,String prefix, boolean append, boolean shortStats, boolean fullStats) {
    	FileFilter fileFilter = new FileFilter(); 
        FileCreater fileCreater = new FileCreater(); 
        Statistics statistics = new Statistics(); 
        
        List<Integer> integers = new ArrayList<>(); 
        List<Float> floats = new ArrayList<>(); 
        List<String> strings = new ArrayList<>();
        
        for (String file : inputFiles ) {
        	try {
        		fileFilter.filterFile(file, integers, floats, strings);
        	} catch (Exception e) {
        		System.out.println("Error processing file: " + e.getMessage());
        	}
        }
        
        try {
        	fileCreater.createFile(outputDir, prefix, integers, floats, strings, append);
        } catch (Exception e) {
        	System.out.println("Error creating output file: " + e.getMessage());
        }
        
        statistics.displayStatistics(integers, floats, strings, shortStats, fullStats);
    }

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter(); 
        formatter.printHelp("filter-app.jar", options);
    }
}