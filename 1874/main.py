from sys import stdin
from collections import deque
n = int(stdin.readline())

perm = deque()

for _ in range(n):
    val = int(stdin.readline().split()[0])
    perm.append(val)

stack = []
answer = ""

for i in range(1, n+1):
    perm_first = perm[0]
    if perm_first != i:
        stack.append(i)
        answer += "+\n"
    elif perm_first == i:
        stack.append(i)
        answer += "+\n"
        while len(stack) > 0 and len(perm) > 0 and stack[-1] == perm[0]:
            stack.pop()
            perm.popleft()
            answer += "-\n"

if len(stack) == 0 and len(perm) == 0:
    print(answer)
else:
    print("NO")

