N = int(input())

for i in range(1, N):
    for j in range(1, N - i + 1):
        print(' ', end='')
    for j in range(2 * i - 1):
        print('*', end='')
    print()

for _ in range(2 * N - 1):
    print('*', end='')
print()

for i in range(1, N):
    for j in range(i):
        print(' ', end='')
    for j in range(2 * N - 2 * i - 1):
        print('*', end='')
    print()