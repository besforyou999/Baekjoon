import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

       int minBagCount = 5000;

       for (int i = 0 ; i * 3 <= n ; i++) {
           int temp = i;
           if ( ((n - ( i * 3 )) % 5) != 0 ) {
               continue;
           }
           temp += (n - (i*3)) / 5;

           if (minBagCount > temp) minBagCount = temp;
       }
       if (minBagCount == 5000) System.out.print(-1);
       System.out.print(minBagCount);
    }
}
