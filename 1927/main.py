from sys import stdin
from queue import PriorityQueue

queue = PriorityQueue()

n = int(stdin.readline())

ans = ""

for _ in range(n):
    x = int(stdin.readline())
    if x == 0:
        if queue.empty() is False:
            ans += (str(queue.get()) + "\n")
        else:
            ans += '0\n'
    elif x > 0:
        queue.put(x)

print(ans)
