import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int arr [] = new int[N + 1];
        int dp [] = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) arr[i] = Integer.parseInt(br.readLine());

        int ans = -1;

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = 1;
            for (int j = 1 ; j <= i ; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        System.out.print(N - ans);
    }
}