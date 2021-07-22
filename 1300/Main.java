import java.util.Scanner;

public class Main {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long k = sc.nextLong();
        long result = 0;
        long left = 0 , right = k;

        while (left <= right) {

            long count = 0;
            long mid = (left + right) / 2;

            for (int i =1 ; i <= N ; i++)
                count += Math.min(mid/i, N);

            if ( count < k ) {
                left = mid + 1;
            }
            else {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.print(result);

    }

}
