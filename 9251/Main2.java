import java.io.*;
import java.util.*;

public class Main {
    public static String one , two;
    public static int len1, len2;
    public static int [][]dp;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        one = br.readLine();
        two = br.readLine();
        len1 = one.length();
        len2 = two.length();

        dp = new int[len1 + 1][len2 + 1];

        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1 ; j <= len2 ; j++) {
                if (one.charAt(i-1) == two.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.print(dp[len1][len2]);
    }
}
