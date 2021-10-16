#include <iostream>

using namespace std;

int Fib[1001];

int fib(int n) {
	if ( n <= 1 ) return n;

	return fib(n-2) + fib(n-1);

}

void fib2(int n) {
	Fib[0] = 0;
	Fib[1] = 1;

	for ( int i = 2 ; i <= n ; i++ ) {
		Fib[i] = Fib[i-1] + Fib[i-2];
	}
}

int main(void) {
	int a ;

	cin >> a;

	int f = fib(a);

	cout << f;

}


