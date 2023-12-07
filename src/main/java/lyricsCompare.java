import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class lyricsCompare {
    public String getLyrics() {
        // Create a Scanner object to read input
        Scanner scanner = new Scanner(System.in);
        // Prompt the user for input
        System.out.print("Copy/Paste your lyrics here:");
        // Read user input
        String userInput = scanner.nextLine();
        // Display the user input
        System.out.println("You entered: " + userInput);
        // Close the scanner to avoid resource leaks
        scanner.close();      
        
        return userInput;
    }
    public void main(String []args){

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
                    if(PopulateDatabase.rockSet.contains(word)){
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
                    }
                }
            }
        }catch (IOException e){}

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
}