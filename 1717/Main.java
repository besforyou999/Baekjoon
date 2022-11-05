import java.io.*;
import java.util.*;

public class Main {
    public static int N, M;
    public static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1 ; i < N + 1 ; i++) {
            parent[i] = i;
        }
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else if (cmd == 1) {
                sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
            } else {
                continue;
            }
        }

        System.out.print(sb);

    }

    public static int find_root(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find_root(x);
    }

    public static void union(int x, int y) {
        x = find_root(x);
        y = find_root(y);

        if (x != y ) {
            if ( x < y ) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find_root(x);
        y = find_root(y);

        if (x == y) {
            return true;
        }
        return false;
    }
}

