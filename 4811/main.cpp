#include <iostream>

using namespace std;
// W, H
long long dp[31][31];

int main (void) {

	int n;

	for (int i = 0; i < 31 ; i++) 
		dp[0][i] = 1;

	for (int i = 1; i <= 30 ; i++) {
		for (int j = 0; j <= 30 ; j++) {
			if ( j == 0 ) {
				dp[i][j] = dp[i-1][1];
			}	
			else {
				dp[i][j] = dp[i-1][j+1] + dp[i][j-1];
			}
		}
	}	
	cin >> n;
	while ( n != 0 ) {
		cout << dp[n-1][1] << endl;		
		cin >> n;
	}
	return 0;
}


