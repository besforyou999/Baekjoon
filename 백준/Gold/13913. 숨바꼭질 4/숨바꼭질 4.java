import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int MAX = 100001;
    static int N, K;
    static int[] parent = new int[MAX];
    static int[] time = new int [MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(time[K] - 1).append("\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) return;

            for (int i = 0 ; i < 3 ; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (time[next] == 0) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }
        }
    }
}