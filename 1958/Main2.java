import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();
        int len3 = str3.length();

        int dp [][][] = new int[len1 + 1][len2 + 1][len3 + 1];

        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                for (int l = 1 ; l <= len3 ; l++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(l-1)) {
                        dp[i][j][l] = dp[i-1][j-1][l-1] + 1;
                    } else {
                        int big = Math.max(Math.max(dp[i-1][j][l], dp[i][j-1][l]), dp[i][j][l-1]);
                        dp[i][j][l] = big;
                    }
                }
            }
        }
        System.out.print(dp[len1][len2][len3]);
    }
}
