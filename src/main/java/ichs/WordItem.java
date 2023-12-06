package ichs;
import java.util.ArrayList;

public class WordItem{

    private String item;
    private WordItem next;
    private int count;

    public WordItem(String item){
        this.item = item;
        this.next = null;
        this.count = 1;
    }


    public ArrayList<String> getChain(){
        ArrayList<String> wordList = new ArrayList<>();
        wordList = this.getChain(wordList);
        return wordList;

    }
    public ArrayList<String> getChain(ArrayList<String> wordList){
        wordList.add(this.item);
        if (this.next != null){
            this.next.getChain(wordList);
        }
        return wordList;
    }

    public void increaseCount(){
        this.count++;
    }

    public String getItem(){
        return this.item;
    }

    public WordItem getNext(){
        return this.next;
    }

    public void setNext(WordItem next){
        this.next = next;
    }

    public int getCount(){
        return this.count;
    }

}