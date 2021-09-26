#include <iostream>

using namespace std;

int main (void) {

	int n;
	const int MAX = 5000;
	cin >> n;

	int minTotalBags = MAX;

	for ( int i = 0 ; i <= n / 3 ; i++ ) {
		int temp = 0;
		temp += i;
		
		if ( ( n - i*3 ) % 5 == 0 ) {
			int fiveKiloBagNum = ( n - i * 3 ) / 5;
			temp += fiveKiloBagNum;
			if ( minTotalBags > temp ) minTotalBags = temp;
		}
	}

	if ( minTotalBags == MAX ) {
		cout << -1;
		return 0;
	}

	cout << minTotalBags;

	return 0;
}
