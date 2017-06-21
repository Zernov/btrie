public class BTrie {

    private TrieNode root;

    public void add(String item) {
        root.add(item, "");
    }

    public boolean has(String item) {
        return root.has(item);
    }

    public BTrie() {
        this.root = new TrieNode();
    }
}