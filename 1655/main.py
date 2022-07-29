from sys import stdin
import heapq

max_heap = []
min_heap = []

n = int(stdin.readline())
ans = ""

for idx in range(n):
    number = int(stdin.readline())
    if len(max_heap) > len(min_heap):
        heapq.heappush(min_heap, (number, number))
    elif len(max_heap) == len(min_heap):
        heapq.heappush(max_heap, (-number, number))

    if max_heap and min_heap and max_heap[0][1] > min_heap[0][0]:
        max_value = heapq.heappop(max_heap)[1]
        min_value = heapq.heappop(min_heap)[0]
        heapq.heappush(max_heap, (-min_value, min_value))
        heapq.heappush(min_heap, (max_value, max_value))

    ans += str(max_heap[0][1]) + "\n"

print(ans)
