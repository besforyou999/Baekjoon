import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[91];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 5;

        for (int i = 6; i <= 90 ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }

}