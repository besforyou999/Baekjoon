#include <iostream>

using namespace std;

int dp[1001][1001];

int N,M;

int get_max(int a, int b, int c) {
	
	int max = 0;
	if ( max < a ) max = a;
	if ( max < b ) max = b;
	if ( max < c ) max = c;
	return max;

}

int main (void) {
	int temp;
	cin >> N >> M;

	for (int i = 1 ; i <= N ; i++) {
		for (int j = 1 ; j <= M ; j++ ) {
			cin >> temp;
			dp[i][j] = get_max(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + temp;			
		}
	}
	
	cout << dp[N][M];

	return 0;
}
