#include <iostream>

using namespace std;

const int DIV = 10007;
const int LEN = 1001;
int N;
int dp[LEN][10];

int main(void) {

	cin >> N;

	if ( N == 1 ) {
		cout << 10;
		return 0;
	}

	for ( int i = 0; i < 10 ; i++ ) 
		dp[1][i] = 1;

	for (int i = 2 ; i <= N ; i++ ) {
		for (int j = 0; j < 10 ; j++ ) {
			for (int k = 0; k <= j ; k++ ) {
				dp[i][j] = dp[i][j] + dp[i-1][k];
				dp[i][j] = dp[i][j] % DIV;
			}
		}
	}

	int sum = 0;

	for ( int i = 0; i < 10 ; i++ ) 
		sum += dp[N][i];

	sum %= DIV;

	cout << sum;

	return 0;
}
	

		

