import sys
input = sys.stdin.readline

N, M = map(int, input().split())

ans = [0] * M
visited = [False] * N


def dfs(n, m, depth):
    if m == depth:
        for i in ans:
            print(str(i), end=' ')
        print()
        return

    for i in range(N):
        if visited[i] is False:
            visited[i] = True
            ans[depth] = i + 1
            dfs(n, m, depth + 1)
            visited[i] = False


dfs(N, M, 0)

