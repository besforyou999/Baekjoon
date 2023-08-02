import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static Set<String > set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        set = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int n = 0 ; n < N ; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combination(new boolean[N], arr, 0, 0);

        System.out.print(sb);
    }

    public static void combination (boolean [] visit, int [] arr, int start, int depth) {
        if (depth == M) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0 ; i < visit.length ; i++) {
                if (visit[i])
                    tmp.append(arr[i]).append(" ");
            }

            if (!set.contains(tmp.toString())) {
                set.add(tmp.toString());
                sb.append(tmp).append("\n");
            }

            return;
        }

        for (int i = start ; i < arr.length ; i++) {
            visit[i] = true;
            combination(visit, arr, i + 1, depth + 1);
            visit[i] = false;
        }
    }
}