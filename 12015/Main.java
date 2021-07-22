import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(0);

        for (int i = 0 ; i < N ; i++) {

            int temp = sc.nextInt();

            if (arr.get(arr.size() - 1) < temp) {
                arr.add(temp);
            }
            else {
                int left = 1;
                int right = arr.size() - 1;

                while (left < right) {

                    int mid = (left + right)/2;

                    if (arr.get(mid) < temp) {
                        left = mid + 1;
                    }
                    else {
                        right = mid;
                    }
                }
                arr.set(right , temp);
            }
        }

        System.out.print(arr.size() - 1);
    }
}
