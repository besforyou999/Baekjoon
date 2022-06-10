import java.io.*;

public class Main {
    static int DIV = 10007;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if ( n <= 3 ) {
            System.out.print(n);
            return;
        }

        int dp[] = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4 ; i <= n ; i++) dp[i] = ( dp[i-1] + dp[i-2] ) % DIV;

        System.out.print(dp[n]);
    }
}
