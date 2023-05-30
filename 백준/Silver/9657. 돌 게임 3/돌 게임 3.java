import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean [] dp = new boolean[1001];

        dp[1] = dp[3] = dp[4] = true;

        for (int i = 5 ; i < 1001 ; i++) {
            if (dp[i - 1] && dp[i - 3] && dp[i - 4])
                dp[i] = false;
            else
                dp[i] = true;
        }

        System.out.print(dp[N] ? "SK" : "CY");
    }
}