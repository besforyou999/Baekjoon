import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [] mat;

    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {

        mat = new int[101];

        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0 ; i < N + M ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map.put(x, y);
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int start) {
        boolean [] visit = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visit[start] = true;

        while (!queue.isEmpty()) {
            int [] ele = queue.poll();

            if (ele[0] == 100) return ele[1];

            if (map.containsKey(ele[0])) {
                ele[0] = map.get(ele[0]);
                visit[ele[0]] = true;
            }

            for (int i = 1 ; i <= 6 ; i++) {
                int next = ele[0] + i;
                if (next < 101 && !visit[next]) {
                    visit[next] = true;
                    queue.add(new int[] {next, ele[1] + 1});
                }
            }
        }

        return 0;
    }



    public static void init() {
        for (int n = 1 ; n < 101 ; n++) mat[n] = n;
    }
}