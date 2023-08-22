import heapq, sys

heap = []
N = int(input())

for _ in range(N):
    val = int(sys.stdin.readline())
    if val == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, val)