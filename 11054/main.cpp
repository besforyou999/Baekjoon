#include <iostream>

using namespace std;

int arr[1001];

int front_dp[1001];
int back_dp[1001];

void solve(int n) {
	
	for (int i = 1 ; i <= n ; i++) {
		front_dp[i] = 1;
		for (int j = 1 ; j <= i ; j++ ) {
			if ( arr[j] < arr[i] && front_dp[i] < front_dp[j] + 1 ) {
				front_dp[i] = front_dp[j] + 1;
			}
		}
	}

	for (int i = n ; i >= 1 ; i--) {
		back_dp[i] = 1;
		for (int j = n; j >= i ; j--) {
			if ( arr[i] > arr[j] && back_dp[j] + 1 > back_dp[i] ) {
				back_dp[i] = back_dp[j] + 1;
			}
		}
	}

	int ans = 0;

	for (int i = 0; i <= n ; i++ )
	{
		if ( ans < front_dp[i] + back_dp[i] - 1 ) 
			ans = front_dp[i] + back_dp[i] - 1;
	}

	cout << ans << endl;
}
			

int main (void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1; i <= n ;i++) 
		cin >> arr[i];
	
	solve(n);

	return 0;
}
