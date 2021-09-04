#include <iostream>

using namespace std;

int main (void) {

	int T;
	cin >> T;

	int arr[21] = {0,};

	for (int t = 0 ; t < T ; t++) {
		int N,M;
		cin >> N;
	
		for (int i = 1 ; i <= N ; i++ )
		   	cin >> arr[i];
	
		cin >> M;

		int dp[10001] = {0,};
		dp[0] = 1;

		for (int i = 1; i <= N ; i++)  {
			for (int j = arr[i] ; j <= M ; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}			
		
		cout << dp[M] << endl;

	}

return 0;
}
