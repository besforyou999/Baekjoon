import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long [] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int k = (int)Math.ceil((Math.log(N) / Math.log(2))) + 1;
        int size = (int)Math.pow(2, k);

        arr = new long[N + 1];
        tree = new long[size];

        StringBuilder sb = new StringBuilder();

        for (int m = 0; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                int left = i;
                int right = j;

                if (left > right) {
                    int tmp = left;
                    left = right;
                    right = tmp;
                }

                sb.append(sum(1, N, 1, left, right)).append("\n");
            } else {
                update(1, N, 1, i, j);
            }

        }

        System.out.print(sb);
    }

    static long sum(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    static long update(int start, int end, int node, int idx, int number) {
        if (idx < start || end < idx) {
            return tree[node];
        }

        if (start == end) {
            return tree[node] = number;
        }

        int mid = (start + end) / 2;

        return tree[node] = update(start, mid, node * 2, idx, number) + update(mid + 1, end, node * 2 + 1, idx, number);

    }


}