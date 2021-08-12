#include <iostream>
#include <queue>

using namespace std;

int main(void) {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n ;
	cin >> n;
	
	priority_queue<int> maxHeap , minHeap;

	for (int i = 0 ; i < n ; i++ ) {
		int temp;
		cin >> temp;

		if ( maxHeap.size() > minHeap.size() ) 
			minHeap.push(temp);
		else
			maxHeap.push(temp);

		if ( !maxHeap.empty() && !minHeap.empty() ) {
			if (minHeap.top() < maxHeap.top() ) {
				int max_val = maxHeap.top();
				int min_val = minHeap.top();

				maxHeap.pop();
				minHeap.pop();

				maxHeap.push(min_val);
				minHeap.push(max_val);
			}
		}

		cout << maxHeap.top() << endl;
	}

	return 0;
}
