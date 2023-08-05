import sys
import heapq
input = sys.stdin.readline

q = []

N = int(input())

for _ in range(N):
    card = int(input())
    heapq.heappush(q, card)

sum = 0

while len(q) > 1:
    top = heapq.heappop(q)
    sec = heapq.heappop(q)
    sum += top + sec
    heapq.heappush(q, top + sec)

print(sum)
