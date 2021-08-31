#include <iostream>
#include <vector>

using namespace std;

int main (void) {

	int n;
	cin >> n;
	vector<int> arr(n);
	vector<int> dp(n);

	for (int i = 0; i < n ; i++) cin >> arr[i];

	for (int i = 0; i < n ; i++ ) {
		dp[i] = 1;
		for (int j = 0; j <	i ; j++ ) {
			if ( arr[i] < arr[j] && dp[j] + 1 > dp[i] ) 
				dp[i] = dp[j] + 1;
		}
	}

	int max = -1;

	for (int i = 0; i < n ; i++ ) {
		if ( dp[i] > max ) 
			max = dp[i];
	}		

	cout << max << endl;

	return 0;
}	
