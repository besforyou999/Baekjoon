#include <iostream>

using namespace std;

int main(void) {
	
	int N , K;

	cin >> N >> K;

	int * arr = (int*)malloc( sizeof(int) * N );

	for (int i = 0 ; i < N ; i++ ) {
		cin >> arr[i];
	}
	
	int count = 0;

	while ( K != 0 ) {
		count += K / arr[N-1] ;
		K = K % arr[N-1];
		N--;
	}

	cout << count;
	
	
	free(arr);
	arr = NULL;

	return 0;
}
