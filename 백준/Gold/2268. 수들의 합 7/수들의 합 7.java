import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int arr[];
    static long tree[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new long[N * 4];

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (cmd == 0 && i > j) {
                int tmp = i;
                i = j;
                j = tmp;
            }

            if (cmd == 0) {
                sb.append(sum(1, N, 1, i, j) + "\n");
            } else if (cmd == 1) {
                update(1, N, 1, i, j);
            }
        }

        System.out.println(sb);
    }
    /*
        node가 담당하고 있는 구간이 [start, end] / 합을 구해야하는 구간이 [left, right]
     */
    static long sum(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 0;

        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static long update(int start, int end, int node, int index, int val) {
        if (index < start || end < index)
            return tree[node];

        if (start == end)
            return tree[node] = val;

        int mid = (start + end) / 2;

        return tree[node] = update(start, mid, node * 2, index, val) + update(mid + 1, end, node * 2 + 1, index, val);
    }
}