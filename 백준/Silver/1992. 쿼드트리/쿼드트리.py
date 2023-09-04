import sys

N = int(input().rstrip())

graph = []

for _ in range(N):
    graph.append(list(input().rstrip()))


def rec(r, c, length):
    if length == 1:
        return graph[r][c]

    ch = graph[r][c]
    half = length // 2
    compress = True

    for x in range(length):
        for y in range(length):
            if ch != graph[r + x][c + y]:
                compress = False
                break
        if not compress:
            break

    if compress:
        return ch
    else:
        return '(' + rec(r, c, half) + rec(r, c + half, half) + rec(r + half, c, half) + rec(r + half, c + half, half) + ')'


print(rec(0, 0, N))