N = int(input())

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def valid(x, y):
    return 0 <= x < 5 and 0 <= y < 9


def dfs(r, c, pin_cnt, move_cnt):
    global min_pin, min_move
    if pin_cnt <= min_pin:
        min_pin = pin_cnt
        min_move = move_cnt

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if valid(nr, nc) and graph[nr][nc] == 'o':
            nr2 = nr + dr[i]
            nc2 = nc + dc[i]
            if valid(nr2, nc2) and graph[nr2][nc2] == '.':
                graph[r][c] = '.'
                graph[nr][nc] = '.'
                graph[nr2][nc2] = 'o'

                for y in range(5):
                    for x in range(9):
                        if graph[y][x] == 'o':
                            dfs(y, x, pin_cnt - 1, move_cnt + 1)

                graph[r][c] = 'o'
                graph[nr][nc] = 'o'
                graph[nr2][nc2] = '.'


for n in range(N):
    graph = []
    pin = 0
    for r in range(5):
        graph.append(list(input()))
        for c in range(9):
            if graph[r][c] == 'o':
                pin += 1

    min_pin = pin
    min_move = 0

    for r in range(5):
        for c in range(9):
            if graph[r][c] == 'o':
                dfs(r, c, pin, 0)

    print(min_pin, min_move)

    if n < N - 1:
        blank = input()