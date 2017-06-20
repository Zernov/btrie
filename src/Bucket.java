public class Bucket extends Node {

    public Node[] children;

    public Bucket(Node[] children) {
        this.children = new Node[128];
        for (int i = 0; i < 128; i++) {
            this.children[i] = children[i];
        }
    }

    public boolean isLeaf() { return false; }

    public boolean add(String item) {
        int ascii = (int)item.charAt(0);
        //TODO TRUE RESULT => BALANCE
        return children[ascii].add(item);
    }

    public String toString() {

        String result = "";
        for (int i = 0; i < 128; i++) {
            result += String.valueOf((char)(i)) + " -> " + children[i].toString();
        }
        return result;
    }
}
