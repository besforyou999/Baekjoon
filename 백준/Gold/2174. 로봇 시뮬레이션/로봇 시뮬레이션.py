import sys
input = sys.stdin.readline

# 0: N
# 1: E
# 2: S
# 3: W


def d_to_num():
    if d == "N":
        return 0
    elif d == "E":
        return 1
    elif d == "S":
        return 2
    else:
        return 3


dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

A, B = map(int, input().split())
N, M = map(int, input().split())

graph = [[0] * (A + 1) for _ in range(B + 1)]

robots = ['empty']

for _ in range(N):
    x, y, d = input().split()
    x = int(x)
    y = B - int(y) + 1
    robots.append((x, y, d_to_num()))
    graph[y][x] = len(robots) - 1

for _ in range(M):
    number, cmd, rep = input().split()
    number = int(number)
    rep = int(rep)
    x, y, direction = robots[number]
    for _ in range(rep):
        if cmd == "L":
            direction -= 1
            if direction < 0:
                direction = 3
        elif cmd == "R":
            direction += 1
            if direction > 3:
                direction = 0
        else:
            nx = x + dx[direction]
            ny = y + dy[direction]

            if nx < 1 or nx > A or ny < 1 or ny > B:
                print("Robot %d crashes into the wall" % number)
                sys.exit(0)
            if graph[ny][nx] != 0 and graph[ny][nx] != number:
                robotY = graph[ny][nx]
                print("Robot %d crashes into robot %d" % (number, robotY))
                sys.exit(0)

            graph[y][x] = 0
            graph[ny][nx] = number
            y = ny
            x = nx

        robots[number] = x, y, direction

print("OK")