#include <iostream>
#include <cstring>

using namespace std;

const int DIV = 1000000007;
const int MAX = 51;
typedef long long ll; 

ll dp[MAX][MAX][MAX][MAX];

ll solve(int s, int d, int k, int h) {

	if ( s == 0 ) {
		if ( d == 0 && k == 0 && h == 0 ) 
			return 1;
		else
			return 0;
	}

	ll &ret = dp[s][d][k][h];

	if (ret != -1)
		return ret;

	ret = 0;

	ret += solve(s-1, d-1, k, h);
	ret += solve(s-1, d, k-1, h);
	ret += solve(s-1, d, k, h-1);
	ret += solve(s-1, d-1, k-1, h);
	ret += solve(s-1, d, k-1, h-1);
	ret += solve(s-1, d-1, k, h-1);
	ret += solve(s-1, d-1, k-1, h-1);
	
	ret %= DIV;
	return ret;
}


int main (void) {

	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int s,d,k,h;
	cin >> s >> d >> k >> h;

	memset(dp, -1, sizeof(dp));
	cout << solve(s, d, k, h) << endl;

	return 0;
}
			
