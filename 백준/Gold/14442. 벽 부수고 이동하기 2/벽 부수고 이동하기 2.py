import sys
from collections import deque
input = sys.stdin.readline

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

N, M, K = map(int, input().split())
visit = [[[0] * (K + 1) for _ in range(M)] for _ in range(N)]
graph = [list(map(int, input().strip())) for _ in range(N)]


def bfs():
    queue = deque()
    queue.append((0, 0, 0))
    visit[0][0][0] = 1

    while queue:
        r, c, k = queue.popleft()

        if r == N - 1 and c == M - 1:
            return visit[r][c][k]

        for i in range(4):
            nr, nc = r + dr[i], c + dc[i]
            if 0 <= nr < N and 0 <= nc < M:
                if graph[nr][nc] == 0 and visit[nr][nc][k] == 0:
                    visit[nr][nc][k] = visit[r][c][k] + 1
                    queue.append((nr, nc, k))
                elif graph[nr][nc] == 1 and k < K: # 벽 부순 횟수가 K 이하일때만 이동 가능
                    if visit[nr][nc][k + 1] == 0:
                        visit[nr][nc][k + 1] = visit[r][c][k] + 1
                        queue.append((nr, nc, k + 1))

    return -1


print(bfs())