import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String []args) {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      HashMap<String, Integer> map = new HashMap<>();

      for (int j = 0 ; j < n ; j++) {
        String first = sc.next();
        String sec = sc.next();

        if ( map.containsKey(sec)) {
          int temp = map.get(sec);
          temp += 1;
          map.put(sec, temp);
        } else if (!map.containsKey(sec)) {
          map.put(sec, 1);
        }

      }
      int result = 1;
      Set<String> keys = map.keySet();
      for ( String key : keys) {
        int temp = map.get(key);
        result *= (temp+1);
      }
      result -= 1;
      System.out.println(result);
    }
  }
}
