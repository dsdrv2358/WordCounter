package efficiency;



import org.jfree.data.category.DefaultCategoryDataset;

import bst.BSTLyricDatabase;
import hashSetFolder.IntChainedHashSet;

public class GrabBagEfficiencyTest {

    IntChainedHashSet <String> mySet;

    //Measures how long it takes to put one thing in
    public static long timeAPut(IntChainedHashSet<String> mySet){
        long start = System.nanoTime();
        mySet.add("an example string");
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    public static long timeAPull(IntChainedHashSet<String> mySet){
        long start = System.nanoTime();
        mySet.remove("an example string");
        long end = System.nanoTime();
        long runTime = (end - start);
        return runTime;
    }

    //Measures how long it takes on average when you put multiple items in
    public static long averageTimeForAPut(IntChainedHashSet <String> mySet, int numPutsToAverage){
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeAPut(mySet);
        }
        return total/numPutsToAverage;
    }

    public static long averageTimeForAPull(IntChainedHashSet <String> mySet, int numPutsToAverage){
        long total = 0;
        for (int i=0; i<numPutsToAverage; i++){
            total += timeAPull(mySet);
        }
        return total/numPutsToAverage;
    }


    //Put a bunch of items in the bag
    public static void putManyItems(int putCount, IntChainedHashSet <String> mySet) {
        for (int i=0; i<putCount; i++){
            mySet.add("an example string" + Integer.toString(i));
            //This extra integer converted makes sure the hash doesn't put everything in the same bucket
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
        if (!myDb.isEmpty()){
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
        collectGrabBagPutPullData(new IntChainedHashSet<String>(), "IntChainedHashSet",dataset);
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
        
        DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
        DefaultCategoryDataset dataset13 = new DefaultCategoryDataset();       
        collectGrabBagPutPullData(new QueueGrabBag<>(new RightEndListQueue<>()),"RightEndListQueueGrabBag", dataset4,dataset13);
        new EfficiencyChart(dataset4); 
        new EfficiencyChart(dataset13);
    }
    }
    