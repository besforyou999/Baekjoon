#include <iostream>

using namespace std;

int mat[301][301];
int dp[301][301];

int main (void) {

	int N, M;
	cin >> N >> M;

	for (int i = 1 ; i <= N ; i++) {
		for (int j = 1; j <= M ; j++ ) {
			cin >> mat[i][j];
		}
	}

	for ( int i = 1; i <= N; i++ ) {
		for ( int j = 1 ; j <= M ; j++ ) {
			dp[i][j] = max(dp[i][j], dp[i-1][j] + mat[i][j]);
			dp[i][j] = max(dp[i][j], dp[i][j-1] + mat[i][j]);
		}
	}

	cout << dp[N][M];

return 0;
}
