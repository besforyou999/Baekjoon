import sys

input = sys.stdin.readline

N = int(input())
An = list(map(int, input().split(' ')))
plus, minus, multi, div = map(int, input().split(' '))

maximum = -1e9
minimum = 1e9


def dfs(depth, total, plus, minus, multi, div):
    global maximum, minimum
    if depth == N:
        maximum = max(total, maximum)
        minimum = min(total, minimum)
        return

    if plus:
        dfs(depth + 1, total + An[depth], plus - 1, minus, multi, div)
    if minus:
        dfs(depth + 1, total - An[depth], plus, minus - 1, multi, div)
    if multi:
        dfs(depth + 1, total * An[depth], plus, minus, multi - 1, div)
    if div:
        dfs(depth + 1, int(total / An[depth]), plus, minus, multi, div - 1)


dfs(1, An[0], plus, minus, multi, div)

print(maximum)
print(minimum)

