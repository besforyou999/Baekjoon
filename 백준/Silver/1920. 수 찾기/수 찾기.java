import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static StringTokenizer st;

    static long A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int n = 0 ; n < N ; n++)
            A[n] = Long.parseLong(st.nextToken());

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(bsearch(target)).append("\n");
        }

        System.out.print(sb);
    }

    public static int bsearch(int target) {
        int lp = 0, rp = N - 1;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;

            if (A[mid] > target) {
                rp = mid - 1;
            } else if (A[mid] < target) {
                lp = mid + 1;
            } else
                return 1;
        }

        return 0;
    }
}