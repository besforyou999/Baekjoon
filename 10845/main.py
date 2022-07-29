from sys import stdin
from collections import deque

queue = deque()

n = int(stdin.readline())

answer = ""

for _ in range(n):
    line = stdin.readline().split()
    cmd = line[0]
    if cmd == 'push':
        val = line[1]
        queue.append(val)
    elif cmd == 'front':
        if len(queue) == 0:
            answer += "-1\n"
        else:
            answer += (queue[0] + "\n")
    elif cmd == 'back':
        if len(queue) == 0:
            answer += "-1\n"
        else:
            answer += (queue[-1] + "\n")
    elif cmd == 'pop':
        if len(queue) == 0:
            answer += "-1\n"
        else:
            answer += (queue.popleft() + "\n")
    elif cmd == 'size':
        answer += (str(len(queue)) + "\n")
    elif cmd == 'empty':
        if len(queue) == 0:
            answer += "1\n"
        else:
            answer += "0\n"

print(answer)
