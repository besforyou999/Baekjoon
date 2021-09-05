#include <iostream>
#include <cstring>
using namespace std;
 
const int MAX = 100 + 1;
 
int N, K;
int cache[MAX][MAX][2]; //N, K, 0 or 1
 
int numOfSequence(int len, int total, int bit)
{
        //기저 사례
        if (len >= N || total > K)
                 return 0;
        //조건 충족
        if (len == N - 1 && total == K)
                 return 1;
 
        int &result = cache[len][total][bit];
        if (result != -1)
                 return result;
 
        //다음 비트는 0일 수도 1일 수도 있다
        result = numOfSequence(len + 1, total, 0) + numOfSequence(len + 1, total + bit * 1, 1);
        return result;
}
 
int main(void)
{
        int T;
        cin >> T;
 
        for (int i = 0; i < T; i++)
        {
                 cin >> N >> K;
 
                 memset(cache, -1, sizeof(cache));
 
                 //s1=0 or 1
                 cout << numOfSequence(0, 0, 0) + numOfSequence(0, 0, 1) << endl;
        }
        return 0;
}



