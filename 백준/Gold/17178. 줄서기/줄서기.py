import sys
from collections import deque

N = int(input())
line = deque()
for _ in range(N):
    tmp = list(input().split())
    for ticket in tmp:
        alpha, number = ticket.split('-')
        line.append((alpha, int(number)))

correct_order = sorted(line)
entered = 0

stack = []

while entered < N * 5:
    found = False
    current_order = correct_order[entered]
    # 줄과 대기열 맨 위에서 현재 순서 티켓 찾기

    # 대기열 맨 위
    if stack and stack[-1] == current_order:
        stack.pop()
        entered += 1
        continue

    # 대기열 맨 위에 없으므로 줄에서 찾기
    while line:
        if line[0] == current_order: # 줄 맨 앞에서 찾음
            line.popleft()
            entered += 1
            found = True
            break
        else:
            stack.append(line.popleft()) # 줄 맨 앞에서 없으면 대기열에 추가

    if not found:
        print("BAD")
        sys.exit(0)

print("GOOD")