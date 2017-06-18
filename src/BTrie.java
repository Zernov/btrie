import java.util.ArrayList;

public class BTrie {

    private Bucket root;

    public void add(String word) {
        root.add(word);
    }

    public BTrie() {
        Node leaf = new Leaf(0, 25, new ArrayList<>());
        Node[] children = new Node[26];
        for (int i = 0; i < 26; i++) {
            children[i] = leaf;
        }
        this.root = new Bucket(children);
    }

    private boolean isValid() {
        return true;
    }

    private void balance() {
        //TODO
    }

    public String toString() {
        return root.toString();
    }
}