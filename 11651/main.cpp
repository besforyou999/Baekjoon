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
	if ( a.y < b.y ) {
		return true;
	}
	else if ( a.y == b.y) {
		if ( a.x < b.x ) 
			return true;
		else
			return false;
	}
	else
		return false;
}

int main (void) {
	int n;
	cin >> n;
	int x = 0, y = 0;
	vector<COD> v;
	for (int i = 0; i < n ; i++ ) {
		cin >> x >> y;
		v.push_back(COD(x,y));
	}
	sort(v.begin(), v.end() , compare);
	for (int i = 0; i < n ; i++ ) 
		cout << v[i].x << " " << v[i].y <<  endl;
}


