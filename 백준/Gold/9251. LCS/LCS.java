import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] line1 = br.readLine().toCharArray();
        char [] line2 = br.readLine().toCharArray();

        int len1 = line1.length;
        int len2 = line2.length;

        int [][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1 ; i <= len1 ; i++) {
            for (int j =1 ; j <= len2 ; j++) {
                if (line1[i-1] != line2[j-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        System.out.print(dp[len1][len2]);
    }
}