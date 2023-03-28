import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int colors[][], dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        colors = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            colors[i][0] = Integer.parseInt(st.nextToken());
            colors[i][1] = Integer.parseInt(st.nextToken());
            colors[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = colors[1][0];
        dp[1][1] = colors[1][1];
        dp[1][2] = colors[1][2];

        for (int i = 2 ; i <= N ; i++) {
            dp[i][0] = colors[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = colors[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = colors[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0 ; i < 3 ; i++) {
            if (min > dp[N][i]) min = dp[N][i];
        }

        System.out.println(min);
    }
}