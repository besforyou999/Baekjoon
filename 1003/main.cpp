#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main (void) {

	int T;
	cin >> T;

	while (T--) {

		int x1, y1 , x2, y2;
		
		cin >> x1 >> y1 >> x2 >> y2;

		int n;
		cin >> n;

		vector<int> xi(n);
		vector<int> yi(n);
		vector<int> ri(n);
		
		int i = 0;	
		int N = n;

		while (n--) {
			cin >> xi[i] >> yi[i] >> ri[i];
			i++;	
		}	
		

		int count = 0;

		for (int i = 0; i < N ; i++ ) {
			
			int d = (x1 - xi[i]) * (x1 - xi[i]) + ( y1 - yi[i] ) * ( y1 - yi[i] );
			int t = (x2 - xi[i]) * (x2 - xi[i]) + ( y2 - yi[i] ) * ( y2 - yi[i] );

			int r = ri[i];

			bool first ,second;

			first = ( d > r * r ) ? true : false;
			second = ( t > r * r ) ? true : false;

			if (first != second ) count++;
		}
		
		cout << count << endl;
	}	

}
