package userexperience;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

import ichs.ICHSLyricDatabase;
import bst.BSTLyricDatabase;
import interfaces.LyricDatabase;

public class LyricsCompare {

    private static String getLyrics() {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for input
        System.out.print("Copy/Paste your lyrics here:");
        // Read user input
        String userInput = scanner.nextLine();
        // Display the user input
        System.out.println("You entered: " + userInput);
        // Do not close the scanner here to avoid closing System.in
        return userInput;
    }

    public static void score(LyricDatabase<String> rockSet, LyricDatabase<String> rapSet, LyricDatabase<String> countrySet){

        int rock_score = 0;
        int country_score = 0;
        int rap_score = 0;

        
        
        String lyrics = getLyrics();
        String line;

        String newLyrics = WebScraper.cleanLyrics(lyrics);

        try (BufferedReader reader = new BufferedReader(new StringReader(newLyrics))){
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words){
                    if (word.equals(" ")){
                        continue;
                    }
                    if (word.equals("")){
                        continue;
                    }
                    rock_score = rock_score + rockSet.getCount(word);
                    rap_score = rap_score + rapSet.getCount(word);
                    country_score = country_score + countrySet.getCount(word);
                    
                    /*if(PopulateDatabase.rockSet.contains(word)){
                        int numItems = PopulateDatabase.rockSet.getCount(word);
                        rock_score+=numItems;
                    }
                    if(PopulateDatabase.rapSet.contains(word)){
                        int numItems = PopulateDatabase.rapSet.getCount(word);
                        rap_score+=numItems;
                    }
                    if(PopulateDatabase.countrySet.contains(word)){
                        int numItems = PopulateDatabase.countrySet.getCount(word);
                        country_score+=numItems;
                    } */
                }
            }
        }catch (IOException e){}

        System.out.println("rock score: " + rock_score);
        System.out.println("rap score: " + rap_score);
        System.out.println("country score: " + country_score);

        if (rock_score > rap_score && rock_score > country_score){
            System.out.println("This song is rocky");
            }
        if (rap_score > rock_score && rap_score > country_score){
            System.out.println("This song is rap");
            }
        if (country_score > rock_score && country_score > rap_score){
            System.out.println("This song has a lot of voice cracks");
            }              
        
    }




    public static void main(String[] args) {

        LyricDatabase<String> rockSet = new BSTLyricDatabase<String>();
        rockSet.populateDatabase("lyrics/rock_lyrics.txt");

        //System.out.println(rockSet.getNumItems());


        LyricDatabase<String> rapSet = new BSTLyricDatabase<String>();    
        rapSet.populateDatabase("lyrics/rap_lyrics.txt");

        //System.out.println(rapSet.getNumItems());

        LyricDatabase<String> countrySet = new BSTLyricDatabase<String>();
        countrySet.populateDatabase("lyrics/country_lyrics.txt");
        //System.out.println(countrySet.getNumItems());

        LyricsCompare.score(rockSet, rapSet, countrySet);
    }
}

