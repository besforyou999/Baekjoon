import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tri[][] = new int[N+1][N+1];
        int dp[][] = new int[N+1][N+1];

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j < i + 1 ; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = tri[1][1];

        for (int i = 2 ; i <= N ; i++) {
            for (int j = 1 ; j < i + 1 ; j++) {
                if (j == 1) {
                    dp[i][j] = (dp[i-1][j] + tri[i][j] );
                } else if (j == i) {
                    dp[i][j] = (dp[i-1][j-1] + tri[i][j] );
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j];
                }
            }
        }
        int max = -1;
        for (int i = 1 ; i <= N ; i++) {
            max = max < dp[N][i] ? dp[N][i] : max;
        }
        System.out.print(max);
    }
}
