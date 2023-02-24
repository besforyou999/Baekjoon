import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int max_depth = 0;
    static ArrayList[] adjLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjLists = new ArrayList[N];
        for (int i = 0 ; i < N ; i++) {
            adjLists[i] = new ArrayList<Integer>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjLists[a].add(b);
            adjLists[b].add(a);
        }

        int flag = 0;

        for (int i = 0 ; i < N ; i++) {
            boolean visit[] = new boolean[N];
            dfs(i, visit, 0);
            if (max_depth >= 4) {
                flag = 1;
                break;
            }
        }

        //System.out.println("max_depth : " + max_depth);

        System.out.println(flag);
    }

    static void dfs(int node, boolean [] visit, int depth) {

        max_depth = Math.max(max_depth, depth);
        if (max_depth >= 4) return;

        visit[node] = true;

        ArrayList<Integer> edges = adjLists[node];

        for (int i = 0 ; i < edges.size() ; i++) {
            int next = edges.get(i);
            if (!visit[next]) {
                visit[next] = true;
                //System.out.println("node & next : " + node + " & " + next);
                dfs(next, visit, depth + 1);
                visit[next] = false;
            }
        }
    }

}