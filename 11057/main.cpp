#include <iostream>

const int mod = 10007;

using namespace std;

int dp[1001][10];

int main(void) {
	int n, sum = 0;
	int i, j ,k;

	cin >> n;

	for (i = 0 ; i <= 9 ; i++ ) dp[1][i] = 1;

	for (i = 2; i <= n ; ++i) {
		for (j = 0; j <= 9; ++j) {
			for (k = j; k <= 9; ++k) {
				dp[i][k] += dp[i-1][j];
				dp[i][k] %= mod;
			}
		}
	}

	for (i = 0; i <= 9; ++i) sum += dp[n][i];

	cout << sum % mod ;

	return 0;
}
