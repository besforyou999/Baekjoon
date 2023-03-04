import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Honeycomb {
    ArrayList<Point> points;
    Honeycomb() {
        points = new ArrayList<>();
    }
}

class Point {
    int r, c;
    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

}

public class Solution {
    static int T, N, M, C;
    static int [][] mat;
    static ArrayList<Honeycomb> combs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1 ; test_case <= T ; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            combs = new ArrayList<>();

            mat = new int[N][N];
            for (int r = 0 ; r < N ; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0 ; c < N ; c++)
                    mat[r][c] = Integer.parseInt(st.nextToken());
            }

            for (int r = 0 ; r < N ; r++) {
                for (int c = 0 ; c <= N - M ; c++) {
                    Honeycomb comb = new Honeycomb();
                    for (int k = 0 ; k < M ; k++)
                        comb.points.add(new Point(r, c + k));
                    combs.add(comb);
                }
            }

            int max = -1;
            // select two
            for (int i = 0 ; i < combs.size() - 1 ; i++) {
                for (int j = i + 1 ; j < combs.size() ; j++) {
                    Honeycomb comb1 = combs.get(i);
                    Honeycomb comb2 = combs.get(j);
                    if(available(comb1, comb2)) {
                        int honeyHarvested = maxProfit(comb1) + maxProfit(comb2);
                        max = Math.max(max, honeyHarvested);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
            System.out.print(sb);
        }
    }

    static int maxProfit;
    static int maxProfit(Honeycomb comb) {
        maxProfit = -1;

        int [] honey = new int[M];
        for (int i = 0 ; i < M ; i++) {
            Point p1 = comb.points.get(i);
            honey[i] = mat[p1.r][p1.c];
        }

        powerSet(new boolean[M], honey, M, 0);

        return maxProfit;
    }

    static void powerSet(boolean [] visited, int[] honey, int n, int idx) {
        if (idx == n) {
            int sum = 0, Ccheck = 0;

            for (int i = 0 ; i < visited.length ; i++) {
                if (visited[i]) {
                    sum += honey[i] * honey[i];
                    Ccheck += honey[i];
                }
            }

            if (Ccheck <= C) maxProfit = Math.max(maxProfit, sum);

            return;
        }

        visited[idx] = false;
        powerSet(visited, honey, n, idx + 1);

        visited[idx] = true;
        powerSet(visited, honey, n, idx + 1);
    }


    static boolean available(Honeycomb c1, Honeycomb c2) {
        for (int i = 0 ; i < c1.points.size() ; i++) {
            for (int j = 0 ; j < c2.points.size() ; j++) {
                Point p1 = c1.points.get(i);
                Point p2 = c2.points.get(j);
                if (p1.r == p2.r && p1.c == p2.c) return false;
            }
        }
        return true;
    }
}