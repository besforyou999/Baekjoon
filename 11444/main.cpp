#include <iostream>
#include <vector>
using namespace std;

typedef long long ll;
typedef	vector<vector<ll>> matrix;

matrix operator * (const matrix & a, const matrix & b) {
	
	ll size = 2;

	matrix res(size, vector<ll>(size));

	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 2; j++ ) {
			for (int k = 0; k < 2 ; k++ ) {
				res[i][j] += a[i][k] * b[k][j];
			}
			if ( res[i][j] >= 1000000007 ) res[i][j] %= 1000000007;
		}
	}

	return res;
}


matrix power(matrix a, ll n) {

	ll size = 2;	// 길이

	matrix res(size, vector<ll>(size)); // 반환할 행렬

	for (int i = 0; i < 2 ; i++ ) // 단위 행렬 생성
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

int main(void) {

	ll n;

	cin >> n;

	matrix ans(2, vector<ll>(2));

	ans[0][0] = 1;
	ans[0][1] = 1;
	ans[1][0] = 1;
	ans[1][1] = 0;

	ans = power(ans, n);

	
	cout << ans[1][0];


}
	
