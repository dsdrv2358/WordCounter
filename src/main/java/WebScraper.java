import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class WebScraper {

    public static void main(String[] args) {
        List<String> urls = readUrlsFromFile("urls/country_urls.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("lyrics/country_lyrics.txt"))) {
            int counter = 0;
            for (String url : urls) {
                if (counter >= 10) {
                    break; // Exit the loop after five iterations
                }
                try {
                    Document document = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                            .get();
                    Element lyricsRootDiv = document.select("div#lyrics-root").first();

                    if (lyricsRootDiv != null) {
                        String textContent = lyricsRootDiv.text();
                        // where to input function to clean text
                        writer.write(textContent);
                        writer.newLine();
                    } else {
                        System.out.println("Div with ID 'lyrics-root' not found on the page for URL: " + url);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to read URLs from a file
    private static List<String> readUrlsFromFile(String filePath) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                urls.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }


    public static String cleanLyrics(String lyrics) {
        System.out.println(lyrics);

        // removes all punc from lyrics string
        // String regex = "[!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~0-9]";
        String regex = "[!\"#$%&'()*+,./:;<=>?@^_`{|}~0123456789]";
        lyrics = lyrics.replaceAll(regex, "");

        //splits the string into a list of words
        String[] splitStr = lyrics.split("\\s+");
        String return_string = "";

        // steps through 
        for (int i = 0; i > splitStr.length ; i++){
            // create var of word to compare
            String word = splitStr[i];
            // checks if word is bracketed, "Contributers, or "Embed" and other common words and does nothing if it is
            if (word == "Chorus" || word == "Verse" || word == "Contributors" || word == "Embed"
            || word == "a" || word == "the" || word == "and" || word == "know" || word == "like"
            || word == "oh" || word == "love" || word == "go" || word == "yeah" || word == "time" || word == "see"
            || word == "got" || word == "get" || word == "wanna" || word == "let" || word == "never" || word == "want"
            || word == "feel" || word == "one" || word == "cause" || word == "make" || word == "say" || word == "baby"
            || word == "if" || word == "on" || word == "in" || word == "that" || word == "then" || word == "i"
            || word == "me" || word == "to" || word == "we" || word == "do" || word == "it" || word == "is"
            || word == "are" || word == "when" || word == "your" || word == "two" || word == "u" || word == "be"){
            }
            // if word not caught above add string to lyrics
            else{
                return_string += word + " ";
            }


        }
        return return_string;
    }


}
