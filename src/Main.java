import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File file = new File("D:\\Projects\\meow\\src\\data.txt");
        ArrayList<String> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String item;
            while ((item = br.readLine()) != null) {
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BTrie btrie = new BTrie();
        for (String item: items) {
            btrie.add(item);
        }
        System.out.println(btrie.has("sha-julin.livejournal.com"));
    }
}