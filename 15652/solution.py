import sys
input = sys.stdin.readline

N, M = map(int, input().split(' '))

ans = [0] * M


def Be(numbers):
    result = True
    for idx in range(len(numbers) - 1):
        if numbers[idx] > numbers[idx + 1]:
            result = False
            break
    return result


def dfs(n, m, depth):
    if M == depth:
        if Be(ans):
            for i in ans:
                print(i, end=' ')
            print()
        return

    for i in range(N):
        ans[depth] = i + 1
        dfs(n, m, depth + 1)


dfs(N, M, 0)

