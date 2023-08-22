import sys

N, K = map(int, input().split())

numbers = [i for i in range(N + 1)]

cnt = 0

for i in range(2, N+1):
    if numbers[i] != -1:
        for j in range(i, N + 1, i):
            if numbers[j] != -1:
                numbers[j] = -1
                cnt += 1
                if cnt == K:
                    print(j)
                    sys.exit(0)