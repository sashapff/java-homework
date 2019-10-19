import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WordStatIndex {

    public static String s;
    public static HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
    public static ArrayList<String> a = new ArrayList<>();
    public static int number = 0;

    public static void changeValue(String p) {
        if (!p.equals("")) {
            if (hm.containsKey(p)) {
                number++;
                hm.get(p).add(number);
            } else {
                hm.put(p, new ArrayList<>());
                number++;
                hm.get(p).add(number);
                a.add(p);
            }
        }
    }

    public static void main(String[] args) {
        hm = new HashMap<>();
        a = new ArrayList<>();
        number = 0;
        if (args.length != 2) {
            System.out.println("Not enough arguments");
        }
        FastScanner in;
        in = new FastScanner(System.in);
        while (in.hasNextLine()) {
            s = in.nextLine();
            s = s.toLowerCase();
            FastScanner fs = new FastScanner(s);
            while (fs.hasNextLine()) {
                String word = fs.nextWord();
                changeValue(word);



            }
        }
        PrintWriter out;
        out = new PrintWriter(System.out);
        for (String i : a) {
            out.print(i + " " + hm.get(i).size());
            for (int cnt : hm.get(i)) {
                out.print(" " + cnt);
            }
            out.println();
        }
        out.close();
    }
}
