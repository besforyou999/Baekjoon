import java.util.Scanner;
import java.util.HashMap;
import java.util.Collection;

public class Main {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);

		int t;
		t = sc.nextInt();

		for (int i = 0; i < t ; i++ ) {
			
			int n = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<String, Integer>();

			for (int j = 0; j < n ; j++ ) {
				String name = new String();
				String kind = new String();

				name= sc.next();
				kind = sc.next();

				if ( !map.containsKey(kind) ) {
					map.put(kind, 1);
				} else if ( map.containsKey(kind) ) {
					Integer count = map.get(kind);
					count += 1;
					map.replace(kind,count);
				}
			}

			int result = 1;

			Iterator<Entry<String, Integer>> entries = map.entrySet().iterator();

			while (entries.hasNext()) {
				Map.Entry<String, Integer> entry = entries.next();
				result *= entry.getValue();
			}

			System.out.println(result-1);

		}

	}
}	

				
