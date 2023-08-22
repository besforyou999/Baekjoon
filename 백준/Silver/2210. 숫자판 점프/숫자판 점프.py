def dfs(r, c, number):
    if len(number) == 6:
        if number not in result:
            result.append(number)
        return

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]

        if 0 <= nr < 5 and 0 <= nc < 5:
            dfs(nr, nc, number + graph[nr][nc])


graph = [list(map(str, input().split())) for _ in range(5)]

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

result = []
for i in range(5):
    for j in range(5):
        dfs(i, j, graph[i][j])

print(len(result))