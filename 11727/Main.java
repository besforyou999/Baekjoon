import java.io.*;

public class Main {
    final static int DIV = 10007;
    static int n;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n <= 3) {
            System.out.print(n*2 - 1);
            return;
        }

        int dp[] = new int[n+1];

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;

        for (int i = 4 ; i <= n ; i++) dp[i] = ( dp[i-1] + dp[i-2] * 2 ) % DIV;

        System.out.print(dp[n]);
    }
}
