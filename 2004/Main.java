import java.util.Scanner;

public class Main {
  public static void main(String []args) {
    Scanner sc = new Scanner(System.in);
    int n ,m;
    n = sc.nextInt();
    m = sc.nextInt();

    if ( n == m ) {
      System.out.println(0);
      return;
    }
    int k = n - m;
    long num2 = divide2(n) - ( divide2(m) + divide2(k));
    long num5 = divide5(n) - ( divide5(m) + divide5(k));
    long min = Math.min(num2,num5);
    System.out.println(min);
  }

  public static long divide2(long num) {
    long count = 0;
    for (long i = 2 ; i <= num ; i = i*2 )
      count += num/i;
    return count;
  }

  public static long divide5(long num) {
    long count = 0;
    for (long i =5 ; i <= num ; i = i * 5)
      count += num / i;
    return count;
  }
}
