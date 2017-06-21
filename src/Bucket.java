import java.util.ArrayList;
import java.util.Collections;

public class Bucket extends Node{

    public int from;
    public int to;
    public String prefix;
    public ArrayList<String> items;

    public Bucket(int from, int to, String prefix, ArrayList<String> items) {
        this.from = from;
        this.to = to;
        this.prefix = prefix;
        this.items = new ArrayList<>();
        if (this.from == this.to) {
            this.prefix += items.get(0).charAt(0);
            for (int i = 0; i < items.size(); i++) {
                String item = items.get(i).substring(1);
                if (item.length() == 0) {
                    Global.hash.put(this.prefix, this.prefix.length());
                } else {
                    this.items.add(item);
                }
            }
        } else {
            this.items.addAll(items);
        }
        Collections.sort(this.items);
    }

    public boolean isBucket() {
        return true;
    }

    public boolean isPure() {
        return from == to;
    }

    public boolean add(String item, String prefix) {
        this.items.add(item);
        Collections.sort(this.items);
        return this.items.size() > 1;
    }
}
