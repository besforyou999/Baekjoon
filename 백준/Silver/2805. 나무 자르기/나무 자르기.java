import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0 ; n < N ; n++) {
            trees[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        int lp = 0 , rp = trees[N - 1];
        long result = 0;

        while (lp <= rp) {
            int mid = (lp + rp) / 2;

            if (valid(trees, mid, M)) {
                lp = mid + 1;
                result = mid;
            } else {
                rp = mid - 1;
            }
        }

        System.out.println(result);
    }

    public static boolean valid(int[] tree, int h, int m) {
        long sum = 0;
        for (int i = 0 ; i < tree.length ; i++) {
            if (tree[i] > h)
                sum += tree[i] - h;
            if (sum >= m)
                return true;
        }
        return false;
    }
}