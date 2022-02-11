import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[1001][3];
        int a[][] = new int[N+1][3];

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i <= N ; i++) {
            dp[i][0] = Min(dp[i-1][1], dp[i-1][2]) + a[i][0];
            dp[i][1] = Min(dp[i-1][0], dp[i-1][2]) + a[i][1];
            dp[i][2] = Min(dp[i-1][0], dp[i-1][1]) + a[i][2];
        }

        int min = Min( Min(dp[N][0], dp[N][1]), dp[N][2]);
        System.out.print(min);
    }

    public static int Min(int a, int b) {return a < b ? a : b;}
}
