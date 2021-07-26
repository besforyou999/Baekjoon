import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {

        ArrayList<Boolean> list;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 1) {
            System.out.print(0);
            return ;
        }

        list = new ArrayList<Boolean>(n+1);
        list.add(false);
        list.add(false);

        for (int i = 2; i <= n ; i++)
            list.add(i, true);

        for (int i = 2; (i * i) <= n; i++) {
            if (list.get(i)) {
                for (int j = i * i ; j <= n ; j += i) list.set(j, false);
            }
        }

        ArrayList<Integer> prime = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            if (list.get(i))
                prime.add(i);
        }

        int left = 0 , right = 0 , ans = 0 , sum = 0;

        while (true) {
            if (sum >= n) {
                sum -= prime.get(left++);
            }
            else if (right == prime.size()) {
                break;
            }
            else {
                sum += prime.get(right++);
            }

            if (n == sum) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}
