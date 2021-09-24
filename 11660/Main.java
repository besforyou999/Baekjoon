import java.util.Scanner;

public class Main {
	public static void main (String [] args) {

		Scanner sc = new Scanner(System.in);
		
		final int MAX = 1025;
		int N, M;
		int x1,y1,x2,y2;	

		int mat[][] = new int[MAX][MAX];	

		N = sc.nextInt();
		M = sc.nextInt();

		for ( int i = 1 ; i <= N ; i++ ) {
			for ( int j = 1 ; j <= N ; j++ ) {
				mat[i][j] = sc.nextInt();
				mat[i][j] += ( mat[i-1][j-1]

		for ( int i = 1 ; i <= M ; i++ ) {
			x1 = sc.nextInt(); y1 = sc.nextInt(); 
			x2 = sc.nextInt(); y2 = sc.nextInt();

				
