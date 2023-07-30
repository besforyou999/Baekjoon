import java.util.*;
import java.io.*;

public class Main {

    static int N, M, S, T;
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int n = 0; n <= N ; n++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int m = 0 ; m < M ; m++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            reverseGraph.get(y).add(x);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        dfs(S, T, graph, s1, new boolean[N + 1]);
        dfs(T, -1, reverseGraph, s2, new boolean[N + 1]);

        s1.retainAll(s2);

        Set<Integer> s3 = new HashSet<>();
        Set<Integer> s4 = new HashSet<>();

        dfs(T, S, graph, s3, new boolean[N + 1]);
        dfs(S, -1, reverseGraph, s4, new boolean[N + 1]);

        s3.retainAll(s4);

        s1.retainAll(s3);

        int answer = s1.size();

        if (s1.contains(S)) answer--;
        if (s1.contains(T)) answer--;

        System.out.print(answer);
    }

    public static void dfs(int node, int stop, List<List<Integer>> graph, Set<Integer> set, boolean [] visit) {
        if (stop != -1 && node == stop) {
            return;
        }

        for (int next : graph.get(node)) {
            if (visit[next]) continue;
            visit[next] = true;
            set.add(next);
            dfs(next, stop, graph, set, visit);
        }
    }
}
