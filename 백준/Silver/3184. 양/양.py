from collections import deque

R, C = map(int, input().split())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

graph = []
for _ in range(R):
    graph.append(list(input()))

visit = [[False] * C for _ in range(R)]

alive_sheep, alive_wolf = 0, 0

def bfs(i, j):
    queue = deque()
    queue.append((i, j))
    sheep, wolf = 0, 0

    while queue:
        r, c = queue.popleft()
        if graph[r][c] == 'o':
            sheep += 1
        elif graph[r][c] == 'v':
            wolf += 1

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < R and 0 <= nc < C:
                if not visit[nr][nc] and graph[nr][nc] != '#':
                    visit[nr][nc] = True
                    queue.append((nr, nc))

    if sheep == 0 and wolf == 0:
        return 0, 0

    if sheep > wolf:
        return sheep, 0
    else:
        return 0, wolf


for r in range(R):
    for c in range(C):
        if not visit[r][c]:
            result = bfs(r, c)
            alive_sheep += result[0]
            alive_wolf += result[1]

print(str(alive_sheep) + ' ' + str(alive_wolf))