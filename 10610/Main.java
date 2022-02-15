import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Arrays;

public class Main {
	public static void main(String [] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();

		Integer [] arr = new Integer[input.length()];
		char [] chars = input.toCharArray();
		int sum = 0;	
		boolean zeroExist = false;
		
		for (int i = 0 ; i < chars.length ; i++){ 
		   	arr[i] = chars[i] - '0';
			sum += arr[i];
			if (arr[i] == 0 && zeroExist == false) zeroExist = true;
		}
		
		if (sum % 3 != 0 || zeroExist == false) {
			System.out.print(-1);
			return;
		}

		Arrays.sort(arr, Collections.reverseOrder());		

		String ans = "";

		for (Integer integer : arr) {
			ans += integer.toString();
		}

		System.out.print(ans);
	}
}
