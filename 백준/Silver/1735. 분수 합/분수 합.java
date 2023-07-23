import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A1, B1, A2, B2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A1 = Integer.parseInt(st.nextToken());
        B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        A2 = Integer.parseInt(st.nextToken());
        B2 = Integer.parseInt(st.nextToken());

        int top = A1 * B2 + A2 * B1;
        int bottom = B1 * B2;

        int div = gcd(top, bottom);

        if (div == 1) {
            System.out.println(top + " " + bottom);
        } else {
            System.out.println(top / div + " " + bottom / div);
        }
    }

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}