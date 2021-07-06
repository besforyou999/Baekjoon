#include <iostream>

using namespace std;

int main(void) {
	int first , second;

	cin >> first >> second;

	int arr1[10001];
	int arr2[10001];

	for (int i = 1 ; i <= first ; i++ ) {
		if ( first % i == 0 ) {
			arr1[i] = 1;
		}
	}

	for (int i = 1 ; i <= second ; i++ ) {
		if ( second % i == 0 ) {
			arr2[i] = 1;
		}
	}

	int maxDiv = 0;

	for (int i = 10000 ; i >= 0 ; i--) {
		if ( arr1[i] != 0 && arr2[i] != 0 ) {
			maxDiv = i;
			break;
		}
	}

	int minMul = first * second;
	minMul /= maxDiv;
	cout << maxDiv << endl << minMul ;

}
