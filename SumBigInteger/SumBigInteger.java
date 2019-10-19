import java.math.BigInteger;

public class SumBigInteger {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 0; i < args.length; i++) {
            int j = 0;
            int begin = 0;
            int end = 0;
            while (j < args[i].length()) {
                if (j < args[i].length() && ((args[i].charAt(j) >= '0' && args[i].charAt(j) <= '9') || args[i].charAt(j) == '-')) {
                    begin = j;
                }
                while (j < args[i].length() && ((args[i].charAt(j) >= '0' && args[i].charAt(j) <= '9') || args[i].charAt(j) == '-')) {
                    end = j;
                    j++;
                }
                if (args[i].substring(begin, end + 1).length() > 0 && (args[i].charAt(begin) == '-' || (args[i].charAt(begin) >= '0' && args[i].charAt(begin) <= '9'))) {
                    sum = sum.add(new BigInteger(args[i].substring(begin, end + 1)));
		    begin = end + 1;

                }
                j++;
            }
        }
        System.out.println(sum);
    }
}



