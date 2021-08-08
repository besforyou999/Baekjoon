#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class COD {
	public :
		int x;
		int y;

	COD(int _x, int _y) {
		x = _x;
		y = _y;
	}
};

bool compare (COD & a, COD & b) {
	if ( a.x < b.x ) {
		return true;
	}
	else if ( a.x == b.x) {
		if ( a.y < b.y ) 
			return true;
		else
			return false;
	}
	else
		return false;
}

int main (void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;
	int x = 0, y = 0;
	vector<COD> v;
	for (int i = 0; i < n ; i++ ) {
		cin >> x >> y;
		v.push_back(COD(x,y));
	}
	sort(v.begin(), v.end() , compare);
	for (int i = 0; i < v.size() ; i++ ) 
		cout << v[i].x << " " << v[i].y <<  endl;
}


