import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans = 1_000_000_000;
    static ArrayList<Coord> chickenStore = new ArrayList<>();
    static ArrayList<Coord> houses = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [][] mat = new int[N + 1][N + 1];

        for (int n = 1 ; n < N + 1 ; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1 ; m < N + 1 ; m++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 2)
                    chickenStore.add(new Coord(n, m));
                else if (val == 1)
                    houses.add(new Coord(n, m));
            }
        }

        dfs(0, 0, new boolean[chickenStore.size()]);

        System.out.println(ans);

    }

    public static void dfs(int idx, int depth, boolean [] visit) {
        if (depth == M) {
            Coord [] chick = new Coord[M];
            int index = 0;
            for (int i = 0 ; i < chickenStore.size() ; i++) {
                if (visit[i]) {
                    chick[index++] = chickenStore.get(i);
                }
            }

            ans = Math.min(ans, chicken_distance(chick));
            return;
        }

        for (int i = idx ; i < chickenStore.size() ; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1, visit);
            visit[i] = false;
        }


    }

    public static int chicken_distance(Coord [] chick) {

        int sum = 0;

        for (Coord house : houses) {
            int tmp = Integer.MAX_VALUE;
            for (Coord c : chick) {
                int d = distance(house, c);
                if (tmp > d) tmp = d;
            }
            sum += tmp;
        }

        return sum;
    }

    public static int distance(Coord c1, Coord c2) {
        return Math.abs(c1.r - c2.r) + Math.abs(c1.c - c2.c);
    }

    static class Coord {
        int r, c;
        Coord(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}