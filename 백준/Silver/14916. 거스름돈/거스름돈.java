import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int five = 0;

        int min = 2_000_000_000;

        if (N % 5 == 0) {
            System.out.println(N / 5);
            return;
        }

        five = N / 5;

        for (int i = five ; i >= 0 ; i--) {
            int remain = N - (i * 5);
            if (remain % 2 == 0) {
                min = Math.min(min, i + remain/2);
            }
        }

        if (min == 2_000_000_000) {
            System.out.println(-1);
            return;
        }

        System.out.println(min);
    }
}