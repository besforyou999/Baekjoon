import sys
input = sys.stdin.readline

# direction 0, 1, 2, 3 (상, 하, 좌, 우)
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def shoot(r, c, direction):

    while True:

        nr = r + dr[direction]
        nc = c + dc[direction]

        if nr < 0 or nr > N - 1 or nc < 0 or nc > M - 1:
            return nr, nc

        if graph[nr][nc] == 1:
            if direction == 0: # 상 -> 우
                direction = 3
            elif direction == 1: # 하 -> 좌
                direction = 2
            elif direction == 2: # 좌 -> 하
                direction = 1
            else: # 우 -> 상
                direction = 0

        r, c = nr, nc


N, M = map(int, input().split())

graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

count = 1
start_pos = {}

for i in range(N):
    start_pos[(i, -1)] = count
    count += 1

for i in range(M):
    start_pos[(N, i)] = count
    count += 1

for i in range(N):
    start_pos[(N - i - 1, M)] = count
    count += 1

for i in range(M):
    start_pos[(-1, M - i - 1)] = count
    count += 1

answer = []

for i in range(N):
    result = shoot(i, -1, 3)
    answer.append(start_pos[result])

for i in range(M):
    result = shoot(N, i, 0)
    answer.append(start_pos[result])

for i in range(N):
    result = shoot(N - i - 1, M, 2)
    answer.append(start_pos[result])

for i in range(M):
    result = shoot(-1, M - i - 1, 1)
    answer.append(start_pos[result])

for i in answer:
    print(i, end=' ')