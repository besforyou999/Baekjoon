import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long []arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for (int n = 1 ; n <= N ; n++) {
            arr[n] = Long.parseLong(br.readLine());
        }

        int k = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int)Math.pow(2, k);

        tree = new long[size];

        init(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < M + K ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                long diff = c - arr[b];
                arr[b] = c;
                update(1, N, 1, b, diff);
            } else {
                sb.append(getSum(1, N, 1, b, (int)c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end)
            return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    static void update(int start, int end, int node , int idx, long diff) {
        if (idx < start || end < idx)
            return;

        tree[node] += diff;

        if (start == end)
            return;

        int mid = (start + end) / 2;

        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }

    static long getSum(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return getSum(start, mid, node * 2, left, right) + getSum(mid + 1, end, node * 2 + 1, left, right);
    }
}