#include <iostream>

using namespace std;

const int MAX = 1001;

int arr[MAX];

int fdp[MAX];
int bdp[MAX];

void solve (int n) {

	for (int i = 1 ; i <= n ; i++ ) 
	{
		fdp[i] = 1;

		for (int j = 1 ; j <= i ; j++ ) 
		{
			if ( fdp[i] < fdp[j] + 1 && arr[j] < arr[i] )
			{
				fdp[i] = fdp[j] + 1;
			}
		}
	}

	for (int i = n; i >= 1 ; i--)
	{
		bdp[i] = 1;
		for (int j = n; j >= i ; j-- )
		{
			if ( arr[j] < arr[i] && bdp[j] + 1 > bdp[i] )
			{
				bdp[i] = bdp[j] + 1;
			}
		}
	}

	int ans = 0;

	for (int i = 0; i <= n ; i++ )
	{
		if ( ans < fdp[i] + bdp[i] - 1 )
		{
			ans = fdp[i] + bdp[i] - 1;
		}
	}

	cout << ans << endl;

}


int main (void) {
	
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n;
	cin >> n;

	for (int i = 1 ; i <= n ; i++ )
		cin >> arr[i];

	solve(n);

	return 0;
}
	
