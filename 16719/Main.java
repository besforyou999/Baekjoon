import java.io.*;
import java.util.*;

class Main {
    public static BufferedReader br;
    public static BufferedWriter bw;

    static String input;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();
        visited = new boolean[input.length()];

        rec(0, input.length() - 1);

        bw.flush();
        bw.close();
    }

    public static void rec(int left, int right) throws IOException {
        if (left > right) return;

        int idx = left;

        for (int i = left ; i <= right ; i++) {
            if (input.charAt(idx) > input.charAt(i)) {
                idx = i;
            }
        }

        visited[idx] = true;

        for (int i = 0 ; i < input.length() ; i++) {
            if (visited[i])
                bw.write(input.charAt(i));
        }
        bw.newLine();

        rec(idx + 1, right);
        rec(left, idx - 1);
    }
}

