import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] Ti;
    static int [] Pi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Ti = new int[N + 2];
        Pi = new int[N + 2];

        int dp [] = new int[N + 2];

        for (int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }

        int ans = -1;

        for (int i = 0 ; i <= N; i++) {
            ans = Math.max(ans, dp[i]);

            int next = i + Ti[i];
            if (next <= N) {
                dp[next] = Math.max(dp[next], ans + Pi[i]);
            }
        }

        System.out.println(ans);
    }
}