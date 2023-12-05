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
            for (String url : urls) {
                try {
                    Document document = Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                            .get();
                    Element lyricsRootDiv = document.select("div#lyrics-root").first();

                    if (lyricsRootDiv != null) {
                        String textContent = lyricsRootDiv.text();
                        String myCleanLyrics = cleanLyrics(textContent);
                        // where to input function to clean text
                        writer.write(myCleanLyrics);
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

        // removes all punc from lyrics string
        String processedLyrics = lyrics.replaceAll("[^a-zA-Z\\s]", "").toLowerCase().replaceAll("\\b\\d+\\b", "");
        // Remove extra whitespaces
        processedLyrics = processedLyrics.replaceAll("\\s+", " ").trim();

        //splits the string into a list of words
        String return_string = "";
        for (String word : processedLyrics.split("\\s+")) {
            // checks if word is bracketed, "Contributers, or "Embed" and other common words and does nothing if it is
            if ("chorus".equals(word) || "verse".equals(word) || "contributors".equals(word) || "embed".equals(word)
            || "a".equals(word) || "the".equals(word) || "and".equals(word) || "know".equals(word) || "like".equals(word)
            || "oh".equals(word) || "love".equals(word) || "go".equals(word) || "yeah".equals(word) || "time".equals(word) || "see".equals(word)
            || "got".equals(word) || "get".equals(word) || "wanna".equals(word) || "let".equals(word) || "never".equals(word) || "want".equals(word)
            || "feel".equals(word) || "one".equals(word) || "cause".equals(word) || "make".equals(word) || "say".equals(word) || "baby".equals(word)
            || "if".equals(word) || "on".equals(word) || "in".equals(word) || "that".equals(word) || "then".equals(word) || "i".equals(word)
            || "me".equals(word) || "to".equals(word) || "we".equals(word) || "do".equals(word) || "it".equals(word) || "is".equals(word)
            || "are".equals(word) || "when".equals(word) || "your".equals(word) || "two".equals(word) || "u".equals(word) || "be".equals(word)) {
            }
            // if word not caught above add string to lyrics
            else{
                return_string = return_string + " " + word;
            }
        }
        return return_string;
    }
}
