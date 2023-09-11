import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    positions = []
    n = int(input())
    for _ in range(n):
        x, y = map(int, input().split())
        positions.append((x, y))

    positions.sort()

    cafes = {}
    for x, y in positions:
        if x not in cafes:
            cafes[x] = [y]
        else:
            cafes[x].append(y)

    answers = ['empty']
    x_arr = [key for key in cafes]

    cur_y = 0

    for x in x_arr:
        y_arr = cafes[x]
        idx = y_arr.index(cur_y)
        if idx != 0:
            y_arr = reversed(y_arr)

        for y in y_arr:
            answers.append((x, y))

        cur_y = answers[-1][1]

    numbers = list(map(int, input().split()))
    m = numbers.pop(0)

    for num in numbers:
        print(*answers[num])