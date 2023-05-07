import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, size;
    static int [] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            arr = new int[N + 1];

            for (int n = 1 ; n <= N ; n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }

            int k = (int)Math.ceil(( Math.log(N) / Math.log(2) )) + 1;
            size = (int)Math.pow(2, k);

            tree = new int[size];

            init(1, N, 1);
            sb.append(getMax(1, N)).append("\n");
        }

        System.out.print(sb);
    }

    static void init(int start, int end, int node) {
        if (start == end) {
            tree[node] = start;
        } else {
            int mid = (start + end) / 2;
            init(start, mid, node * 2);
            init(mid + 1, end, node * 2 + 1);

            if (arr[tree[node * 2]] < arr[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2];
            } else {
                tree[node] = tree[node * 2 + 1];
            }
        }
    }

    static long getMax(int left, int right) {
        int m = query(1, N, 1, left, right);

        long area = (long)(right - left + 1) * (long)arr[m];

        if (left <= m - 1) {
            long tmp = getMax(left, m - 1);
            if (area < tmp) {
                area = tmp;
            }
        }

        if (m + 1 <= right) {
            long tmp = getMax(m + 1, right);
            if (area < tmp) {
                area = tmp;
            }
        }

        return area;
    }

    static int query(int start, int end, int node, int left, int right) {
       if (right < start || end < left)
           return -1;

       if (left <= start && end <= right) {
           return tree[node];
       }

       int mid = (start + end) / 2;
       int leftIdx = query(start, mid, node * 2, left, right);
       int rightIdx = query(mid + 1, end, node * 2 + 1, left, right);

       if (leftIdx == -1) {
           return rightIdx;
       } else if (rightIdx == -1) {
           return leftIdx;
       } else {
           if (arr[leftIdx] <= arr[rightIdx]) {
               return leftIdx;
           } else {
               return rightIdx;
           }
       }
    }
}