import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long fn[] = new long[100];
        fn[0] = 0;
        fn[1] = 1;
        fn[2] = 1;

        for (int i = 2 ; i <= N ; i++) {
            fn[i] = fn[i-1] + fn[i-2];
        }

        System.out.print(fn[N]);
    }
}
