N, K = map(int, input().split())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def is_in(x, y):
    return 0 <= x < N and 0 <= y < N


graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

virus_arr = [[] for _ in range(K + 1)]

for r in range(N):
    for c in range(N):
        if graph[r][c] > 0:
            virus_arr[graph[r][c]].append((r, c))

S, X, Y = map(int, input().split())

for _ in range(S):
    for i in range(1, K + 1):
        new_arr = []
        for r, c in virus_arr[i]:
            for d in range(4):
                nr = r + dr[d]
                nc = c + dc[d]
                if is_in(nr, nc) and graph[nr][nc] == 0:
                    graph[nr][nc] = i
                    new_arr.append((nr, nc))
        virus_arr[i] = new_arr

print(graph[X - 1][Y - 1])