import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        int k = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int)Math.pow(2, k);

        tree = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int n = 1 ; n <= N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        init(1, N, 1);

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int i = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                update(1, N, 1, i, v);
            } else {
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                sb.append(getMin(1, N, 1, i, j)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

    static int update(int start, int end, int node, int idx, int value) {
        if (idx < start || end < idx) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = value;
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(update(start, mid, node * 2, idx, value), update(mid + 1, end, node * 2 + 1, idx, value));
    }

    static int getMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
    }

}