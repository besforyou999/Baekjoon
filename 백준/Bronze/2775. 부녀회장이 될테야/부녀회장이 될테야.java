import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int dp [][] = new int[16][16];

        for (int room = 1 ; room <= 15 ; room++) {
            dp[0][room] = room;
            dp[room - 1][1] = 1;
        }

        for (int level = 1 ; level <= 14 ; level++) {
            for (int room = 2 ; room <= 14 ; room++) {
                dp[level][room] = dp[level][room - 1] + dp[level - 1][room];
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while( T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append("\n");
        }

        System.out.print(sb);
    }
}