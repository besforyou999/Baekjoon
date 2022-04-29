#include <iostream>

using namespace std;

int main (void) {

	int n;
	cin >> n;

	const int MAX = 5000;

	int minBags = MAX;

	for (int i = 0 ; i <= n / 3 ; i++) {
		int temp = 0;
		temp += i;
	
		if ( ( n - i * 3 ) % 5 == 0 ) {
			int fiveKiloBag = ( n - i * 3 ) / 5;
			temp += fiveKiloBag;
			if (minBags > temp) minBags = temp;
		}
	}	

	if ( minBags == MAX ) {
		cout << -1;
		return 0;
	}

	cout << minBags;

	return 0;
} 
