#include <iostream>

using namespace std;

int main (void) {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int P , N , M;
	cin >> P;

	int cnt, a, b;

	while (P--) {

		cin >> N >> M;
		cnt = 0;
		a = b = 1;

		while (1) {

			int temp = ( a + b ) % M;
			a = b;
			b = temp;
			cnt++;

			if ( a== 1 && b == 1 ) break;
		}

		cout << N << " " << cnt << endl;
	}
}
		
