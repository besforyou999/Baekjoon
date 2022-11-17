import java.io.*;
import java.util.*;

public class Main {
    public static int N, K;
    public static int [] check = new int[100001];
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.print(0);
            return;
        }

        bfs(N);
    }

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = 1;
        while(!queue.isEmpty()) {
            int pos = queue.poll();
            for (int i = 0 ; i < 3 ; i++) {
                int next = 0;
                if (i == 0) {
                    next = pos - 1;
                } else if (i == 1) {
                    next = pos + 1;
                } else {
                    next = 2 * pos;
                }

                if (next == K) {
                    System.out.print(check[pos]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    check[next] = check[pos] + 1;
                    queue.add(next);
                }
            }
        }
    }
}

