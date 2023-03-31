import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[M + 1][N + 1];

        List<Node> boards[] = new List[N + 1];
        for (int i = 0 ; i <= N ; i++) {
            boards[i] = new ArrayList<>();
        }

        for (int i = 0 ; i < K ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a < b) {
                boards[a].add(new Node(b, c));
            }
        }

        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int cnt = 1;

        while (!queue.isEmpty() && cnt < M) {
            int size = queue.size();

            while(size-- > 0) {
                int curIdx = queue.poll();
                for (Node nextNode : boards[curIdx]) {
                    int nextIdx = nextNode.index;
                    int nextScore = dp[cnt][curIdx] + nextNode.score;

                    if (dp[cnt + 1][nextIdx] >= nextScore) {
                        continue;
                    }

                    dp[cnt + 1][nextIdx] = nextScore;
                    queue.add(nextIdx);
                }
            }
            cnt++;
        }

        for (int i = 2 ; i <= M ; i++) {
            result = Math.max(result, dp[i][N]);
        }

        System.out.print(result);
    }

    public static class Node {
        int index;
        int score;
        public Node(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}