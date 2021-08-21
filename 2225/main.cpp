#include <iostream>
using namespace std;

#define MOD 1000000000

int main(void) {

	int dp[201][201] = { 0,};

	int n,k;
	cin >> n >> k;

	for (int i = 0; i <= n ; i++ ) 
	{
		dp[1][i] = 1;
		dp[0][i] = 0;
	}

	for (int i = 2; i <= k ; i++ )
	{
		for (int j = 0 ; j <= n ; j++ ) 
		{
			for ( int l = 0; l <= j; l++)
			{
				dp[i][j] = (dp[i][j] + dp[i-1][j-l] ) % MOD;
			}
		}
	}

	cout << dp[k][n];

return 0;
}

