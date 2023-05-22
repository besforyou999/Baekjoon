import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int [][]map = new int[N + 1][N + 1];

        for (int m = 0 ; m < M ; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (map[a][b] == 0)
                map[a][b] = c;
            else
                map[a][b] = Math.min(map[a][b], c);
        }

        for (int k = 1 ; k <= N ; k++) {
            for (int i = 1 ; i <= N ; i++) {
                for (int j = 1 ; j <= N ; j++) {
                    if (i == j)
                        continue;
                    if (map[i][k] != 0 && map[k][j] != 0) {
                        if (map[i][j] == 0) {
                            map[i][j] = map[i][k] + map[k][j];
                        } else {
                            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}