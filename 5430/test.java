public class test {
	public static void main(String [] args) {
		String line = "[1,2,3,4]";
		line = line.substring(1, line.length() - 1);
		String arr[] = line.split(",");

		for (int i = 0 ; i < arr.length ; i++) {
			System.out.println(arr[i]);
		}

	}
}
