import java.io.*;
import java.util.*;

public class Main {
    static int n,k;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int coin_value[] = new int[n];
        for (int i = 0 ; i < n ; i++) {
            coin_value[i] = Integer.parseInt(br.readLine());
        }

        int dp[] = new int[10001];

        dp[0] = 1;

        for (int i = 0 ; i < n ; i++) {
            for (int j = coin_value[i]; j <= k ; j++) {
                dp[j] += dp[j-coin_value[i]];
            }
        }

        System.out.print(dp[k]);
    }
}
