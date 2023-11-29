package a.k.l;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    public static void main(String[] args) {
        // List of URLs to scrape
        List<String> urls = new ArrayList<>();
        urls.add("https://genius.com/Chris-cagle-laredo-lyrics");
        urls.add("https://genius.com/Alan-jackson-country-boy-lyrics");
        urls.add("https://genius.com/Greater-bakersfield-show-interview-w-dwight-yoakam-dave-alvin-lyrics");
        urls.add("https://genius.com/The-oak-ridge-boys-trying-to-love-two-women-lyrics");
        urls.add("https://genius.com/Chris-cagle-laredo-lyrics");
        urls.add("https://genius.com/Merle-haggard-if-we-re-not-back-in-love-by-monday-lyrics");
        urls.add("https://genius.com/Jason-aldean-tonight-looks-good-on-you-lyrics");
        urls.add("https://genius.com/George-strait-baby-s-gotten-good-at-goodbye-lyrics");
        urls.add("https://genius.com/Moe-bandy-bandy-the-rodeo-clown-lyrics");
        urls.add("https://genius.com/Brooks-dunn-reba-mcentire-cowgirls-don-t-cry-lyrics");
        urls.add("https://genius.com/Earl-thomas-conley-holding-her-and-loving-you-lyrics");
        urls.add("https://genius.com/Kenny-chesney-everybody-wants-to-go-to-heaven-lyrics");
        urls.add("https://genius.com/George-jones-the-window-up-above-lyrics");
        urls.add("https://genius.com/The-judds-love-can-build-a-bridge-lyrics");
        urls.add("https://genius.com/Carrie-underwood-jesus-take-the-wheel-lyrics");
        urls.add("https://genius.com/Tom-t-hall-ravishing-ruby-lyrics");
        urls.add("https://genius.com/Tim-mcgraw-my-little-girl-lyrics");
        // Add more URLs to the list...

        // Iterate through the list of URLs
        for (String url : urls) {
            try {
                // Connect to the website and get the HTML document
                Document document = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                        .get();
                Element lyricsRootDiv = document.select("div#lyrics-root").first();

                // Check if the div is found
                if (lyricsRootDiv != null) {
                    // Extract and print the text content from the div
                    String textContent = lyricsRootDiv.text();
                    System.out.println(textContent);
                } else {
                    System.out.println("Div with ID 'lyrics-root' not found on the page for URL: " + url);
                }

                // Print the entire HTML content

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

