from collections import deque
m, n = map(int, input().split(' '))
graph = []
queue = deque([])
for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(m):
        if graph[i][j] == 1:
            queue.append([i,j])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0<=ny<n and 0<=nx<m and graph[ny][nx] == 0:
                queue.append([ny, nx])
                graph[ny][nx] = graph[y][x] + 1

bfs()

answer = 0
for i in graph:
    for j in i:
        if j == 0:
            print(-1)
            exit(0)
    answer = max(answer, max(i))

print(answer - 1)