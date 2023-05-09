import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static long [] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        int k = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int)Math.pow(2, k);

        tree = new long[size];

        StringBuilder sb = new StringBuilder();

        for (int q = 0 ; q < Q ; q++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(1, N, 1, p, x);
            } else {
                sb.append(getDiff(1, N, 1, p, x)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static void update(int start, int end, int node, int idx, int diff) {
        if (idx < start || end < idx)
            return;

        tree[node] += diff;

        if (start == end)
            return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2 , idx, diff);
        update(mid + 1, end, node * 2 + 1 , idx, diff);
    }

    static long getDiff(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return getDiff(start, mid, node * 2 , left, right) + getDiff(mid + 1, end, node * 2 + 1 , left , right);
    }
}