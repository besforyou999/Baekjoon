#include <iostream>

using namespace std;

const int DIV = 10007;
const int MAX = 1001;
int N,K;
int dp[MAX][MAX];

int main (void) {

	cin >> N >> K;

	dp[0][0] = 1;
	dp[1][0] = dp[1][1] = 1;
	dp[2][0] = dp[2][2] = 1;
	dp[2][1] = 2;	

	for ( int i = 3 ; i <= N ; i++ ) {
		for ( int j = 0 ; j <= i ; j++ ) {
			if ( j == 0 || i == j)
				dp[i][j] = 1;
			else
				dp[i][j] = ( dp[i-1][j] + dp[i-1][j-1]) % DIV;
		}
	}

	cout << dp[N][K];

	return 0;
}


/*
1
1	1
1	2	1
1	3	3	1
*/
