from sys import stdin
import heapq

heap = []

n = int(stdin.readline())
ans = ""

for _ in range(n):
    num = int(stdin.readline())
    if num > 0:
        heapq.heappush(heap, num)
    elif num == 0:
        if heap:
            ans += str(heapq.heappop(heap)) + "\n"
        else:
            ans += "0\n"

print(ans)