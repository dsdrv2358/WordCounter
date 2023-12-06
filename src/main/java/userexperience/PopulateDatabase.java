package userexperience;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import bst.BSTLyricDatabase;
import ichs.ICHSLyricDatabase;

public class PopulateDatabase {

    static ICHSLyricDatabase rockSet = makeTheSet("lyrics/rock_lyrics.txt");
    static ICHSLyricDatabase rapSet = makeTheSet("lyrics/rap_lyrics.txt");
    static ICHSLyricDatabase countrySet = makeTheSet("lyrics/country_lyrics.txt");

    public static void main(String[] args) {
        String inputFilePath = "lyrics/rock_lyrics.txt";
        String outputFilePath = "lyrics/test.txt";

        ICHSLyricDatabase<String> mySet = new ICHSLyricDatabase<String>(10000);
// BSTLyricDatabase<String> mySet = new BSTLyricDatabase<String>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            int count = 0;
            // Read each line from the file
            while ((line = reader.readLine()) != null && count < 150000) {
                // Split the line into words using whitespace
                String[] words = line.split("\\s+");
                for (String word : words) {
                    count++;
                    mySet.add(word);
                }
            }


        } catch (IOException e) {
        }
        System.out.println(mySet.getNumItems());
        System.out.println(mySet.getCount("hat"));
    }


    public static ICHSLyricDatabase<String> makeTheSet(String inputFilePath){
        String outputFilePath = "lyrics/test.txt";

        ICHSLyricDatabase<String> mySet = new ICHSLyricDatabase<String>(10000);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            int count = 0;
            // Read each line from the file
            while ((line = reader.readLine()) != null && count < 150000) {
                // Split the line into words using whitespace
                String[] words = line.split("\\s+");
                for (String word : words) {
                    count++;
                    mySet.add(word);
                }
            }


        } catch (IOException e) {
        }
        return mySet;
    }

}

