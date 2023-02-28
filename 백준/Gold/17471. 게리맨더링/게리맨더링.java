import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] population;

    static int [][] mat;

    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        population = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        mat = new int[N][N];

        for (int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0 ; j < num ; j++) {
                int end = Integer.parseInt(st.nextToken());
                mat[i][end - 1] = 1;
            }
        }

        int [] numbers = new int[N];
        for (int i = 0 ; i < N ; i++) {
            numbers[i] = i;
        }

        for (int i = 1 ; i <= N - 1 ; i++) {
            back(numbers, new boolean[N], 0, i, 0);
        }

        if (MIN == Integer.MAX_VALUE) MIN = -1;
        System.out.println(MIN);
    }

    static void back(int [] numbers, boolean [] used, int depth, int r, int start) {
        if (depth == r) {
            int group1[] = new int[r];
            int group2[] = new int[N - r];
            int idx1 = 0 , idx2 = 0;
            for (int i = 0 ; i < used.length ;i++) {
                if (used[i]) {
                    group1[idx1++] = i;
                } else
                    group2[idx2++] = i;
            }

            if (valid(group1) && valid(group2)) {
                int sum1 = calcPopulation(group1);
                int sum2 = calcPopulation(group2);
                int diff = Math.abs(sum1 - sum2);
                MIN = Math.min(MIN, diff);
            }

            return;
        }

        for (int i = start ; i < numbers.length ; i++) {
            used[i] = true;
            back(numbers, used, depth + 1, r, i + 1);
            used[i] = false;
        }
    }

    static int calcPopulation(int []numbers) {
        int sum = 0;
        for (int a : numbers)
            sum += population[a];
        return sum;
    }

    static boolean valid(int [] numbers) {
        if (numbers.length == 1) return true;

        int start = numbers[0];
        boolean visit[] = new boolean[N];
        visit[start] = true;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        int nodes = 1;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0 ; i < N ; i++) {
                if (mat[node][i] != 0 && !visit[i] && contains(numbers, i)) {
                    visit[i] = true;
                    queue.add(i);
                    nodes++;
                }
            }
        }

        if (nodes == numbers.length) return true;
        return false;
    }

    static boolean contains(int [] numbers, int next) {
        for (int a : numbers) {
            if (next == a) return true;
        }
        return false;
    }

}