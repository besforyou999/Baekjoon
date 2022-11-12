import java.io.*;
import java.util.*;

public class Main {
    public static String one , two, three;
    public static int len1, len2, len3;
    public static int [][][]dp;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        one = br.readLine();
        two = br.readLine();
        three = br.readLine();

        len1 = one.length();
        len2 = two.length();
        len3 = three.length();

        dp = new int[len1 + 1][len2 + 1][len3 + 1];

        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1 ; j <= len2 ; j++) {
                for (int k = 1 ; k <= len3 ; k++) {
                    if ((one.charAt(i-1) == two.charAt(j-1)) && (two.charAt(j-1) == three.charAt(k-1))){
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        int val = 0;
                        if (val < dp[i-1][j][k]) val = dp[i-1][j][k];
                        if (val < dp[i][j-1][k]) val = dp[i][j-1][k];
                        if (val < dp[i][j][k-1]) val = dp[i][j][k-1];
                        dp[i][j][k] = val;
                    }
                }
            }
        }

        System.out.print(dp[len1][len2][len3]);
    }
}
