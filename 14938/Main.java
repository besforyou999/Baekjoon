import java.io.*;
import java.util.*;

// 0 : 검은방, 1 : 흰방
class Main {
    public static int MAX = 1000000;
    public static int n, m, r;
    public static int node_values[];
    public static int dist[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        node_values = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n ; i++) {
            node_values[i] = Integer.parseInt(st.nextToken());
        }

        dist = new int[n + 1][n + 1];

        for (int i = 0 ; i < n + 1 ; i++) {
            for (int j = 0 ; j < n + 1 ; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = MAX;
            }
        }

        for (int i = 0 ; i < r ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[u][v] = dist[v][u] = w;
        }

        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = -1;

        for (int i = 1 ; i <= n ; i++) {
            int tmp = 0;
            for (int j = 1 ; j <= n ; j++) {
                if (dist[i][j] <= m) {
                    tmp += node_values[j - 1];
                }
            }
            if (tmp > ans) ans = tmp;
        }
        System.out.print(ans);
    }
}

