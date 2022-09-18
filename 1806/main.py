import sys
input = sys.stdin.readline

N, S = map(int, input().split())
Ai = list(map(int, input().split()))

INF = sys.maxsize
low = high = 0
Ai.append(0)
result = INF
total = Ai[0]

while low <= high < N:
    if total < S:
        high += 1
        total += Ai[high]
    elif total > S:
        result = min(result, high - low + 1)
        total -= Ai[low]
        low += 1
    else:
        result = min(result, high - low + 1)
        high += 1
        total += Ai[high]

if result == INF:
    print(0)
else:
    print(result)

