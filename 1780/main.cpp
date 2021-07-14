#include <iostream>
#include <string>

using namespace std;

#define MAX 2188

int arr[MAX][MAX];

// count[0] : -1 numbers , count[1] : 0 numbers , count[2] : 1 numbers
int count[3];


bool check(int x, int y, int n) {

	int first_num = arr[x][y];

	for (int i = x ; i < x + n ; i++ ) {
		for (int j = y ; j < y + n ; j++ ) {
			if ( first_num != arr[i][j] ) 
				return false;
		}
	}

	return true;
}


void division (int x, int y, int n ) {

	
	if ( check(x, y, n) ) {
		count[arr[x][y] + 1] += 1;
		return;
	}

	
	int d = n / 3;
	division(x , y , d);
	division(x + d , y , d);
	division(x + 2*d , y , d);
	division(x , y + d , d);
	division(x + d, y + d , d);
	division(x + 2*d, y + d , d);
	division(x , y + 2*d , d);
	division(x + d, y + 2*d , d);
	division(x + 2*d, y + 2*d , d);

}



int main(void) {
	
	int N;
	cin >> N;

	for (int i = 0; i < N ; i++ ) {
		for (int j = 0; j < N ; j++ ) 
			cin >> arr[i][j];
	}
	
	division(0 , 0 , N);

	cout << count[0] << endl;
	cout << count[1] << endl;
	cout << count[2] << endl;

	return 0;
}

