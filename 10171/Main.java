import java.io.*;
import java.util.Scanner;

public class Main {
    static BufferedWriter bw;
    public static void main(String [] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();

        bw.write((int)(Math.pow(2, N) - 1) + "\n");

        Han(N, 1, 2, 3);

        bw.flush();
        bw.close();
    }

    public static void Han(int N, int start, int mid, int to) throws IOException {
        if (N == 1) {
            bw.write(start + " " + to + "\n");
            return ;
        }

        Han(N - 1, start, to, mid);

        bw.write(start + " " + to + "\n");

        Han(N - 1, mid, start, to);
    }
}

