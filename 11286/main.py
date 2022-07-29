from sys import stdin
import heapq

heap = []

n = int(stdin.readline())

ans = ""

for _ in range(n):
    x = int(stdin.readline())
    if x != 0:
        heapq.heappush(heap, (abs(x), x))
    elif x == 0:
        if len(heap) == 0:
            ans += "0\n"
        else:
            val = heapq.heappop(heap)
            ans += (str(val[1]) + "\n")

print(ans)
