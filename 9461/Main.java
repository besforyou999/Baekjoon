import java.io.*;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        long fn[] = new long[103];
        fn[0] = 1;
        fn[1] = 1;
        fn[2] = 1;
        fn[3] = 2;
        fn[4] = 2;
        fn[5] = 3;

        for (int i = 6 ; i < 103 ; i++) fn[i] = fn[i-2] + fn[i-3];

        for (int i = 0 ; i < T ; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(fn[n-1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
