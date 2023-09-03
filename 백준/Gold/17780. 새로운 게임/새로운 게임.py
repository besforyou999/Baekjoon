import sys

N, K = map(int, input().split())

# 우, 좌, 상, 하
dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

stacks = [[[] for _ in range(N)] for _ in range(N)]
horses = []
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

for i in range(K):
    r, c, direction = map(int, input().split())
    horses.append([r - 1, c - 1, direction - 1])
    stacks[r - 1][c - 1].append(i)


def move(horse_number):
    r, c, direction = horses[horse_number]

    if horse_number != stacks[r][c][0]:
        return 0

    nr = r + dr[direction]
    nc = c + dc[direction]

    # 움직일 좌표가 밖이거나 파란색 블록인 경우
    if not 0 <= nr < N or not 0 <= nc < N or graph[nr][nc] == 2:
        if 0 <= direction <= 1:
            nd = (direction + 1) % 2
        else:
            nd = (direction - 1) % 2 + 2
        horses[horse_number][2] = nd
        nr = r + dr[nd]
        nc = c + dc[nd]
        if not 0 <= nr < N or not 0 <= nc < N or graph[nr][nc] == 2:
            return 0

    stack = stacks[r][c]

    # 흰색 블록인 경우
    if graph[nr][nc] == 0:
        for num in stack:
            stacks[nr][nc].append(num)
            horses[num][0] = nr
            horses[num][1] = nc
        stack.clear()
    elif graph[nr][nc] == 1:
        for num in reversed(stack):
            stacks[nr][nc].append(num)
            horses[num][0] = nr
            horses[num][1] = nc
        stack.clear()

    if len(stacks[nr][nc]) >= 4:
        return 1

    return 0


turn = 1

while turn <= 1000:
    for i in range(K):
        flag = move(i)
        if flag:
            print(turn)
            sys.exit(0)
    turn += 1

print(-1)