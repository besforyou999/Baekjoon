import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int DIV = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n <= 3) {
            System.out.println(n);
            return;
        }

        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4 ; i <= n ; i++) 
            dp[i] = (dp[i-1] + dp[i-2]) % DIV;
        
        System.out.println(dp[n]);
    }
}