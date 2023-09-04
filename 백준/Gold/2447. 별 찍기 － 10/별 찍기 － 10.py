N = int(input())

graph = [[' '] * N for _ in range(N)]


def rec(r, c, length):
    if length == 3:
        graph[r][c] = graph[r][c + 1] = graph[r][c + 2] = '*'
        graph[r + 1][c] = graph[r + 1][c + 2] = '*'
        graph[r + 1][c + 1] = ' '
        graph[r + 2][c] = graph[r + 2][c + 1] = graph[r + 2][c + 2] = '*'
        return

    third = length // 3

    rec(r, c, third)
    rec(r + third, c, third)
    rec(r + 2 * third, c, third)

    rec(r, c + third, third)
    rec(r + 2 * third, c + third, third)

    rec(r, c + 2 * third, third)
    rec(r + third, c + 2 * third, third)
    rec(r + 2 * third, c + 2 * third, third)


rec(0, 0, N)

for r in graph:
    print("".join(r))