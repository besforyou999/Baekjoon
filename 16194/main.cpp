#include <iostream>

using namespace std;

const int MAX = 1001;
int N;
int arr[MAX];
int dp[MAX];

int smaller(int a, int b) {
	if ( a > b )
		return b;
	else

	return a;
}

int main (void) {

	cin >> N;

	for (int i = 1 ; i <= N ; i++ )
		cin >> arr[i];

	dp[1] = arr[1];

	for (int i = 2 ; i <= N ; i++ ) {
		dp[i] = arr[i];
		for (int j = 1; j <= i ; j++ ) {
			dp[i] = smaller(dp[i] , dp[i-j] + arr[j]);
		}
	}

	cout << dp[N];

return 0;
}
