
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebScraperTests {
    
    @Test
    public void cleanLyricsTest(){
        String test_string = "11 Contributors Country Boy Lyrics [Verse 1] Excuse me ma'am, I saw you wred dirt city streets, down winding 1 Embed";

        assertEquals("country boy lyrics excuse me maam i saw you dirt city streets down winding", WebScraper.cleanLyrics(test_string));
    }
}
