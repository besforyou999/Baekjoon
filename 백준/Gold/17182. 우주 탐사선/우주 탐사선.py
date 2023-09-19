N, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]

for k in range(N):
    for i in range(N):
        for j in range(N):
            if graph[i][k] + graph[k][j] < graph[i][j]:
                graph[i][j] = graph[i][k] + graph[k][j]

visited = set()
visited.add(K)
min_time = int(1e9)


def dfs(num, cost):
    global min_time
    if len(visited) == N:
        min_time = min(min_time, cost)
        return

    for i in range(N):
        if i != num and i not in visited:
            visited.add(i)
            dfs(i, cost + graph[num][i])
            visited.remove(i)


dfs(K, 0)
print(min_time)