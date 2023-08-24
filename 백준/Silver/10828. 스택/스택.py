from sys import stdin

n = int(stdin.readline())

stack = []

answer = ""

for _ in range(n):
    line = stdin.readline().split()
    cmd = line[0]
    if cmd == "top":
        if len(stack) == 0:
            answer += "-1\n"
        elif len(stack) > 0:
            answer += (str(stack[-1]) + "\n")
    elif cmd == "size":
        answer += (str(len(stack)) + "\n")
    elif cmd == "empty":
        if len(stack) == 0:
            answer += "1\n"
        elif len(stack) > 0:
            answer += "0\n"
    elif cmd == "pop":
        if len(stack) == 0:
            answer += "-1\n"
        elif len(stack) > 0:
            answer += (str(stack.pop()) + "\n")
    elif cmd == "push":
        val = int(line[1])
        stack.append(val)

print(answer)