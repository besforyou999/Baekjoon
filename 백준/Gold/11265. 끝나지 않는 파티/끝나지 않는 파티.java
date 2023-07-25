import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.StringTokenizer;

    public class Main {

        static int N, M;

        static int [][] map;

        static final String good = "Enjoy other party", bad = "Stay here";

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];

            for (int r = 1 ; r < N + 1 ; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1 ; c < N + 1 ; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 1 ; k < N + 1 ; k++) {
                for (int i = 1 ; i < N + 1 ; i++) {
                    for (int j = 1 ; j < N + 1 ; j++){
                        if (map[i][j] > map[i][k] + map[k][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int m = 0 ; m < M ; m++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if (map[i][j] <= c)
                    sb.append(good);
                else
                    sb.append(bad);
                sb.append("\n");
            }

            System.out.println(sb);
        }
    }