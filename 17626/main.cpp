#include <iostream>
#include <climits>

using namespace std;

int main (void) {

	int n, MIN;
	int dp[50001];	
	dp[0] = 0, dp[1] = 1;

	cin >> n;
	
	for (int i = 1 ; i <= n ; i++ ) {
		MIN = INT_MAX;
		for ( int j = 1 ; j * j <= i ; j++ ) {
			MIN = min(MIN, dp[i-j*j]);
		}
		dp[i] = MIN + 1;
	}

	cout << dp[n];
	return 0;
}
