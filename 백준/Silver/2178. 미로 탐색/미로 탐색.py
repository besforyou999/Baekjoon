import sys
from collections import deque

input = sys.stdin.readline

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def is_in(r, c):
    return 0 <= r < N and 0 <= c < M


N, M = map(int, input().split())

graph = []
for i in range(N):
    graph.append(list(map(int, input().rstrip())))

visit = [[False] * M for _ in range(N)]
queue = deque()
queue.append((0, 0, 1))

while queue:
    r, c, cnt = queue.popleft()

    if r == N - 1 and c == M - 1:
        print(cnt)
        sys.exit(0)

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]

        if is_in(nr, nc) and not visit[nr][nc] and graph[nr][nc] == 1:
            visit[nr][nc] = True
            queue.append((nr, nc, cnt + 1))