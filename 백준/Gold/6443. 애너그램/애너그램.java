import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int [] alphabets;
    static char [] input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        alphabets = new int[26];
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int n = 0 ; n < N ; n++) {

            Arrays.fill(alphabets, 0);

            input = br.readLine().toCharArray();

            for (char ch : input) {
                alphabets[ch - 'a'] += 1;
            }

            Arrays.sort(input);

            int len = alphabets.length;

            dfs(new int[len], new char[input.length], 0);
        }

        System.out.print(sb);
    }

    public static void dfs(int [] used, char [] rec, int depth) {
        if (depth == input.length) {
            sb.append(rec).append("\n");
            return;
        }

        for (int i = 0 ; i < alphabets.length ; i++) {
            if (used[i] < alphabets[i]) {
                used[i] += 1;
                rec[depth] = (char)(i + 'a');
                dfs(used, rec, depth + 1);
                used[i] -= 1;
            }
        }
    }

}