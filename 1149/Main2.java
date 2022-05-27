    import java.io.*;
    import java.util.StringTokenizer;

    public class Main {
        public static void main(String [] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
            int dp[][]  = new int[4][N+1];
            int rec[][] = new int[4][N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rec[1][1] = r;
            rec[2][1] = g;
            rec[3][1] = b;
            dp[1][1] = r;
            dp[2][1] = g;
            dp[3][1] = b;

            for (int i = 2 ; i <= N ; i++) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                g = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                rec[1][i] = r;
                rec[2][i] = g;
                rec[3][i] = b;
            }

            for (int i = 2 ; i <= N ; i++) {
                dp[1][i] = Math.min(dp[2][i-1], dp[3][i-1]) + rec[1][i];
                dp[2][i] = Math.min(dp[1][i-1], dp[3][i-1]) + rec[2][i];
                dp[3][i] = Math.min(dp[1][i-1], dp[2][i-1]) + rec[3][i];
            }
            int smallest = Integer.MAX_VALUE;
            for (int i = 1 ; i <= 3 ; i++) {
                if (dp[i][N] < smallest) smallest = dp[i][N];
            }
            System.out.print(smallest);
        }
    }
