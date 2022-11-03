import java.io.*;
import java.util.*;

class Town implements Comparable<Town> {
    int to;
    int weight;
    public Town(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Town o) {
        return this.weight - o.weight;
    }
}


public class Main {
    static List<Town>[] nList;
    static List<Town> [] rList;
    static int INF = Integer.MAX_VALUE;
    static int N, M, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nList = new ArrayList[N + 1];
        rList = new ArrayList[N + 1];
        for (int i = 0 ; i < N + 1 ; i++) {
            nList[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nList[from].add(new Town(to, cost));
            rList[to].add(new Town(from, cost));
        }

        int[] go = dijkstra(nList, X);
        int[] back = dijkstra(rList, X);
        int res = Integer.MIN_VALUE;
        for (int i = 1 ; i < N + 1 ; i++) {
            int dis = go[i] + back[i];
            if (dis > res) {
                res = dis;
            }
        }
        System.out.print(res);
    }

    static int[] dijkstra(List<Town>[] list, int start) {
        Queue<Town> q = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);

        q.add(new Town(start, 0));
        dp[start] = 0;

        while(!q.isEmpty()) {
            Town pos = q.poll();
            int to = pos.to;
            if (check[to]) continue;
            check[to] = true;
            for (Town next : list[to]) {
                if (dp[to] + next.weight < dp[next.to]) {
                    dp[next.to] = dp[to] + next.weight;
                    q.add(new Town(next.to, dp[next.to]));
                }
            }
        }

       return dp;
    }
}

