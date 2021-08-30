#include <iostream>
using namespace std;
 
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
 
    int n, m, x;
    int x1, x2, y1, y2;
    int sum[1025][1025];
 
    cin >> n >> m;
 
    for (int i = 1; i <= n; i++)
    {
        for (int j = 1; j <= n; j++)
        {
            cin >> x;
 
            sum[i][j] = x + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
        }
    }
 
    for (int i = 0; i < m; i++)
    {
        cin >> x1 >> y1 >> x2 >> y2;
 
        cout << sum[x2][y2] - (sum[x1 - 1][y2] + sum[x2][y1 - 1]) + sum[x1 - 1][y1 - 1] << "\n";
    }
 
    return 0;
}
