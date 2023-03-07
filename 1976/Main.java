import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        MakeSet();

        for (int i = 1 ; i <= N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= N ; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = findRoot(Integer.parseInt(st.nextToken()));

        while(st.hasMoreTokens()) {
            int city = Integer.parseInt(st.nextToken());
            int root2 = findRoot(city);
            if (root != root2) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");
    }

    static void MakeSet() {
        parent = new int[N + 1];
        for (int i = 1 ; i <= N ; i++) parent[i] = i;
    }

    static int findRoot(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = findRoot(parent[x]);
    }

    static boolean union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x == y) {
            return false;
        } else {
            if (x < y) {
                parent[y] = x; // 작은 숫자가 root가 되도록
            } else
                parent[x] = y;
            return true;
        }
    }

    static boolean sameRoot(int x, int y) {
        return findRoot(x) == findRoot(y);
    }

}
