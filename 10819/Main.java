import java.io.*;
import java.util.*;

class Main {
    public static int N, MAX = -1;
    public static int [] arr;
    public static int [] numbers;
    public static boolean [] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        numbers = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        rec(0);

        System.out.print(MAX);
    }

    public static int calculate(int [] abs_arr) {
        int ans = 0;
        for (int i = 0 ; i < abs_arr.length - 1 ; i++) {
            ans += Math.abs(abs_arr[i] - abs_arr[i+1]);
        }
        return ans;
    }

    public static void rec(int depth) {
        if (depth == N) {
            int val = calculate(numbers);
            MAX = Math.max(val, MAX);
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                numbers[depth] = arr[i];
                rec(depth + 1);
                visit[i] = false;
            }
        }
    }
}

