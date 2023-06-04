import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int MAX = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] boj = br.readLine().split("");

        int []dp = new int[N + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;

        for (int i = 0 ; i < boj.length - 1; i++) {
            String letter = boj[i];
            for (int j = i + 1 ; j < boj.length ; j++) {
                int val = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                if (letter.equals("B")) {
                    if (boj[j].equals("O")) {
                        dp[j] = val;
                    }
                } else if (letter.equals("O")) {
                    if (boj[j].equals("J")) {
                        dp[j] = val;
                    }
                } else if (letter.equals("J")) {
                    if (boj[j].equals("B")) {
                        dp[j] = val;
                    }
                }
            }
        }

        if (dp[N - 1] == MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }

    }
}