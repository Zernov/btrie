public abstract class Node {
    public abstract boolean isBucket();
    public abstract boolean add(String item, String prefix);
    public abstract boolean has(String item, String prefix);
}
