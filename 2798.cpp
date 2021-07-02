#include <iostream>
#include <set>

using namespace std;

int main(void) {

	set<int> s;

	int N , M;

	cin >> N >> M;

	int * arr = (int*)malloc( sizeof(int) * N );

	for (int i = 0; i < N ; i++ ) {
		cin >> arr[i];
	}

	for (int i = 0; i < N-2 ; i++ ) {
		for (int j = i + 1 ; j < N - 1 ; j++ ) {
			for ( int z = j + 1 ; z < N ; z++ ) {
				int sum = arr[i] + arr[j] + arr[z];
				s.insert(sum);
			}
		}
	}

	set<int>::iterator iter;

	int best = M;

	while ( 1 ) { 
		iter = s.find(best);
		if ( iter != s.end() ) break;

		best--;
	}
	 
	cout << *iter;


	free(arr);
	arr = NULL;
}
