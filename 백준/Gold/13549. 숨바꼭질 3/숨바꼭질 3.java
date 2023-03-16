import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100001;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        } else if (N > K) {
            System.out.println(N - K);
            return;
        }

        int res = bfs();
        System.out.println(res - 1);
    }

    public static int bfs() {
        int [] dp = new int[MAX];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 1});

        while(!queue.isEmpty()) {
            int cord[] = queue.poll();
            int idx = cord[0];
            int cost = cord[1];

            if (idx == K) return cost;

            dp[idx] = cost;

            if (isIn(idx * 2) && dp[idx * 2] == 0) {
                queue.add(new int[]{idx * 2, cost});
            }

            if (isIn(idx - 1) && dp[idx - 1] == 0) {
                queue.add(new int[] {idx - 1 , cost + 1});
            }

            if (isIn(idx + 1) && dp[idx + 1] == 0) {
                queue.add(new int[]{idx + 1, cost + 1});
            }
        }
        return dp[K];
    }

    static boolean isIn(int idx) {
        return (idx >= 0 && idx < MAX);
    }
}