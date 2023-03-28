import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dp [] = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;

        for (int i = 11 ; i <= 100 ; i++) dp[i] = dp[i-1] + dp[i-5];

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }

        System.out.print(sb);
    }
}