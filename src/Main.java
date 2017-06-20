public class Main {

    public static void main(String[] args) {
        BTrie btrie = new BTrie();
        System.out.println(btrie.toString());
        btrie.add("masha");
        System.out.println(btrie.toString());
        btrie.add("lesha");
        System.out.println(btrie.toString());
    }
}