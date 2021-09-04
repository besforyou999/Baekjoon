#include <iostream>
 
using namespace std;
 
int main()
{
    //테스트케이스 T
    int T;
    cin >> T;
    int coin[21] = { 0 };
 
    for (int t = 0;t < T;t++) {
        //동전의 가짓수 N
        int N;
        //만들어야 할 금액 M
        int M;
        cin >> N;
 
        for (int n = 1;n <= N;n++) {
            cin >> coin[n];
        }
        cin >> M;
 
        int d[10001] = { 0 };
        d[0] = 1;
 
        for (int i = 1;i <= N;i++) {
            for (int j = coin[i];j <= M;j++) {
                d[j] += d[j - coin[i]];
            }
        }
        cout << d[M] << endl;
    }
 
    return 0;
}

