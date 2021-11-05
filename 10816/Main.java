import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static int N, M;
	
	public static void main(String [] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		String [] split = br.readLine().split(" ");	
		Map<Integer, Integer> map = new HashMap<>(N);

		for ( int i = 0 ; i < N ; i++ ) {
			int number = Integer.parseInt(split[i]);
			if (map.containsKey(number)) {
				map.replace(number, map.get(number) + 1);
			} else {
				map.put(number, 1);
			}
		}	

		StringBuilder stb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		split = br.readLine().split(" ");

		for ( int i = 0 ; i < M ; i++ ) {
			int number = Integer.parseInt(split[i]);
			if (map.containsKey(number)) {
				stb.append(map.get(number));
			} else {
				stb.append(0);
			}				
			
			stb.append(" ");
		}	
		System.out.println(stb);
	}
}
