from sys import stdin

T = int(stdin.readline())

answer = ""

for _ in range(T):
    stack = []
    line = stdin.readline().split()[0]

    for ch in line:
        if ch == "(":
            stack.append(ch)
        elif ch == ")":
            if len(stack) == 0:
                stack.append(ch)
            else:
                peek = stack[-1]
                if peek == ")":
                    stack.append(ch)
                elif peek == "(":
                    stack.pop()

    if len(stack) == 0:
        answer += "YES\n"
    else:
        answer += "NO\n"

print(answer)
