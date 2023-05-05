import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] arr, maxTree, minTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        int k = (int)Math.ceil((Math.log(N) / Math.log(2))) + 1;
        int size = (int)Math.pow(2, k);

        maxTree = new int[size];
        minTree = new int[size];

        for (int n = 1 ; n <= N ; n++) {
            arr[n] = Integer.parseInt(br.readLine());
        }

        maxInit(1, N, 1);
        minInit(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getMin(1, N, 1, a, b)).append(" ").append(getMax(1, N, 1, a, b)).append("\n");
        }

        System.out.print(sb);
    }

    static int maxInit(int start, int end, int node) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return maxTree[node] = Math.max(maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
    }

    static int minInit(int start, int end, int node) {
        if (start == end) {
            return minTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
    }

    static int getMax(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return -1;
        }

        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(getMax(start, mid, node * 2, left, right), getMax(mid + 1, end, node * 2 + 1, left, right));
    }

    static int getMin(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 1000000001;
        }

        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(getMin(start, mid, node * 2, left, right), getMin(mid + 1, end, node * 2 + 1, left, right));
    }
}