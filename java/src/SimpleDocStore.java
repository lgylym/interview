import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lgylym on 14-11-13.
 * design a simple document store, with put and search functionality
 */

class Document {
    int docID;
    static String[] content;

    public Document(int docID, String[] content) {
        this.docID = docID;
        this.content = content;
    }
}


public class SimpleDocStore {

    HashMap<String, ArrayList<Integer>> index;

    public SimpleDocStore() {
        index = new HashMap<String, ArrayList<Integer>>();
    }

    public void addDocument(Document d) {
        if(d == null || d.content == null || d.content.length == 0) {
            return;
        }
        for(String word:d.content) {
            if(!index.containsKey(word)) {
                index.put(word, new ArrayList<Integer>());
            }
            ArrayList<Integer> docList = index.get(word);
            docList.add(d.docID);
        }
    }

    public ArrayList<Integer> search(String word) {
        if(word == null || word.length() == 0 || !index.containsKey(word)) {
            return null;
        }
        return index.get(word);
    }

    public static void main(String[] args) {
        SimpleDocStore store = new SimpleDocStore();
        String[] a = {"this","is","a","doc"};
        String[] b = {"this","another","doc"};
        store.addDocument(new Document(1, a));
        store.addDocument(new Document(2, b));
        System.out.println(store.search("this"));
        System.out.println(store.search("another"));
    }

}
