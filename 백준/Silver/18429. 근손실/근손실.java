import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int N, K, cnt = 0;
    static int [] kits;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kits = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            kits[i] = Integer.parseInt(st.nextToken());
        }

        rec(new boolean[N], 0, 500);

        System.out.print(cnt);
    }

    static void rec(boolean [] visit, int depth, int weight) {
        if (depth == N) {
            cnt++;
            return;
        }

        if (weight < 500) return;

        for (int i = 0 ; i < kits.length ; i++) {
            if (!visit[i]) {
                visit[i] = true;
                rec(visit, depth + 1, weight - K + kits[i]);
                visit[i] = false;
            }
        }

    }
}
