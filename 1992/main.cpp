#include <iostream>
#include <string>
using namespace std;
const int MAX = 64;
int N = 0;
int arr[MAX][MAX];

void compress (int x, int y, int n) {
	if ( n == 1 ) {
		cout << arr[y][x];
		return ;
	}
	bool zero = true, one = true;
	for (int i = y ; i < y + n ; i++)
		for (int j = x; j < x + n ; j++ )
			if (arr[i][j])
				zero = false;
			else
				one = false;
	if (zero)
		cout << 0;
	else if (one)
		cout << 1;
	else
	{
		cout << "(";
		compress(x, y, n / 2);
		compress(x + n / 2, y,  n / 2);
		compress(x, y + n / 2, n / 2);
		compress(x + n / 2 , y + n / 2, n / 2);
		cout << ")";
	}
	return;
}
int main(void) {
	cin >> N;
	for (int i = 0; i < N ; i++ ) {
		string s;
		cin >> s;
		for (int j = 0; j < N ; j++ ) 
			arr[i][j] = s[j] - '0';
	}
	compress(0,0,N);
	cout << endl;
}





	
