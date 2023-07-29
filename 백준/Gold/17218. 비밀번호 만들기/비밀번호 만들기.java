import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String line2 = br.readLine();
        int N = line1.length();
        int M = line2.length();

        int [][]dp = new int[N + 1][M + 1];

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= M ; j++) {
                if (line1.charAt(i - 1) == line2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int cnt = dp[N][M];
        int row = N;
        int col = M;

        while (cnt > 0) {
            if (dp[row - 1][col] == cnt) {
                row--;
            } else if (dp[row][col - 1] == cnt) {
                col--;
            } else {
                sb.append(line1.charAt(row - 1));
                cnt--;
                row--;
                col--;
            }
        }

        System.out.println(sb.reverse());
    }
}