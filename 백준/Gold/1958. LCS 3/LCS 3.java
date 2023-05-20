import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String line2 = br.readLine();
        String line3 = br.readLine();

        int [][][]dp = new int[line1.length() + 1][line2.length() + 1][line3.length() + 1];


        for (int i = 1 ; i <= line1.length() ; i++) {
            for (int j = 1 ; j <= line2.length() ; j++) {
                for (int l = 1 ; l <= line3.length() ; l++) {
                    if (line1.charAt(i - 1) == line2.charAt(j - 1) && line2.charAt(j - 1) == line3.charAt(l - 1)) {
                        dp[i][j][l] = dp[i-1][j-1][l-1] + 1;
                    } else {
                        dp[i][j][l] = Math.max(Math.max(dp[i-1][j][l], dp[i][j-1][l]), dp[i][j][l-1]);
                    }
                }
            }
        }

        System.out.println(dp[line1.length()][line2.length()][line3.length()]);
    }
}