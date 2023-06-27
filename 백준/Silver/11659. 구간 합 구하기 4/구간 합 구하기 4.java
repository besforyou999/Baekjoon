import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int [] arr = new int[N];
        for (int n = 0 ; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        int [] S = new int[N + 1];

        S[1] = arr[0];

        for (int n = 2 ; n <= N; n++) {
            S[n] = S[n-1] + arr[n - 1];
        }

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken()) - 1;
            int two = Integer.parseInt(st.nextToken());
            sb.append(S[two] - S[one]).append("\n");
        }

        System.out.print(sb);
    }
}