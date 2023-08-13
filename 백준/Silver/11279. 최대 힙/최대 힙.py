import heapq
import sys
input = sys.stdin.readline

q = []

N = int(input())
answer = ""
for _ in range(N):
    x = int(input())
    if x != 0:
        heapq.heappush(q, -x)
    else:
        if len(q) > 0:
            answer += str(-1 * heapq.heappop(q)) + "\n"
        else:
            answer += "0\n"

print(answer)