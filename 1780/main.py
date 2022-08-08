import sys
input = sys.stdin.readline

N = int(input())

graph = [[] for _ in range(N)]

global answers
answers = {-1: 0, 0: 0, 1: 0}


def is_all_same(y, x, len):
    num = graph[y][x]
    for i in range(y, y + len):
        for j in range(x, x + len):
            if graph[i][j] != num:
                return False
    return True


for i in range(N):
    line = list(map(int, input().rstrip().split()))
    graph[i] = line


def rec(y, x, len):
    if is_all_same(y, x, len) or len == 1:
        num = graph[y][x]
        global answers
        answers[num] += 1
        return

    next_len = int(len / 3)

    rec(y, x, next_len)
    rec(y + next_len, x, next_len)
    rec(y + (2 * next_len), x, next_len)

    rec(y, x + next_len, next_len)
    rec(y + next_len, x + next_len, next_len)
    rec(y + (2 * next_len), x + next_len, next_len)

    rec(y, x + (2 * next_len), next_len)
    rec(y + next_len, x + (2 * next_len), next_len)
    rec(y + (2 * next_len), x + (2 * next_len), next_len)


rec(0, 0, N)

for item in answers:
    print(item)
