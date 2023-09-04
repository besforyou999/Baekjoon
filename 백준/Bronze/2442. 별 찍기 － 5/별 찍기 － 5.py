N = int(input())

for i in range(1, N + 1):
    tmp = ''
    for j in range(N - i):
        tmp += ' '
    for _ in range(2 * i - 1):
        tmp += '*'
    print(tmp)