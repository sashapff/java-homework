import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.Character.DASH_PUNCTUATION;

public class FastScanner {

    InputStream inputStream;
    int size = 2048;
    byte[] bytes = new byte[size * 2];
    int cur = 0;
    String string = "";

    public FastScanner(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public FastScanner(String s) {
        inputStream = new ByteArrayInputStream(s.getBytes());
    }

    public FastScanner(FileInputStream fileInputStream) {
        inputStream = fileInputStream;
    }

    int j = -1;
    int last = 0;

    public void read() {
        int cnt = 0;
        string = "";
        while (cnt == 0 && string.length() == 0) {
            try {
                cnt = inputStream.read(bytes, last, size);
            } catch (IOException e) {
                System.out.println("Can't read");
            }
            cnt = cnt + last;
            j = cnt - 1;
            while (j >= 0 && isMeaningful(bytes[j])) {
                j--;
            }
            try {
                string = new String(bytes, 0, Math.max(j, 0), "UTF8");
            } catch (UnsupportedEncodingException e) {
                System.out.println("Encoding error");
                return;
            }
            if (j > 0) {
                last = 0;
                for (int i = 0; i < cnt - j; i++) {
                    bytes[i] = bytes[i + j];
                    last++;
                }
            }
            cur = 0;
        }
        if (cnt == -1) {
            try {
                string = new String(bytes, 0, last, "UTF8");
            } catch (UnsupportedEncodingException e) {
                System.out.println("Encoding error");
                return;
            }
            cur = 0;
            last = 0;
        }
    }

    public boolean isMeaningful(byte b) {
        return (((1 << 7) & b) == (1 << 7)) && !(((1 << 6) & b) == (1 << 6));
    }

    public boolean isEmpty() {
        return !(cur < string.length());
    }

    public String nextLine() {
        if (isEmpty()) {
            read();
        }
        StringBuilder sb = new StringBuilder("");
        while (!isEmpty() && string.charAt(cur) != '\n' && string.charAt(cur) != '\r') {
            sb.append(string.charAt(cur));
            cur++;
            if (isEmpty()) {
                read();
            }
        }
        if (!isEmpty()) {
            cur++;
        }
        return sb.toString();
    }

    public String nextToken() {
        if (isEmpty()) {
            read();
        }
        StringBuilder sb = new StringBuilder("");
        while (!isEmpty() && !Character.isWhitespace(string.charAt(cur))) {
            sb.append(string.charAt(cur));
            cur++;
            if (isEmpty()) {
                read();
            }
        }
        if (!isEmpty()) {
            cur++;
        }
        return sb.toString();
    }

    public String nextWord() {
        if (isEmpty()) {
            read();
        }
        StringBuilder sb = new StringBuilder("");
        char letter = string.charAt(cur);
        while (!isEmpty() && (Character.isLetter(letter) || letter == '\''
                || Character.getType(letter) == DASH_PUNCTUATION)) {
            sb.append(string.charAt(cur));
            cur++;
            if (isEmpty()) {
                read();
            }
            if (!isEmpty()) {
                letter = string.charAt(cur);
            }
        }
        if (isEmpty()) {
            read();
        }
        if (!isEmpty()) {
            cur++;
        }
        return sb.toString();
    }

    public int nextInt() throws NumberFormatException {
        return Integer.parseInt(nextToken());
    }

    public boolean hasNextLine() {
        if (isEmpty()) {
            read();
        }
        return !isEmpty();
    }

}
