#include <iostream>

using namespace std;

typedef long long ll;

int main (void) {
	int n;
	ll DIV = 1000000007;
	ll fib[1000001];

	fib[0] = 0;
	fib[1] = 1;

	cin >> n;

	if ( n <= 1 ) {
		cout << fib[n];
		return 0;
	}

	for (int i = 2 ; i <= n ; i++) 
		fib[i] = (fib[i-1] + fib[i-2]) % DIV;

	cout << fib[n];
	
	return 0;
}
