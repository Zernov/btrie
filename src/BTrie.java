import java.util.ArrayList;

public class BTrie {

    private TrieNode root;

    public void add(String item) {
        root.add(item, "");
    }

    public BTrie() {
        this.root = new TrieNode();
    }
}