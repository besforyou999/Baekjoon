#include <iostream>

using namespace std;

int main (void) {

	int T;
	cin >> T;

	for (int i = 0; i < T ; i++ ) {
		
		int A,B;
		cin >> A >> B;
	
		int min = 0;

		for (int i = 1 ; i <= A && i <= B ; i++ ) {
			if ( A % i == 0 && B % i == 0 ) {
			   min = i;
			}
		}	

		int mul = A * B;
		mul /= min;

		cout << mul << endl;
	}

	return 0;		
}
