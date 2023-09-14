T = int(input())

for _ in range(T):
    N = int(input())
    X = list(map(int, input().split()))
    X.insert(0, 0)

    for i in range(1, N + 1):
        X[i] = X[i] + X[i - 1]

    ans = -1e10

    for i in range(1, N + 1):
        for j in range(i):
            ans = max(ans, X[i] - X[j])

    print(ans)