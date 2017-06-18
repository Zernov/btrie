public class Bucket extends Node {

    public Node[] children;

    public Bucket(Node[] children) {
        this.children = new Node[26];
        for (int i = 0; i < 26; i++) {
            this.children[i] = children[i];
        }
    }

    public boolean isLeaf() { return false; }

    public boolean add(String word) {
        int letter = (int)word.charAt(0) - 97;
        //TODO TRUE RESULT => BALANCE
        return children[letter].add(word);
    }

    public String toString() {

        String result = "";
        for (int i = 0; i < 26; i++) {
            result += String.valueOf((char)(i + 97)) + " -> " + children[i].toString();
        }
        return result;
    }
}
