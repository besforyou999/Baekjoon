import sys
input = sys.stdin.readline

T = int(input())

def isVPS(line):
    stack = []
    for ch in line:
        if ch == '(':
            stack.append(ch)
        elif ch == ')':
            if len(stack) == 0:
                return False
            peek = stack[-1]
            if peek == '(':
                stack.pop()

    if len(stack) == 0:
        return True

    return False


for _ in range(T):
    line = input()
    result = isVPS(line)
    if result:
        print("YES")
    else:
        print("NO")

