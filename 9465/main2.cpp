#include <iostream>

using namespace std;

const int MAX = 100001;

int dp[2][MAX];
int mat[2][MAX];
int T, n;

int main (void) {

	cin >> T;
	
	while (T--) {
		cin >> n;

		for (int i = 0; i < 2; i++ ) 
			for (int j = 1 ; j <= n ; j++ ) 
				cin >> mat[i][j];

		dp[0][0] = dp[1][0] = 0;
		dp[0][1] = mat[0][1];
		dp[1][1] = mat[1][1];

		for (int i = 2; i <= n ; i++) {
			dp[0][i] = 	
		


}
