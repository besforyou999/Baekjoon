import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        int res = 0;

        for (int m = 1 ; m <= M ; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (sameRoot(A, B)) {
                res = m;
                break;
            }

            union(A, B);
        }


        System.out.println(res);
    }

    public static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static void init() {
        parent = new int[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            parent[i] = i;
        }
    }

    public static int findRoot(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findRoot(parent[x]);
    }

    public static boolean sameRoot(int x, int y) {
        return findRoot(x) == findRoot(y);
    }
}