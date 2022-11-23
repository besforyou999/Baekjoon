import java.io.*;
import java.util.*;

class Main {
    public static char [] line;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while (true) {
            input = br.readLine();
            if (input == null || input.isBlank() || input.isEmpty())
                break;
            int N = Integer.parseInt(input);
            int SIZE = (int)Math.pow(3, N);
            line = new char[SIZE];
            Arrays.fill(line,' ');

            rec(0, SIZE);

            for (int i = 0 ; i < SIZE ; i++) {
                bw.write(line[i]);
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }

    public static void rec(int idx, int length) {
        if (length == 1) {
            line[idx] = '-';
            return;
        }
        int tri = length / 3;

        int front_idx = idx;
        int back_idx = idx + tri + tri;

        rec(front_idx, length / 3);
        rec(back_idx, length / 3);
    }

}


