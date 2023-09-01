from collections import deque

N, K = map(int, input().split())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def is_in(x, y):
    return 0 <= x < N and 0 <= y < N


graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

virus_arr = []

for r in range(N):
    for c in range(N):
        if graph[r][c] > 0:
            virus_arr.append((graph[r][c], r, c))

virus_arr.sort(key=lambda e: e[0])
queue = deque(virus_arr)

S, X, Y = map(int, input().split())

for _ in range(S):
    size = len(queue)
    for _ in range(size):
        virus, r, c = queue.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if is_in(nr, nc) and graph[nr][nc] == 0:
                graph[nr][nc] = virus
                queue.append((virus, nr, nc))

print(graph[X - 1][Y - 1])