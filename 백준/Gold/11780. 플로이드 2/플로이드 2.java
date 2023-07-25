import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int cost[][] = new int[101][101];
    static int route[][] = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (i != j) {
                    cost[i][j] = 1_000_0001;
                }
            }
        }

        for (int i = 1 ; i <= m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[x][y] = Math.min(cost[x][y], c);
            route[x][y] = x;
        }

        for (int k = 1 ; k <= n ; k++) {
            for (int i = 1 ; i <= n ; i++) {
                for (int j = 1 ; j <= n ; j++) {
                    if (cost[i][j] > cost[i][k] + cost[k][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                        route[i][j] = route[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= n ; j++) {
                if (cost[i][j] <= 1_000_001)
                    sb.append(cost[i][j]).append(" ");
                else
                   sb.append("0 ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        for (int i = 1 ; i <= n ; i++) {
            path(i, n);
        }
    }

    public static void path(int start, int n) {

        StringBuilder sb = new StringBuilder();

        for (int end = 1 ; end <= n ; end++) {
            if (start == end) {
                sb.append(0).append("\n");
            } else {
                Stack<Integer> stack = new Stack<>();
                int idx = route[start][end];
                while (idx != 0) {
                    stack.add(idx);
                    idx = route[start][idx];
                }

                if (stack.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(stack.size() + 1).append(" ");
                    while (!stack.isEmpty()) {
                        sb.append(stack.peek()).append(" ");
                        stack.pop();
                    }
                    sb.append(end).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}