#include <iostream>
using namespace std;

const int MAX = 35;
int A[MAX];
int B[MAX];

int main (void) {

	A[1] = 1, A[2] = 0,	B[1] = 0, B[2] = 1;

	int D , K, k;
	cin >> D >> K;
	for ( int i = 3 ; i <= D ; i++ ) {
		A[i] = A[i-1] + A[i-2];
		B[i] = B[i-1] + B[i-2];
	}	

	// finding a,b
	for (int i = 1; i <= 1000; i++) {
		k = K;
		k = k - A[D]*i;
		if ( k % B[D] == 0 ) {
			if ( i <= k/B[D] ) {
				cout << i << "\n" << k/B[D] ;
				return 0;
			}
		}	
	}	
	
	return 1;
}	

/*
   day 1 : A
   day 2 : B
   day 3 : A + B
   day 4 : 3A + 2B
   day 5 : 5A + 3B
   day 6 : 8A + 5B
   day 7 : 13A + 8B
   day 8 : 21A + 11B
   day 9 : 34A + 19B

   A[i] = A[i-1] + A[i-2]
   B[i] = B[i-1] + B[i-2]
*/


