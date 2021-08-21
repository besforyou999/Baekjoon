#include <iostream>

using namespace std;

const int MAX = 100001;
int n;
int arr[2][MAX];
int dp[2][MAX];

int Bigger(int a, int b) {

	if ( a > b ) {
		return a;
	}

	return b;
}


void solve()
{
	dp[0][0] = dp[1][0] = 0;
	dp[0][1] = arr[0][1];
	dp[1][1] = arr[1][1];

	for (int i = 2; i <= n ; i++)
	{
		dp[0][i] = Bigger(dp[1][i-1], dp[1][i-2]) + arr[0][i];
		dp[1][i] = Bigger(dp[0][i-1], dp[0][i-2]) + arr[1][i];
	}

	cout << Bigger(dp[0][n], dp[1][n]) << endl;

}

int main(void) {

	int T;
	cin >> T;

	while (T--) {
	
		cin >> n;
		
		for (int i = 1; i <= n; i++) {
			cin >> arr[0][i];
		}

		for (int i = 1; i <= n ; i++ ) {
			cin >> arr[1][i];
		}

		solve();
	}

}
