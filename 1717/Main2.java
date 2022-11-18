import java.util.*;
import java.io.*;

class Main {
    public static int [] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0 ; i < n + 1 ; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 0)
                union(a, b);
            else if (op == 1)
                if (sameParent(a, b))
                    sb.append("YES").append('\n');
                else
                    sb.append("NO").append('\n');

        }

        System.out.print(sb);
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
            } else
                parent[x] = y;
        }
    }

    public static boolean sameParent(int x, int y) {
        return (find_root(x) == find_root(y));
    }

}

