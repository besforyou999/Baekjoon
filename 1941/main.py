import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline

graph = []
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# read graph
for _ in range(5):
    graph.append(list(map(str, input().rstrip())))

student_number = [i for i in range(25)]
combo_7 = combinations(student_number, 7)


def isYMoreThan4(combo):
    count_y = 0
    for num in list(combo):
        row = int(num / 5)
        col = int(num % 5)
        if graph[row][col] == 'Y':
            count_y += 1
        if count_y == 4:
            return True
    return False


lee_party_tokens = []

for item in combo_7:
    if isYMoreThan4(item) is False:
        lee_party_tokens.append(item)

answer = 0


def is_adj(combo):
    mat = [[0 for _ in range(5)] for _ in range(5)]
    visited = [[False for _ in range(5)] for _ in range(5)]
    start_y = 0
    start_x = 0
    for num in list(combo):
        start_y = row = int(num / 5)
        start_x = col = int(num % 5)
        mat[row][col] = 1

    count = 1
    queue = deque()
    queue.append((start_y, start_x))
    visited[start_y][start_x] = True

    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if ny < 0 or nx < 0 or ny >= 5 or nx >= 5:
                continue
            if mat[ny][nx] == 0 or visited[ny][nx] is True:
                continue

            visited[ny][nx] = True
            count += 1
            queue.append((ny, nx))

    if count == 7:
        return True
    return False


for i in lee_party_tokens:
    if is_adj(i):
        answer += 1

print(answer)


