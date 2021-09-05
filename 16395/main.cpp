#include <iostream>

using namespace std;

int mat[32][32];

int main (void) {

	int n,k;	
	cin >> n >> k;

	for ( int i = 1; i <= n ; i++ ) {
		for (int j = 1 ; j <= i ; j++ ) {
			if ( j == 1 || i == j) {
				mat[i][j] = 1;
			}
			else {
				mat[i][j] = mat[i-1][j-1] + mat[i-1][j];
			}
		}
	}	
				
	cout << mat[n][k];
	return 0;
}
