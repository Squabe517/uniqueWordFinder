package com.company;

import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String fname = "src/files/";

        System.out.println("Welcome to my text processor, please drop the file you want to work with in the files folder.\n\n");
        do {
            System.out.print("What file would you like to work with: ");
            fname += input.nextLine() + ".txt";

            File myfile = new File(fname);
            Set<String> uniques = UniqueWords.processDocument(myfile);
            for (String s : uniques) {
                System.out.println(s);
            }
            System.out.println("This File Contains "+uniques.size()+" unique words\n");

            System.out.print("Would you like to try an additional file(y/n)? ");
            String goAgain = input.nextLine();

            if(goAgain.equalsIgnoreCase("n")) {
                break;
            }
            fname = "src/files/";
        } while(true);

    }
}
