#include <iostream>
using namespace std;

int DP[1001] = {0, 1, 3};

const int limit = 10007;

int f(int n) {
	if (DP[n]) 
		return DP[n];

	return DP[n] = ( f(n-1) % limit + 2 * f(n-2) % limit) % 10007;
}

int main(){
	int n;
	cin >> n;
	cout << f(n) << endl;

	return 0;
}



	

