#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef long long ll;

const ll MOD = 1000000007LL;

int N, K;

// mode MOD 거듭제곱(분할정복)
ll pow(ll a, ll b) {
	if (b == 0) return 1;
	if (b % 2 > 0) return (pow(a, b - 1) * a) % MOD;
	ll half = pow(a, b / 2) % MOD;
	return (half * half) % MOD;
}

int main()
{
	cin >> N >> K;
	ll A = 1, B = 1;

	for (ll i = 1; i <= N; i++) { // A = n! , B = k!(n-k)!
		A *= i;
		A %= MOD;
	}

	for (ll i = 1; i <= K; i++) {
		B *= i;
		B %= MOD;
	}

	for (ll i = 1; i <= N - K; i++) {
		B *= i;
		B %= MOD;
	}
	
	ll B2 = pow(B, MOD - 2);
	ll ans = A * B2;
	ans %= MOD;
	cout << ans << endl;
	return 0;
}
