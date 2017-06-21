import java.util.HashMap;

public class Global {

    final public static int FROM = 33;
    //final public static int FROM = 97;
    final public static int TO = 127;
    //final public static int TO = 122;
    final public static int SIZE = TO - FROM + 1;
    final public static int CAP = 100;
    public static HashMap<String, Integer> hash = new HashMap<>();
}