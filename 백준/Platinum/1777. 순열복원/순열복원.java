import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] inverse, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        inverse = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 1 ; n <= N ; n++)
            inverse[n] = Integer.parseInt(st.nextToken());

        int k = (int)Math.ceil(Math.log(N) / Math.log(2)) + 1;
        int size = (int)Math.pow(2, k);

        tree = new int[size];

        for (int i = 1 ; i <= N ; i++) {
            update(1, N, 1, i, 1);
        }

        int [] ans = new int[N + 1];

        for (int i = N ; i  >= 1 ; i--) {
            int get = query(1, 1, N, inverse[i] + 1);
            ans[get] = i;
        }

        for (int i = N ; i >= 1 ; i--) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    static int query(int node, int start, int end, int val) {

        int get;
        int mid = (start + end) / 2;

        if (start == end) {
            tree[node]--;
            return start;
        }

        if (tree[node * 2] >= val) {
            get = query(node * 2, start, mid, val);
        } else {
            get = query(node * 2 + 1, mid + 1, end, val - tree[node * 2]);
        }

        tree[node]--;
        return get;
    }

    static void update(int start, int end, int node, int idx, int diff) {
        if (start <= idx && idx <= end) {
            tree[node] += diff;
            if (start != end) {
                int mid = (start + end) / 2;
                update(start, mid, node * 2, idx, diff);
                update(mid + 1, end, node * 2 + 1, idx, diff);
            }
        }
    }


}