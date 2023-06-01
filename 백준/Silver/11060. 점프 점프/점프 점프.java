import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] ai = new int[N + 1];
        int [] dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 1 ; n <= N ; n++) {
            ai[n] = Integer.parseInt(st.nextToken());
        }

        dp[0] = dp[1] = 0;

        for (int i = 1 ; i <= N ; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 1 ; j <= ai[i] ; j++) {
                if (i + j > N) continue;
                dp[i+j] = Math.min(dp[i+j] , dp[i] + 1);
            }
        }

        if (dp[N] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N]);
        }
    }
}