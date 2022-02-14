import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSort {
	public static void main(String [] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();        
		arr.add(10);
        arr.add(100);
        arr.add(1);
        arr.add(50);
        arr.add(30);
        
        Collections.sort(arr, Collections.reverseOrder());

		for (Integer integer : arr) {
            System.out.print(integer + " ");  // 100 50 30 10 1
        }
	}
}
