import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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

        int x = line1.length;
        int y = line2.length;

        Stack<Character> stack = new Stack<>();

        while (x != 0 && y != 0) {
            if (line1[x - 1] == line2[y - 1]) {
                stack.push(line1[x-1]);
                x--;
                y--;
            } else if (dp[x][y] == dp[x-1][y]) {
                x--;
            } else if (dp[x][y] == dp[x][y-1]) {
                y--;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(dp[len1][len2]);
        System.out.println(sb);
    }
}