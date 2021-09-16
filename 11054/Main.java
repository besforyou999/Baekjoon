import java.util.Scanner;

public class Main {
	public static void main(String [] args) {

		int N;
		int MAX = 1001;
		int [] arr = new int[MAX];
		int [] fdp = new int[MAX];
		int [] bdp = new int[MAX];

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for ( int i = 1 ; i <= N ; i++ ) 
			arr[i] = sc.nextInt();

		for ( int i = 1 ; i <= N ; i++) {
			fdp[i] = 1;
			for ( int j = 1 ; j <= i ; j++) {
				if ( fdp[i] < fdp[j] + 1 && arr[j] < arr[i] ) {
					fdp[i] = fdp[j] + 1;
				}
			}
		}

		for ( int i = N ; i >= 1 ; i--) {
			bdp[i] = 1;
			for ( int j = N ; j >= i ; j--) {
				if ( bdp[i] < bdp[j] + 1 && arr[j] < arr[i] ) {
					bdp[i] = bdp[j] + 1;
				}
			}
		}

		int ans = 0;

		for ( int i = 0 ; i <= N ; i++ ) {
			if ( ans < fdp[i] + bdp[i] - 1 ) {
				ans = fdp[i] + bdp[i] - 1;
			}
		}

		System.out.println(ans);		

		return ;
	}
}
