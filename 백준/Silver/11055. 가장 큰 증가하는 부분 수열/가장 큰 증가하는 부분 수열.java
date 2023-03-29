import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int Ai[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Ai = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++)
            Ai[i] = Integer.parseInt(st.nextToken());

        int ans = -1;

        int dp [] = new int[N + 1];

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = Ai[i];
            for (int j = 1 ; j <= i ; j++) {
                if (dp[i] < dp[j] + Ai[i] && Ai[j] < Ai[i]) {
                    dp[i] = dp[j] + Ai[i];
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        System.out.print(ans);
    }
}