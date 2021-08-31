#include <iostream>

using namespace std;

const int MAX = 1001;

int p_arr[MAX];
int dp[MAX];
int n;

int main (void ) {

	cin >> n;

	for ( int i = 1 ; i <= n ; i++ ) 
		cin >> p_arr[i];

	for (int i = 1 ; i <= n ; i++ ) {
		for (int j = 1 ; j <= i ; j++ ) {
			dp[i] = max(dp[i] , dp[i-j] + p_arr[j]);
		}
	}

	cout << dp[n];

return 0;
}
