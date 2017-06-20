import java.util.ArrayList;

public class BTrie {

    private Bucket root;

    public void add(String item) {
        root.add(item);
    }

    public BTrie() {
        Node leaf = new Leaf(0, 127, new ArrayList<>());
        Node[] children = new Node[128];
        for (int i = 0; i < 128; i++) {
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