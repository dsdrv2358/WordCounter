import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PopulateDatabase {

    public static void main(String[] args) {
        String inputFilePath = "lyrics/rap_lyrics.txt";
        String outputFilePath = "lyrics/test.txt";

        IntChainedHashSet<String> mySet = new IntChainedHashSet<String>(10000);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            int count = 0;
            // Read each line from the file
            while ((line = reader.readLine()) != null && count < 150000) {
                // Split the line into words using whitespace
                String[] words = line.split("\\s+");

                // Iterate through each word
                for (String word : words) {
                    count++;
                    mySet.add(word);
                }
            }


        } catch (IOException e) {
        }
        System.out.println(mySet.getNumItems());
        System.out.println(mySet.getCount("fuck"));
    }

}

