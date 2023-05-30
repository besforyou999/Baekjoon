import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] parent, depth;
    static List<List<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0 ; i <= n ; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0 ; i < n - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        parent = new int[n + 1];
        depth = new int[n + 1];

        // 루트노드 1, depth 1을 시작으로 각 정점들의 depth를 구한다.
        dfs(1, 1);

        m = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int ret = lca(u, depth[u], v, depth[v]);
            System.out.println(ret);
        }

    }

    static int lca(int a, int aDepth, int b, int bDepth) {
        // 높이 맞추기
        if (aDepth > bDepth) {
            while (aDepth != bDepth) {
                aDepth--;
                a = parent[a];
            }
        } else if (aDepth < bDepth) {
            while( aDepth != bDepth) {
                bDepth--;
                b = parent[b];
            }
        }

        // 그 이후에 depth를 똑같이 증가시키다가
        // 만난 같은 정점이 가장 가까운 공통 조상이 된다.
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void dfs(int from, int cnt) {
        depth[from] = cnt++;
        for (int next : list.get(from)) {
            // depth가 0이 아니면 이미 depth를 구한 노드이다.
            if (depth[next] != 0 ) continue;
            dfs(next, cnt);
            parent[next] = from;
        }
    }
}