import sys
input = sys.stdin.readline

N, M = map(int, input().split(' '))

ans = [0] * M


def dfs(n, m, depth):
    if M == depth:
        for i in ans:
            print(i, end=' ')
        print()
        return

    for i in range(N):
        ans[depth] = i + 1
        dfs(n, m, depth + 1)



dfs(N, M, 0)

