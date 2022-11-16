import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Ai[] = new int[N];
        for (int i = 0 ; i < N ; i++) {
            Ai[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Ai);
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < M ; i++) {
            int find =  Integer.parseInt(st.nextToken());
            sb.append(b_search(find, Ai)).append('\n');
        }
        System.out.print(sb);
    }

    public static int b_search(int target, int arr[]) {
        int lp = 0, rp = N - 1;
        int mid = 0;
        while (lp <= rp) {
            mid = (lp + rp) / 2;
            if (arr[mid] < target) {
                lp = mid + 1;
            } else if (arr[mid] > target) {
                rp = mid - 1;
            } else
                return 1;
        }
        return 0;
    }
}

