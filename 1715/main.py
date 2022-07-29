import sys
from sys import stdin
import heapq

n = int(stdin.readline())

heap = []

for _ in range(n):
    val = int(stdin.readline())
    heapq.heappush(heap, val)

ans = 0

if n == 1:
    print(0)
    sys.exit(0)

while True:
    val1 = heapq.heappop(heap)
    val2 = heapq.heappop(heap)
    ans += val1 + val2
    heapq.heappush(heap, val1 + val2)
    if len(heap) == 1:
        break

print(ans)
