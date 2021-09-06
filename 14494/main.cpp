#include <iostream>

using namespace std;

typedef long long ll;

int main (void) {

	int n, m ;
	ll DIV = 1000000007;

	ll mat[1001][1001];
	cin >> n >> m;
	mat[0][0] = 1;	
	for (int i = 1; i <= n ; i++ ) {
		for ( int j = 1; j <= m; j++ ) {
			if ( i == 1 ) {
				mat[i][j] = 1;
			}
			else if (j == 1 ) {
				mat[i][j] = 1;
			}
			else {		
				mat[i][j] = mat[i-1][j-1];
				mat[i][j] = ( mat[i][j] + mat[i][j-1] ) % DIV;
				mat[i][j] = ( mat[i][j] + mat[i-1][j] ) % DIV;
			}
		}
	}

	cout << mat[n][m];

	return 0;
}
