import heapq
import sys
input = sys.stdin.readline

q = []

N = int(input())

for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(q, x)
    else:
        if len(q) > 0:
            print(heapq.heappop(q))
        else:
            print(0)
