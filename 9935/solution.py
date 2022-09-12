import sys
input = sys.stdin.readline

src = input().rstrip()
bomb = input().rstrip()

lastCh = bomb[-1]
stack = []
length = len(bomb)

for ch in src:
    stack.append(ch)
    if ch == lastCh and ''.join(stack[-length:]) == bomb:
        del stack[-length:]

answer = ''.join(stack)

if answer == '':
    print("FRULA")
else:
    print(answer)


