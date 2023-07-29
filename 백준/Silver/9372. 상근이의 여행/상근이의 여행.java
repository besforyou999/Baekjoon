import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int [][] mat;
    static boolean [][] visit;

    static int [] dr = {-1, 1, 0, 0};
    static int [] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0 ; t < T ; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int m = 0 ; m < M ; m++) {
                st = new StringTokenizer(br.readLine());
            }

            System.out.println(N - 1);
        }
    }

}