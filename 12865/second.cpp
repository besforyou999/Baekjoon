#include <iostream>

using namespace std;

const int MAX = 101;
const int MAX_WEIGHT = 100001;

int N,K;
int w_arr[MAX];
int v_arr[MAX];
int dp[MAX][MAX_WEIGHT];


int bigger( int a , int b ) {
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

	for ( int i = 1 ; i <= N ; i++ ) 
		cin >> w_arr[i] >> v_arr[i];

	for ( int i = 1 ; i <= N ; i++ ) {
		for ( int j = 1 ; j <= K ; j++ ) {
			if ( j >= w_arr[i] ) 
				dp[i][j] = bigger( dp[i-1][j], dp[i-1][j - w_arr[i]] + v_arr[i]);
			else
				dp[i][j] = dp[i-1][j];
		}
	}

	cout << dp[N][K];

	return 0;
}
