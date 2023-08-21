import sys
input = sys.stdin.readline

dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, 1, 1, 1, 0, -1, -1, -1]

N = int(input())
graph = []

for _ in range(N):
    graph.append(list(input().rstrip()))

heartR, heartC = 0, 0

# 심장 찾기
for r in range(1, N - 1):
    for c in range(1, N - 1):
        cnt = 0

        if graph[r][c] == '_':
            continue

        if graph[r - 1][c] == '*':
            cnt += 1

        if graph[r][c + 1] == '*':
            cnt += 1

        if graph[r + 1][c] == '*':
            cnt += 1

        if graph[r][c - 1] == '*':
            cnt += 1


        if cnt == 4:
            heartR = r
            heartC = c
            break

    if heartR != 0 and heartC != 0:
        break


def calc_left_arm():
    leftArm = -1
    r = heartR
    c = heartC

    while c >= 0 and graph[r][c] == '*':
        c -= 1
        leftArm += 1

    return leftArm


def calc_right_arm():
    rightArm = -1
    r = heartR
    c = heartC

    while c < N and graph[r][c] == '*':
        c += 1
        rightArm += 1

    return rightArm


def calc_waist():
    waist = -1
    r = heartR
    c = heartC

    while r < N and graph[r][c] == '*':
        r += 1
        waist += 1

    return waist


leftArm = calc_left_arm()
rightArm = calc_right_arm()
waist = calc_waist()

waistR = heartR + waist
waistC = heartC


def calc_left_leg():
    leg = 0
    r = waistR + 1
    c = waistC - 1

    while r < N and graph[r][c] == '*':
        r += 1
        leg += 1

    return leg


def calc_right_leg():
    leg = 0
    r = waistR + 1
    c = waistC + 1

    while r < N and graph[r][c] == '*':
        r += 1
        leg += 1

    return leg


left_leg = calc_left_leg()
right_leg = calc_right_leg()

print(str(heartR + 1) + ' ' + str(heartC + 1))
print(leftArm, end=' ')
print(rightArm, end=' ')
print(waist, end=' ')
print(left_leg, end=' ')
print(right_leg, end=' ')