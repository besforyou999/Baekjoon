#include <iostream>
#include <set>
using namespace std;

const int MAX = 9;

int N, M;
int arr[MAX] = {0,};
bool visited[MAX] = {0,};

void dfs(int cnt) {

	if (cnt == M ) {
		for (int i = 0; i < M ; i++ ) 
			cout << arr[i] << " ";

		cout << endl;

		return ;
	}

	for (int i = 1; i <= N ; i++ ) {
		if (!visited[i]) {
			visited[i] = true;
			arr[cnt] = i;
			dfs(cnt + 1 );
			visited[i] = false;
		}
	}

}

int main(void) {
	
	cin >> N >> M;

	dfs(0);
		
	return 0;
}
