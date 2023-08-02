import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] src, arr;
    static long MAX = 0L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        src = new int[N];
        arr = new int[N - 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0 ; n < N ; n++) {
            src[n] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i < N - 1 ; i++) {
            arr[i - 1] = i;
        }

        permutation(arr, new int[N - 2], new boolean[N - 2], 0);

        System.out.println(MAX);
    }

    public static void permutation(int [] arr, int [] rec, boolean [] visit, int depth) {
        if (depth == arr.length) {
            calc(rec);
            return;
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                rec[depth] = arr[i];
                permutation(arr, rec, visit, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void calc(int [] rec) {
        boolean [] used = new boolean[N];
        long sum = 0;
        for (int idx : rec) {
            used[idx] = true;
            int lp = idx - 1;
            while (used[lp]) lp--;
            int rp = idx + 1;
            while (used[rp])rp++;
            sum += (long) src[lp] * src[rp];
        }
        MAX = Math.max(MAX, sum);
    }
}