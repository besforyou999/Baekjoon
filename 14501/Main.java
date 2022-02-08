import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Ti [] = new int[20];
        int Pi [] = new int[20];
        int DP [] = new int[20];
        Integer N = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N ; i > 0 ; i--) {
            if (Ti[i] > N - i + 1) {
                DP[i] = DP[i+1];
            } else {
                DP[i] = Math.max(Pi[i] + DP[i + Ti[i]], DP[i+1]);
            }
        }
        System.out.print(DP[1]);
    }
}