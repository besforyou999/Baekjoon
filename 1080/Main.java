import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int A [][];
    static int B [][];

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < str.length() ; j++) {
                A[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < str.length() ; j++) {
                B[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = 0;

        for (int i = 0 ; i < N - 2 ; i++) {
            for (int j = 0 ; j < M - 2 ; j++) {
                if(A[i][j] != B[i][j]) {
                    flip33A(i,j);
                    ans += 1;
                }
            }
        }

        for (int i = 0 ; i < N ; i++) {
            for (int j = 0 ; j < M ; j++) {
                if (A[i][j] != B[i][j]) {
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.println(ans);

    }

    public static void flip33A(int i, int j) {
        for (int a = 0 ; a <= 2 ; a++) {
            for (int b = 0 ; b <= 2 ; b++) {
                A[i+a][j+b] = 1 - A[i+a][j+b];
            }
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferReader br = new BufferReader(new InputStreamReader(System.in));
		BufferWriter bw = new BufferWriter(new OutputStreamReader(System.out));
    }
}
