#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef vector<vector<ll>> matrix;

matrix operator * (const matrix &a, const matrix & b) {
	ll size = a.size();
	matrix res(size,vector<ll>(size));

	for ( int i = 0; i < size ; i++ ) {
		for ( int j = 0; j < size; j++ ) {
			for ( int z = 0; z < size ; z++ ) {
				res[i][j] += a[i][z] * b[z][j];
			}
			res[i][j] %= 1000;
		}
	}
	return res;
}


matrix power(matrix &a, ll n) {
	
	ll size = a.size();
	matrix res(size, vector<ll>(size));

	for (int i = 0; i < size ; i++ ) 
		res[i][i] = 1;

	
	while ( n > 0 ) {
		if ( n % 2 == 1 ) {
			res = res * a;
		}
		n /= 2;
		a = a * a;
	}

	return res;
}



void Print(const matrix & a) {
	ll size = a.size();
	for (int i = 0; i < size ; i++ ) {
		for (int j = 0 ; j < size ; j++ ) {
			cout << a[i][j] << " ";
		}
		cout << endl;
	}
}


int main (void) {

	int N;
	ll B;

	cin >> N >> B;

	matrix a(N, vector<ll>(N));

	for (int i = 0; i < N ; i++ ) 
		for (int j = 0; j < N ; j++ ) 
			cin >> a[i][j];
	
	Print(power(a, N));

	return 0;
}	
	

