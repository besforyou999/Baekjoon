#include <iostream>

using namespace std;

const int MAX = 501;

int mat[MAX][MAX];
int dp[MAX][MAX];
int N;

int get_big(int a, int b) {
	if ( a > b )
		return a;
	else
		return b;
}


int main (void) {

	cin >> N;

	for (int i = 1 ; i <= N ; i++ ) 
		for (int j = 1 ; j <= i ; j++ ) 
			cin >> mat[i][j];

	dp[1][1] = mat[1][1];

	for (int i = 2 ; i <= N ; i++ ) {
		for (int j = 1 ; j <= i ; j++ ) {
			if ( j == 1 ) {
				dp[i][j] += ( dp[i-1][j] + mat[i][j]);
			}
			else if ( j == i ) {
				dp[i][j] += ( dp[i-1][j-1] + mat[i][j]);
			}
			else {
				dp[i][j] += ( get_big(dp[i-1][j], dp[i-1][j-1]) + mat[i][j] );
			}
		}
	}

	int max = -1;

	for (int i = 1; i <= N ; i++ ) {
		if ( dp[N][i] > max ) {
			max = dp[N][i];
		}
	}

	cout << max;

	return 0;
}
