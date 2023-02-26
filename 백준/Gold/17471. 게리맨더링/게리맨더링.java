import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int mat[][];
    static int [] populations;
    static boolean [] visited;
    static int ANS = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        populations = new int[N];
        mat = new int[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0 ;  i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                mat[i][next - 1] = 1;
            }
        }

        int [] numbers = new int[N];
        for (int i = 0 ; i < N ; i++) numbers[i] = i;

        for (int i = 1 ; i < N ; i++) {
            combin(numbers, new boolean[N], 0, i, 0);
        }

        if (ANS == Integer.MAX_VALUE) {
            ANS = -1;
        }

        System.out.println(ANS);
    }

    static void combin(int [] numbers, boolean [] visit, int start, int r, int depth) {
        if (depth == r) {
            int [] area1 = new int[r];
            int [] area2 = new int[N - r];
            int idx1 = 0 , idx2 = 0;

            for (int i = 0 ; i < N ; i++) {
                if (visit[i])
                    area1[idx1++] = i;
                else
                    area2[idx2++] = i;
            }

            if (available(area1) && available(area2)) {
                int pop1 = getAreaPopulation(area1);
                int pop2 = getAreaPopulation(area2);
                int diff = Math.abs(pop1 - pop2);
                ANS = Math.min(ANS, diff);
            }

            return;
        }

        for (int i = start ; i < N ; i++) {
            visit[i] = true;
            combin(numbers, visit, i + 1, r, depth + 1);
            visit[i] = false;
        }
    }


    static boolean available(int [] area) {
        if (area.length == 1) return true;

        Queue<Integer> queue = new LinkedList<>();
        boolean [] visit = new boolean[N];
        visit[area[0]] = true;
        queue.add(area[0]);

        int cnt = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0 ; i < N ; i++) {
                if (mat[node][i] != 0) {
                    int next = i;
                    if (containsNumber(area, next) && !visit[next]) {
                        cnt++;
                        visit[next] = true;
                        queue.add(next);
                    }
                }
            }
        }

        if (cnt == area.length)
            return true;
        else
            return false;
    }

    static boolean containsNumber(int [] area, int number) {
        for (int i = 0 ; i < area.length ; i++) {
            if (area[i] == number) return true;
        }
        return false;
    }

    static int getAreaPopulation(int [] area) {
        int sum = 0;
        for (int a : area) {
            sum += populations[a];
        }
        return sum;
    }

}