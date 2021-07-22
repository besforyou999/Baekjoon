import java.util.Collections;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        PriorityQueue<Long> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N ; i++) {

            long x = sc.nextLong();

            if ( x != 0 ) {
                q.add(x);
            }
            else if ( x == 0 ) {
                if ( q.isEmpty()) {
                    System.out.println(0);
                }
                else if ( !q.isEmpty()) {
                    System.out.println(q.poll());
                }
            }
        }

    }
}
