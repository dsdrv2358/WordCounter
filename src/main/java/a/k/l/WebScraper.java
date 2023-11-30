package a.k.l;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class WebScraper {

    public static void main(String[] args) {
        List<String> urls = readUrlsFromFile("country_urls.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("country_lyrics.txt"))) {
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
}
