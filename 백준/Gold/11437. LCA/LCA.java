import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int [] parent, depth;
    static List<List<Integer>> list;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0 ; i <= N ; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0 ; i < N - 1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        parent = new int[N + 1];
        depth = new int[N + 1];

        dfs(1, 1);

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int ret = lca(u, depth[u], v, depth[v]);
            sb.append(ret).append("\n");
        }

        System.out.print(sb);
    }

    static int lca(int a, int aDepth, int b, int bDepth) {
        // 높이 맞추기
        if (aDepth > bDepth) {
            while (aDepth != bDepth) {
                aDepth--;
                a = parent[a];
            }
        } else if (aDepth < bDepth) {
            while (aDepth != bDepth) {
                bDepth--;
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

    static void dfs(int from, int cnt) {
        depth[from] = cnt++;
        for (int next : list.get(from)) {
            if (depth[next] != 0) continue;
            dfs(next, cnt);
            parent[next] = from;
        }
    }
}