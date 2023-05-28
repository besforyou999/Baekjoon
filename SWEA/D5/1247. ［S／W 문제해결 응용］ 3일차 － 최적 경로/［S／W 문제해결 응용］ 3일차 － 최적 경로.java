import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Coord {
    int x, y;
    public Coord (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {

    static int N;
    static Coord [] coords;
    static int ANS = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1 ; test_case <= T ; test_case++) {

            ANS = 1_000_000_000;

            N = Integer.parseInt(br.readLine());
            coords = new Coord[N + 2];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0 ; n < N + 2 ; n++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                coords[n] = new Coord(x, y);
            }

            swap(coords[1], coords[N + 1]);

            permutation(new boolean[N], 0, new int[N]);

            sb.append("#").append(test_case).append(" ").append(ANS).append("\n");
       }

        System.out.println(sb);

    }

    static void permutation(boolean [] visit, int depth, int[] output) {
        if (depth == visit.length) {

            int [] order = new int[N + 2];
            for (int i = 1 ; i <= N ; i++) order[i] = output[i - 1];
            order[N + 1] = N + 1;

            int sum = 0;

            for (int i = 0 ; i < N + 1 ; i++) {
                int start = order[i];
                int end = order[i + 1];
                sum += dist(coords[start], coords[end]);
            }

            ANS = Math.min(ANS, sum);
            return;
        }

        for (int i = 0 ; i < visit.length ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                output[depth] = i + 1;
                permutation(visit, depth + 1, output);
                visit[i] = false;
            }
        }
    }

    static void swap(Coord c1, Coord c2) {
        int x = c1.x;
        int y = c1.y;
        c1.x = c2.x;
        c1.y = c2.y;
        c2.x = x;
        c2.y = y;
    }

    static int dist(Coord c1, Coord c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }
}