#include <iostream>
#include <vector>

using namespace std;

int dp[1001];

int find_max(int a, int b ) {

	if ( a > b )
		return a;

	return b;
}

int main(void) {

	int n;
	cin >> n;

	vector<int> v(n+1);

	for (int i = 1; i <= n ; i++ ) 
		cin >> v[i];

	for (int i=1; i<= n ;i++ ) {
		for (int j = 1; j <= i ; j++ ) {
			dp[i] = find_max(dp[i], dp[i-j] + v[j]);
		}
	}

	cout << dp[n];

return 0;
}

