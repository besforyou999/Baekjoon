import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[302];
        int dp[] = new int[302];

        for (int i = 1 ; i <= N ; i++) a[i] = Integer.parseInt(br.readLine());

        dp[1] = a[1];
        dp[2] = Math.max(a[2], dp[1] + a[2]);

        for (int i = 3 ; i <= N ; i++) dp[i] = Math.max(dp[i-3] + a[i-1] + a[i], dp[i-2] + a[i]);

        System.out.print(dp[N]);
    }
}
