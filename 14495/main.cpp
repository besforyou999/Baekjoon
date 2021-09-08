#include <iostream>

using namespace std;

int main (void) {

	long long fib[130];
	int n;
	cin >> n;

	fib[1] = fib[2] = fib[3] = 1;
	fib[4] = 2;
	fib[5] = 3;
	fib[6] = 4;
	fib[7] = 6;

	if ( n <= 7 ) {
		cout << fib[n];
		return 0;
	}

	for ( int i = 8 ; i < 130 ; i++ )
		fib[i] = fib[i-1] + fib[i-3];

	cout << fib[n];	

	
	return 0;
}
