import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        init();

        for (int i = 0 ; i < N - 2 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            union(A, B);
        }

       for (int i = 2 ; i <= N ; i++) {
           if (!sameParent(1, i)) {
               System.out.println(1 + " " + i);
               return;
           }
       }
    }

    public static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static boolean sameParent(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

    public static int findRoot(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findRoot(parent[x]);
    }

    public static void init() {
        parent = new int[N + 1];
        for (int n = 0 ; n < N + 1 ; n++) {
            parent[n] = n;
        }
    }
}

/*

3 4 5 2 1

6 7 8

 */