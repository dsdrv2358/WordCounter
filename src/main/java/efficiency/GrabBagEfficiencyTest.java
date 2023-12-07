package efficiency;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import org.jfree.data.category.DefaultCategoryDataset;

import bst.BSTLyricDatabase;
import ichs.ICHSLyricDatabase;
import interfaces.LyricDatabase;
import userexperience.WebScraper;

public class GrabBagEfficiencyTest {

    ICHSLyricDatabase <String> mySet;

    //Measures how long it takes to put one thing in
    public static long timeAPut(LyricDatabase<String> mySet){
        long start = System.nanoTime();
        mySet.add("an example string");
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    // public static long timeAPull(IntChainedHashSet<String> mySet){
    //     long start = System.nanoTime();
    //     mySet.remove("an example string");
    //     long end = System.nanoTime();
    //     long runTime = (end - start);
    //     return runTime;
    // }

    //Measures how long it takes on average when you put multiple items in
    public static long averageTimeForAPut(LyricDatabase <String> mySet, int numPutsToAverage){
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeAPut(mySet);
        }
        return total/numPutsToAverage;
    }

    // public static long averageTimeForAPull(IntChainedHashSet <String> mySet, int numPutsToAverage){
    //     long total = 0;
    //     for (int i=0; i<numPutsToAverage; i++){
    //         total += timeAPull(mySet);
    //     }
    //     return total/numPutsToAverage;
    // }


    
    public static void scoreTime(LyricDatabase<String> rock, LyricDatabase<String> rap, LyricDatabase<String> country, String datasetType, DefaultCategoryDataset dataset){

        int rock_score = 0;
        int country_score = 0;
        int rap_score = 0;
        int count = 0;
        String lyrics = "stairway heaven lyrics intro theres lady whos sure all glitters gold shes buying stairway heaven she gets there she knows stores all closed with word she can what she came for ooh ooh shes buying stairway heaven theres sign wall but she wants sure you sometimes words have meanings tree by brook theres songbird who sings sometimes all of our thoughts misgiven ooh makes wonder ooh makes wonder theres feeling look west my spirit crying for leaving my thoughts have seen rings of smoke through trees voices of those who stand looking ooh makes wonder ooh really makes wonder you might also its whispered soon all call tune piper will lead us reason new day will dawn for those who stand long forests will echo with laughter ohohohohwoahhh theres bustle hedgerow dont alarmed now its just spring clean for may queen yes there paths you can by but long run theres still change road youre makes wonder ohh woah head humming wont case you dont pipers calling you join him dear lady can you hear wind blow did you stairway lies whispering wind guitar solo bridge as wind down road our shadows taller than our soul there walks lady all who shines white light wants show how everything still turns gold you listen very hard tune will come you at last all all rock not roll outro shes buying stairway heaven translations espaol hey jude lyrics hey jude dont bad take sad song better remember her into heart you can start better hey jude dont afraid you were made out her minute you her under skin you begin better bridge anytime you pain hey jude refrain dont carry world upon shoulders for well you its fool who plays cool by making his world little colder nanananana nananana hey jude dont down you have found her now her out remember hey jude her into heart you can start better you might also bridge so out hey jude begin youre waiting for someone perform with dont you its just you hey jude youll movement you need shoulder nanananana nananana hey jude dont bad take sad song better remember her under skin youll begin woah fucking hell better better better better better better outro yeahyeahyeahyeahyeahyeah nanananananana nananana hey jude nanananananana nananana hey jude nanananananana nananana hey jude nanananananana nananana hey jude jude judy judy judy judy judy ow wow nanananananana nanana nananana hey jude jude jude jude jude jude nanananananana nananana hey jude you you can jude jude youre not gonna break nana dont bad jude nanananana take sad song better nananana hey jude hey jude hey jude wow nanananananana nananana hey jude nanananananana nananana hey jude jude jude jude jude jude jude nanananananana nananana hey jude nanananananana nananana hey jude nananananananananananana nanananananana nananana hey jude nanananananana nananana hey jude nanananananana jude nananana hey jude yeahyeahyeahyeah nanananananana nananana hey jude listen ya mamamamamamamama nanananananana nananana hey jude nanananananana nananana hey jude you cant always what you lyrics intro london bach choir saw her today at reception glass of wine her hand knew she would meet her connection at her feet was footloose man no you cant always what you you cant always what you you cant always what you but you try sometime youll find you what you need saw her today at reception glass of wine her hand knew she was gonna meet her connection at her feet was footloose man you cant always what you you cant always what you you cant always what you but you try sometimes well you might find you what you need ahh yeahhh rolling stones live tickets as low as you might also went down demonstration my fair share of abuse singing were gonna vent our frustration dont were going blow amp fuse sing honey you cant always what you you cant always what you you cant always what you but you try sometimes well you just might find you what you need ah ahh went down chelsea drugstore prescription filled was standing line with mr jimmy man did he look pretty ill decided would have soda my favorite flavor cherry red sung my song mr jimmy he said word was dead said him you cant always what you well no you cant always what you tell you you cant always what you no but you try sometime you just might find uh mm you what you need woo woo you what you need ow ah saw her today at reception her glass was bleeding man she was practiced at art of deception well could tell by her bloodstained hands sing outro you cant always what you you cant always what you ooh child you cant always what you but you try sometime you just might find you just might find you what you need ah ah wooh ah you cant always what you no no you cant always what you you cant now now you cant always what you mmm but you try sometime you just might find you just might find you what you need ah ah";
        String line;
        String newLyrics = WebScraper.cleanLyrics(lyrics);
        try (BufferedReader reader = new BufferedReader(new StringReader(newLyrics))){
            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\s+");
                for (String word : words){ 
                    long start = System.nanoTime();
                    if (word.equals(" ")){
                        continue;
                    }
                    if (word.equals("")){
                        continue;
                    }
                    count++;
                    rock_score = rock_score + rock.getCount(word);
                    rap_score = rap_score + rap.getCount(word);
                    country_score = country_score + country.getCount(word);
                    long end = System.nanoTime();
                    long runTime = (end - start);
                    dataset.addValue( runTime, datasetType, String.valueOf(count));
                }
            }
        }catch (IOException e){}
    }




    //Put a bunch of items in the bag
    public static void putManyItems(int putCount, LyricDatabase <String> mySet) {
        for (int i=0; i<putCount; i++){
            mySet.add("an example string" + Integer.toString(i));
            //This extra integer converted makes sure the hash doesn't put everything in the same bucket
        }
    }

        /* Calculates the average time to add one item for every one thousand items added */
    public static void timePopulateMicro(LyricDatabase<String> mySet, String datasetType, String filename, DefaultCategoryDataset dataset){
        ArrayList<Long> runTimes = new ArrayList<Long>();
        long totalRunTime = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null && count < 150000) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    count++;
                    if (word.length() > 3){ 
                        long start = System.nanoTime();
                        mySet.add(word);
                        long end = System.nanoTime();
                        long runTime = (end - start);
                        totalRunTime += runTime;
                    }
                    if (count % 1000 == 0){
                        totalRunTime = totalRunTime/1000;
                        runTimes.add(totalRunTime);
                        dataset.addValue( totalRunTime, datasetType, String.valueOf(count) );
                        totalRunTime = 0;
                    }
                }
            }
        } catch (IOException e) {
        }
    }

    // public static void pullManyItems(int putCount, IntChainedHashSet <String> mySet) {
    //     for (int i=0; i<putCount; i++){
    //         mySet.remove();
    //     }
    // }

    //Goes through a loop where it displays the average time each set of items takes to put in, increasing the number of items by 1 each time
    //and multiplying it presumably so that we can understand the data and give the graph a shape
    public static void collectGrabBagPutPullData(LyricDatabase<String> myDb, String dataStructure,DefaultCategoryDataset dataset/* , DefaultCategoryDataset dataset1*/){
        if (myDb.getNumItems()!=0){
            throw new RuntimeException("Test output is not acurate starting on bag with items");
        }
        final int numItemsToPutEachTime = 10000;
        final int numDataPointsToPrint = 50;
        final int numToAverageOver = 500;

        System.out.println("Testing " + dataStructure);
        System.out.println("Items in bag \t time to add a new item");
        for(int i=0; i<numDataPointsToPrint; i++){
            putManyItems(numItemsToPutEachTime, myDb);
            double avgTime = averageTimeForAPut(myDb, numToAverageOver);
            //System.out.println((i+1)*numItemsToPutEachTime + " \t\t " + avgTime);
            String item_num = String.valueOf((i+1));
            dataset.addValue(avgTime, dataStructure, item_num);
            //How do I get a chart out of this??
        }
        // System.out.println("Items in bag \t time to remove a new item");
        // for(int i=0; i<numDataPointsToPrint; i++){
        //     pullManyItems(numItemsToPutEachTime, mySet);
        //     double avgTime = averageTimeForAPull(mySet, numToAverageOver);
        //     //System.out.println((i+1)*numItemsToPutEachTime + " \t\t " + avgTime);
        //     String item_num = String.valueOf((i+1));
        //     dataset1.addValue(avgTime, dataStructure, item_num);
        // }
    }

    //Create the grabBag data to test
     
    public static void main(String[] args){
       /* DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //DefaultCategoryDataset dataset9 = new DefaultCategoryDataset();
        collectGrabBagPutPullData(new ICHSLyricDatabase<String>(), "IntChainedHashSet",dataset);
        new EfficiencyChart(dataset);
        //new EfficiencyChart(dataset9);
        
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        // DefaultCategoryDataset dataset10 = new DefaultCategoryDataset();
        collectGrabBagPutPullData(new BSTLyricDatabase<String>(), "BST", dataset2);
        new EfficiencyChart(dataset2);
        //new EfficiencyChart(dataset10);
        */
        // DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        // DefaultCategoryDataset dataset11 = new DefaultCategoryDataset();
        // collectGrabBagPutPullData(new StackGrabBag<>(new LeftTopListStack<>()), "LeftTopListStackGrabBag",dataset2,dataset11);
        // new EfficiencyChart(dataset2);
        // new EfficiencyChart(dataset11);

        // DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        // DefaultCategoryDataset dataset12 = new DefaultCategoryDataset();
        // collectGrabBagPutPullData(new QueueGrabBag<>(new LeftEndListQueue<>()),"LeftEndListQueueGrabBag",dataset3,dataset12);
        // new EfficiencyChart(dataset3);     
        // new EfficiencyChart(dataset12);

        //Transparency



        LyricDatabase<String> rapSet = new ICHSLyricDatabase<String>(10000);
        LyricDatabase<String> rockSet = new ICHSLyricDatabase<String>(10000);
        LyricDatabase<String> countrySet = new ICHSLyricDatabase<String>(10000);

        LyricDatabase<String> rapTree = new BSTLyricDatabase<String>();
        LyricDatabase<String> rockTree = new BSTLyricDatabase<String>();
        LyricDatabase<String> countryTree = new BSTLyricDatabase<String>();


        DefaultCategoryDataset datasetICHS1 = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetBST1 = new DefaultCategoryDataset();
        timePopulateMicro(rapSet, "ICHSLyricDatabase", "lyrics/rap_lyrics.txt", datasetICHS1);
        timePopulateMicro(rapTree, "BSTLyricDatabase", "lyrics/rap_lyrics.txt", datasetBST1);
        new EfficiencyChart(datasetICHS1);
        new EfficiencyChart(datasetBST1);



        LyricDatabase<String> rapSet2 = new ICHSLyricDatabase<String>(10000);
        rapSet2.populateDatabase("lyrics/rap_lyrics.txt");
        LyricDatabase<String> rockSet2 = new ICHSLyricDatabase<String>(10000);
        rockSet2.populateDatabase("lyrics/rock_lyrics.txt");
        LyricDatabase<String> countrySet2 = new ICHSLyricDatabase<String>(10000);
        countrySet2.populateDatabase("lyrics/country_lyrics.txt");



        LyricDatabase<String> rapTree2 = new BSTLyricDatabase<String>();
        rapTree2.populateDatabase("lyrics/rap_lyrics.txt");

        System.out.println("TREEEEEE:" + rapTree2);


    



        LyricDatabase<String> rockTree2 = new BSTLyricDatabase<String>();
        rockTree2.populateDatabase("lyrics/rock_lyrics.txt");
        LyricDatabase<String> countryTree2 = new BSTLyricDatabase<String>();
        countryTree2.populateDatabase("lyrics/country_lyrics.txt");


        DefaultCategoryDataset datasetICHS2 = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetBST2 = new DefaultCategoryDataset();


        scoreTime(rockSet2, rapSet2, countrySet2, "ICHS", datasetICHS2);



        scoreTime(rockTree2, rapTree2, countryTree2, "TREE", datasetBST2);
        new EfficiencyChart(datasetICHS2);
        new EfficiencyChart(datasetBST2);


    }
    }
    