package a.k.l;


public class WordItem<T> implements Comparable<WordItem<T>>{

    private T item;
    private WordItem<T> next;
    private int count;

    public WordItem(T item){
        this.item = item;
        this.next = null;
        this.count = 1;
    }

    @Override
    public int compareTo(WordItem<T> arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}