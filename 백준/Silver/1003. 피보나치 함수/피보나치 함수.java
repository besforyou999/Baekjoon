import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int zeros [] = new int[41];
        int ones [] = new int[41];

        zeros[0] = 1;
        ones[1] = 1;

        for (int i = 2 ; i < 41 ; i++) {
            zeros[i] = zeros[i-1] + zeros[i-2];
            ones[i] = ones[i-1] + ones[i-2];
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while( T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zeros[N]).append(" ").append(ones[N]).append("\n");
        }

        System.out.print(sb);
    }
}