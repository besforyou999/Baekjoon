import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int sums[] = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N ; i++)
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append(sums[r] - sums[l-1]).append("\n");
        }

        System.out.print(sb);
    }
}