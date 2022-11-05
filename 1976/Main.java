import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    union(row + 1, col + 1);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int root = find_root(one);
        for (int i = 1; i < M; i++) {
            int dest = Integer.parseInt(st.nextToken());
            if (root != find_root(dest)) {
                System.out.print("NO");
                return;
            }
        }
        System.out.print("YES");
    }

    public static int find_root(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find_root(parent[x]);
    }

    public static void union(int x, int y) {
        x = find_root(x);
        y = find_root(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }
}

