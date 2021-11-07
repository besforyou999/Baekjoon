import java.util.Scanner;

public class Main {
	static String [][] mat;
	public static void main(String []args) {
		
		String [] names = { "Pizza arraak 145", "Bread kkk 30" };

		String []temp1 = names[0].split(" ");	

		for ( int i = 0 ; i < temp1.length ; i++ ) {
			System.out.println(temp1[i]);
		}
		Character test = 'a';
		String test2 = test.toString();

		System.out.println(test2);
	}
}
