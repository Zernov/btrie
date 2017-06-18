public class Bucket extends Node {

    private Node[] child;

    public Bucket(Node[] child) {
        for (int i = 0; i < 26; i++) {
            this.child[i] = child[i];
        }
    }

    public boolean isLeaf() { return false; }
}
