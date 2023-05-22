import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        StringBuilder sb = new StringBuilder();

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a, b);
            } else {
                if (sameParent(a,b)) {
                    sb.append("yes\n");
                } else
                    sb.append("no\n");
            }
        }

        System.out.print(sb);

    }

    static boolean sameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x < y)
            parents[y] = x;
        else
            parents[x] = y;
    }

    static int findParent(int x) {
        if (x == parents[x])
            return x;
        else
            return parents[x] = findParent(parents[x]);
    }

    static void init() {
        parents = new int[N + 1];
        for (int n = 0 ; n <= N ; n++) {
            parents[n] = n;
        }
    }
}