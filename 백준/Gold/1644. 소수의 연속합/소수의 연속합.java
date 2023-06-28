import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int numbers[] = new int[N + 1];
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		buildPrimes(numbers);
		
		for (int i = 0 ; i < numbers.length ; i++) {
			if(numbers[i] == 0) 
				primes.add(i);
		}
		/*
		for (int a : primes) {
			System.out.print(a + " ");
		}
		System.out.println();
		*/
		int lp = 0, rp = 0, cnt = 0, sum = 0;
		
		while (lp < primes.size()) {
			if (sum >= N) {
				sum -= primes.get(lp);
				lp++;
			} else if (rp >= primes.size()) {
				break;
			} else {
				sum += primes.get(rp);
				rp++;
			}
			
			if (sum == N) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static void buildPrimes(int []num) {
		num[0] = num[1] = 1;
		for (int i = 2 ; i * i < num.length ; i++) {
			if (num[i] == 0) {
				for (int j = i + i ; j < num.length ; j += i) 
					num[j] = 1;
			}
		}
	}
}