import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long dp [] = new long[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        dp[4] = 11;

        for (int i = 5 ; i <= 1000 ; i++) {
            dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
        }

        System.out.print(dp[n]);
    }
}