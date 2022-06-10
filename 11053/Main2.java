import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int Ai[] = new int[n+1];
        int dp[] = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= n ; i++)
            Ai[i] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= n ; i++) {
            dp[i] = 1;
            for (int j = 1 ; j <= i ; j++) {
                if (Ai[i] > Ai[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        int max = -1;

        for (int i = 1 ; i <= n ; i++) if (max < dp[i]) max = dp[i];

        System.out.print(max);
    }
}
