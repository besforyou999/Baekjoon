import java.io.*;
import java.sql.Array;
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
    static List<Town> []list;
    static int N, M;
    static int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 0 ; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int start   = Integer.parseInt(st.nextToken());
            int end     = Integer.parseInt(st.nextToken());
            int weight  = Integer.parseInt(st.nextToken());
            list[start].add(new Town(end, weight));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int dp[] = dijstra(start);

        System.out.print(dp[end]);
    }

    static int[] dijstra(int start) {
        Queue<Town> q = new PriorityQueue<>();
        int []dp = new int[N + 1];
        boolean []visited = new boolean[N + 1];
        Arrays.fill(dp, MAX);

        dp[start] = 0;
        q.add(new Town(start, 0));

        while (!q.isEmpty()) {
            Town t = q.poll();
            int to = t.to;
            if (visited[to]) continue;
            visited[to] = true;
            for (Town next : list[to]) {
                if (dp[to] + next.weight < dp[next.to]) {
                    dp[next.to] = dp[to] + next.weight;
                    q.add(new Town(next.to, t.weight + dp[next.to]));
                }
            }
        }
        return dp;
    }
}

