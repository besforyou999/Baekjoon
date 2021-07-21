import java.util.Scanner;
import java.util.Vector;

public class Main {

    static long N, M;
    static Vector<Long> v = new Vector<Long>();

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        M = sc.nextLong();
        long max = 0;
        for (long i = 0 ; i < N ; i++) {
            long temp = sc.nextLong();
            if ( temp > max) {
                max = temp;
            }
            v.add(temp);
        }
        long result = 0;
        long left = 0;
        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (pos(mid)) {
                left = mid + 1;
                result = mid;
            }
            else
                right = mid - 1;
        }
        System.out.print(result);
    }

    public static boolean pos (long len) {
        long sum = 0;
        for (long i = 0; i < N ; i++) {
            long height = v.get((int)i);
            if ( height > len)
                sum += height - len;
            if (sum >= M)
                return true;
        }
        return false;
    }
}
