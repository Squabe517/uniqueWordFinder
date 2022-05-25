package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Utility to process a document to into sorted set of unique words
 * @author Gaige Wycuff
 */
public class UniqueWords {
    /**
     * Read file then store unique words in alphabetical order
     * @param myfile input file
     * @return sorted set of unique words
     */
    public static Set<String> processDocument(File myfile) {
        String combinedData = "";
        TreeSet<String> parsedData = new TreeSet<>();
        try(Scanner input = new Scanner(myfile)) {
            while (input.hasNext()) {
                String data = input.nextLine();
                combinedData += data;
            }
        } catch(FileNotFoundException ex) {
            System.out.println("Cannot access file: "+myfile);
        }
        String[] tokenizedData = tokenize(combinedData);

        for(String word : tokenizedData) {
            parsedData.add(word);
        }

        return parsedData;

    }

    /**
     * Remove any un-wanted characters then tokenize
     * @param text initial String
     * @return Array of words from initial String
     */
    public static String[] tokenize(String text) {
        text = text.replaceAll("[^a-zA-Z \n]"," ");
        String[] tokenized = text.split(" ");
        for (int i=0; i<tokenized.length; ++i) {
            tokenized[i] = tokenized[i].toLowerCase();
        }
        return tokenized;
    }
}
