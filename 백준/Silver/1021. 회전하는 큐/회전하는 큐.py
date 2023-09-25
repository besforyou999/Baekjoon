import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split())
number_to_find = list(map(int, input().split()))

queue = deque()
for i in range(1, N + 1):
    queue.append(i)

cnt = 0

for number in number_to_find:
    size = len(queue)
    idx = 0
    for i in range(size):
        if number == queue[i]:
            idx = i
            break

    op2 = idx
    op3 = size - idx

    if op2 <= op3:
        cnt += op2
        for _ in range(op2):
            queue.rotate(-1)
    else:
        cnt += op3
        for _ in range(op3):
            queue.rotate(1)

    queue.popleft()

print(cnt)