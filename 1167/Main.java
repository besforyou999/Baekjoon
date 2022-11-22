import java.io.*;
import java.util.*;

class Main {
    public static class Node {
        int e;
        int cost;
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }

    public static int V;
    public static ArrayList<Node>[] list;
    public static boolean [] visited;
    static int max = 0;
    static int node;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        for (int i = 1 ; i < V + 1 ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < V ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int node_num = Integer.parseInt(st.nextToken());
                if (node_num == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                list[num].add(new Node(node_num, cost));
            }
        }
        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(node, 0);
        System.out.println(max);
    }

    public static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for (int i = 0 ; i < list[x].size() ; i++) {
            Node n = list[x].get(i);
            if (visited[n.e] == false) {
                visited[n.e] = true;
                dfs(n.e, n.cost + len);
            }
        }
    }
}


