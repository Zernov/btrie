import java.util.ArrayList;

public class Leaf extends Node{

    public int from;
    public int to;
    public ArrayList<String> words;

    public Leaf(int from, int to, ArrayList<String> words) {

        this.from = from;
        this.to = to;
        this.words = new ArrayList<>();
        this.words.addAll(words);
        //TODO: Hybrid/Pure truncate
    }

    public boolean isLeaf() { return true; }

    public boolean isPure() { return from == to; }

    public boolean add(String word) {
        this.words.add(word);
        return words.size() >= 2;
    }

    public String toString() {

        String result = "";
        result += String.valueOf((char)(from + 97)) + "-" + String.valueOf((char)(to + 97)) + " { ";
        for (int i = 0; i < words.size() - 1; i++) {
            result += words.get(i) + ", ";
        }
        if (words.size() > 0) {
            result += words.get(words.size() - 1);
        }
        result += " }\n";
        return result;
    }
}
