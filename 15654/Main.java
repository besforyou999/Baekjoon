import java.io.*;
import java.util.*;

class Main {
    public static int N, M;
    public static int arr[];
    public static int numbers[];
    public static boolean [] visit;
    public static ArrayList<int[]> ans = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        numbers = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        rec(0);

        StringBuilder sb = new StringBuilder();

        for (int [] tmp : ans) {
            for (int a : tmp) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void rec(int depth) {
        if (depth == M) {
            int [] tmp = new int[M];
            for (int i = 0 ; i < M ; i++) {
                tmp[i] = arr[i];
            }
            ans.add(tmp);
            return;
        }

        for (int i = 0 ; i < N ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numbers[i];
                rec(depth + 1);
                visit[i] = false;
            }
        }
    }
}

