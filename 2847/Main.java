import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] scores = new int[N+1];
        for (int i = 1 ; i <= N ; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;

        for (int i = N ; i > 0 ; i--) {
            while (scores[i] <= scores[i-1]) {
                scores[i-1] -= 1;
                count += 1;
            }
        }
        System.out.print(count);
    }
}

