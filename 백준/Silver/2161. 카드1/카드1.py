import sys
from collections import deque
input = sys.stdin.readline

N = int(input())

queue = deque([i for i in range(1, N + 1)])

while len(queue) > 1:
    front = queue.popleft()
    print(front, end=' ')
    second = queue.popleft()
    queue.append(second)

print(queue[0])