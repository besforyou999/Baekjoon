#include <iostream>

using namespace std;

int N, K;

int weight[101];
int value[101];
int dp[101][100001];

int bigger(int a, int b) {
	if ( a > b )
		return a;
	else
		return b;
}

int main (void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> K;

	for ( int i = 1 ; i <= N ; i++) 
		cin >> weight[i] >> value[i];
	
	for ( int i = 1 ; i <= N ; i++ ) 
	{
		for (int j = 1; j <= K ; j++ )
		{
			if (j >= weight[i])
			   	dp[i][j] = bigger(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
			else
				dp[i][j] = dp[i-1][j];
		}
	}

	cout << dp[N][K];

	return 0;
}

