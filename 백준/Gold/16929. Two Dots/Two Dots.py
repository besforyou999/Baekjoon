import sys
input = sys.stdin.readline

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def dfs(r, c, color):
    for i in range(4):
        nr, nc = r + dr[i], c + dc[i]
        if 0 <= nr < N and 0 <= nc < M:
            if graph[nr][nc] == color and visit[nr][nc] == 0:
                visit[nr][nc] = visit[r][c] + 1
                dfs(nr, nc, color)


N, M = map(int, input().split())
graph = [list(input().strip()) for _ in range(N)]

for r in range(N):
    for c in range(M):
        visit = [[0] * M for _ in range(N)]
        visit[r][c] = 1
        dfs(r, c, graph[r][c])

        # for r in range(N):
        #     for c in range(M):
        #         print(visit[r][c], end=' ')
        #     print()

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0 <= nr < N and 0 <= nc < M:
                if visit[nr][nc] >= 4:
                    print("Yes")
                    sys.exit(0)

print("No")