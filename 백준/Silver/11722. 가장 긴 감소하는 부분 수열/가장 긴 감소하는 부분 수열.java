import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        for (int i = 1 ; i <= n ; i++) arr[i] = Integer.parseInt(st.nextToken());

        int dp[] = new int[n + 1];

        int ans = -1;

        for ( int i = 1 ; i <= n ; i++) {
            dp[i] = 1;
            for (int j = 1 ; j <= i ; j++) {
                if (dp[i] < dp[j] + 1 && arr[i] < arr[j]) {
                    dp[i] = dp[j] + 1;
                }
            }

            if (ans < dp[i]) {
                ans = dp[i];
            }
        }

        System.out.print(ans);
    }
}