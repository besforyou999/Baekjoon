#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

typedef struct pair {
	int start;
	int end;
} Pair;

bool cmp(Pair f, Pair t) {
	if ( f.end == t.end ) 
		return f.start < t.start;
	else
		return f.end < t.end;
}

int main(void) {
	
	int N;

	cin >> N;

	vector<Pair> v(N);

	for ( int i = 0 ; i < N ; i++ ) {
		cin >> v[i].start >> v[i].end;
	}

	sort(v.begin(), v.end(), cmp);
	
	int cnt = 0;
	int n = 0;

	for (int i = 0; i < v.size() ; i++ ) {
		if ( n <= v[i].start ) {
			n = v[i].end;
			cnt++;
		}
	}
	cout << cnt;

	return 0;
}

