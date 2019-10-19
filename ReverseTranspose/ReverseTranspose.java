import java.util.ArrayList;
import java.util.Scanner;

public class ReverseTranspose {
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
            if (!s.substring(begin, end).equals("")) {
                b.add(s.substring(begin, end));
            }
            a.add(b);
        }
        int max = 0;
        for (int i = 0; i < a.size(); i++) {
            max = Math.max(max, a.get(i).size());
        }
        for (int j = 0; j < max; j++) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i).size() > j) {
                    System.out.print(a.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}



