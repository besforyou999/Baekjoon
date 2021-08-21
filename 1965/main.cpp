#include <iostream>

using namespace std;

int arr[1001];
int dp[1001];

int n;

int main (void) {

	cin >> n;
	
	for (int i = 1 ; i <= n ; i++ ) { 
		cin >> arr[i];
		dp[i] = 1;
	}
	
	int max = 0;

	for (int i = 1; i <= n ; i++ ) 
	{
		for (int j = 1 ; j <= i ; j++ )
		{
			if ( arr[j] < arr[i] && dp[i] < dp[j] + 1 )
			{
				dp[i] = dp[j] + 1;	
			}
		}

		if ( max < dp[i] ) max = dp[i];
	}


	cout << max;
}	
