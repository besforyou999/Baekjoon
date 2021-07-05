#include <iostream>
#include <climits>
using namespace std;

int main(void) {
	
	long long distance[100001];
	long long cpl[100000];
	
	int N;
	cin >> N;
	for (int i = 0; i < N - 1 ; i++ )
		cin >> distance[i];
	for (int i = 0; i < N  ; i++ )
		cin >> cpl[i];

	long long greedy = LLONG_MAX;
	long long cost = 0;
	for (int i = 0; i < N - 1 ; i++ ) {
		if ( greedy > cpl[i]) 
			greedy = cpl[i];
			
		cost += greedy * distance[i];
	}
	cout << cost;
	return 0;
}
