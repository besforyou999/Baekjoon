import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long Fn [] = new long[n + 1];
        Fn[1] = 1;

        for (int i = 2 ; i <= n ; i++) {
            Fn[i] = Fn[i-1] + Fn[i-2];
        }

        System.out.print(Fn[n]);
    }
}