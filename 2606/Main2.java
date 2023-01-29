import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int computer_cnt;
    public static int connection_cnt;
    public static int mat[][];
    public static boolean visit[];
    public static int infected_pc_cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        computer_cnt = Integer.parseInt(br.readLine());
        connection_cnt = Integer.parseInt(br.readLine());
        mat = new int[computer_cnt + 1][computer_cnt + 1];
        visit = new boolean[computer_cnt + 1];

        for (int i = 0 ; i < connection_cnt ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            mat[one][two] = mat[two][one] = 1;
        }

        DFS(1);

        System.out.println(infected_pc_cnt - 1);
    }

    public static void DFS(int v) {
        if (visit[v])
            return;

        visit[v] = true;
        infected_pc_cnt += 1;
        for (int i = 1 ; i <= computer_cnt ; i++) {
            if (!visit[i] && mat[v][i] == 1) {
                DFS(i);
            }
        }
    }
}

