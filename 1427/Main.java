import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String [] args) {
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    char array[] = s.toCharArray();

    Integer arr[] = new Integer[s.length()];

    for (int i = 0; i < s.length() ; i++) {
      arr[i] = array[i] - 48;
    }

    Arrays.sort(arr, Comparator.reverseOrder());

    for (int i = 0; i < arr.length ; i++)
      System.out.print(arr[i]);

  }
}

