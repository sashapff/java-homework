import java.util.ArrayList;
import java.util.Collections;import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<String>> a = new ArrayList<>();
        while (sc.hasNextLine()) {
            ArrayList<String> b = new ArrayList<>();
            String s = sc.nextLine();
            int begin = 0;
            int end = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '-' || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                    end++;
                } else {
                    if (!s.substring(begin, end).equals("")) {
                        b.add(s.substring(begin, end));
                    }
                    begin = i + 1;
                    end = i + 1;
                }
            }
            b.add(s.substring(begin, end));
            Collections.reverse(b);
            a.add(b);
        }
        Collections.reverse(a);
        for (ArrayList<String> b : a) {
            for (String ss : b) {
                System.out.print(ss + " ");
            }
            System.out.println();
        }
    }
}



