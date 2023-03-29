import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char [] line1;
    static char [] line2;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        line1 = a.toCharArray();
        line2 = b.toCharArray();

        dp = new int[line1.length + 1][line2.length + 1];

        for (int i = 1 ; i <= line1.length ; i++) {
            for (int j = 1 ; j <= line2.length ; j++) {
                if (line1[i-1] != line2[j-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
            }
        }

        System.out.println(dp[line1.length][line2.length]);
    }
}