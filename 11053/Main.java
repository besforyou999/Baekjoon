import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int arr[] = new int[N+1];
        int dp[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i <= N ; i++) {
            dp[i] = 1;
            for (int j = 1; j < i ; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 1 ; i <= N ; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        System.out.print(max);
    }
}
