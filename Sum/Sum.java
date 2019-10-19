public class Sum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            int j = 0;
            int cur = 0;
            boolean flag = false;
            while (j < args[i].length()) {
                if (args[i].charAt(j) == '-') {
                    flag = true;
                }
                if (args[i].charAt(j) >= '0' && args[i].charAt(j) <= '9') {
                    cur *= 10;
                    cur += (int) (args[i].charAt(j) - '0');
                } else {
                    if (flag) {
                        sum -= cur;
                    } else {
                        sum += cur;
                    }
                    cur = 0;
                }
                if (args[i].charAt(j) != '-' && !(args[i].charAt(j) >= '0' && args[i].charAt(j) <= '9')) {
                    flag = false;
                }
                j++;
            }
            if (flag) {
                sum -= cur;
            } else {
                sum += cur;
            }
            cur = 0;
        }
        System.out.println(sum);
    }
}



