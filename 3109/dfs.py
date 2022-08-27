import sys
input = sys.stdin.readline


def solve(i, j):
    if j == C - 1:
        return True
    for d in dx:
        if 0 <= i + d < R and graph[i+d][j+1] == "." and not visited[i+d][j+1]:
            visited[i+d][j+1] = True
            if solve(i+d, j+1):
                return True
    return False


R, C = map(int, input().split())
graph = [list(input().rstrip()) for _ in range(R)]
visited = [[False] * C for _ in range(R)]

dx = [-1, 0, 1]
ans = 0
for i in range(0, R):
    if graph[i][0] == ".":
        if solve(i, 0):
            ans += 1

print(ans)

