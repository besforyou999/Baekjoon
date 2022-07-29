from sys import stdin
import heapq

heap = []

n = int(stdin.readline())

for _ in range(n):
    num = int(stdin.readline())
    if num == 0:
        if heap:
            print((-1)*heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, (-1)*num)

