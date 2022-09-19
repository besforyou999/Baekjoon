import sys
input = sys.stdin.readline

N, K = map(int, input().split())
temp = list(map(int, input().split()))

prefix = [0] * N

prefix[0] = temp[0]

for i in range(1, N):
    prefix[i] = prefix[i-1] + temp[i]


ans = -sys.maxsize

tmp = prefix[K - 1]
ans = max(ans, tmp)

for lp in range(N - K):
    tmp = prefix[lp + K] - prefix[lp]
    ans = max(ans, tmp)

print(ans)

