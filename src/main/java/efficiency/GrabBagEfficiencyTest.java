package efficiency;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jfree.data.category.DefaultCategoryDataset;

import bst.BSTLyricDatabase;
import ichs.ICHSLyricDatabase;
import interfaces.LyricDatabase;

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
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //DefaultCategoryDataset dataset9 = new DefaultCategoryDataset();
        collectGrabBagPutPullData(new ICHSLyricDatabase<String>(), "IntChainedHashSet",dataset);
        new EfficiencyChart(dataset);
        //new EfficiencyChart(dataset9);
        
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        // DefaultCategoryDataset dataset10 = new DefaultCategoryDataset();
        collectGrabBagPutPullData(new BSTLyricDatabase<String>(), "BST", dataset2);
        new EfficiencyChart(dataset2);
        //new EfficiencyChart(dataset10);

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
        LyricDatabase<String> rapTree = new BSTLyricDatabase<String>();


        DefaultCategoryDataset datasetICHS1 = new DefaultCategoryDataset();
        DefaultCategoryDataset datasetBST1 = new DefaultCategoryDataset();
        timePopulateMicro(rapSet, "ICHSLyricDatabase", "lyrics/rap_lyrics.txt", datasetICHS1);
        timePopulateMicro(rapTree, "BSTLyricDatabase", "lyrics/rap_lyrics.txt", datasetBST1);
        new EfficiencyChart(datasetICHS1);
        new EfficiencyChart(datasetBST1);

    }
    }
    