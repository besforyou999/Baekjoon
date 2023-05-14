import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int []A, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1 ; n <= N ; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }

        int max = -1;

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = 1;
            for (int j = 1 ; j <= i ; j++) {
                if (A[i] > A[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        int cnt = max;
        System.out.println(cnt);

        Stack<Integer> stack = new Stack<>();

        for (int i = N ; i >= 1 ; i--) {
            if (dp[i] == cnt) {
                stack.add(A[i]);
                cnt--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}