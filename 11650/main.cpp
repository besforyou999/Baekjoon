#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class coord {
	public :
		int x;
		int y;

	coord(int x, int y) {
		this->x = x;
		this->y = y;		
	}
};

bool compare(coord & a, coord & b) {

	if (a.x < b.x ) {
		return true;
	} 
	else if ( a.x == b.x) {
		if (a.y < b.y) {
			return true;
		}
		else {
			return false;
		}
	}
	else 
		return false;
}


int main (void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;
	int x , y = 0;

	vector<coord> v;

	for (int i = 0; i < n ; i++) {
		cin >> x >> y;
		v.push_back(coord(x,y));
	}

	sort(v.begin(), v.end() , compare);

	for (int i = 0; i < n ; i++ ) {
		cout << v[i].x << " " << v[i].y << endl;
	}

	return 0;
}



