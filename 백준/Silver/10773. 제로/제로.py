import sys
input = sys.stdin.readline

K = int(input())

stack = []

for _ in range(K):
    val = int(input())
    if val == 0:
        stack.pop()
    else:
        stack.append(val)

sum = 0

for num in stack:
    sum += int(num)

print(sum)