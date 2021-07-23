#include <iostream>
#include <algorithm>

using namespace std;

int INF = 1000000007;

int dp[501][501];
int cost[501];
int sum[501];
int T, K, i;

int main() {
	cin >> T;

	while (T--) {
		cin >> K;
		for (int i = 1; i <= K; i++) {
			cin >> cost[i];
			sum[i] = sum[i-1] + cost[i];
		}
		for (int i = 1; i < K; i++) {
			for (int j = 1; j + i <= K; j++) {
				int v = j + i;
				dp[j][v] = INF;
				for (int u = j; u < j + i; u++)
					dp[j][v] = min(dp[j][v], dp[j][u] + dp[u + 1][v] + sum[j + i] - sum[j - 1]);

			}
		}

		cout << dp[1][K] << endl;

	}
}