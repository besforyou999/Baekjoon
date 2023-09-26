import sys
input = sys.stdin.readline

N, M = map(int, input().split())
pos = list(map(int, input().split()))

plus = []
minus = []

most_far_pos = -1
in_plus = True

for p in pos:
    if p > 0:
        plus.append(p)
    else:
        minus.append(p)

    if abs(most_far_pos) < abs(p):
        most_far_pos = p
        if p > 0:
            in_plus = True
        else:
            in_plus = False

plus.sort(key=lambda a: -int(abs(a)))
minus.sort(key=lambda a: -int(abs(a)))

# print(*plus)
# print(*minus)

steps = 0

# 가장 먼 거리는 한 번만 가고 0으로 안 돌아와야 함
if in_plus:
    steps += plus[0]
    for _ in range(M):
        if plus:
            plus.pop(0)
else:
    steps += int(abs(minus[0]))
    for _ in range(M):
        if minus:
            minus.pop(0)

while plus:
    steps += plus[0] * 2
    for _ in range(M):
        if plus:
            plus.pop(0)

while minus:
    steps += int(abs(minus[0])) * 2
    for _ in range(M):
        if minus:
            minus.pop(0)

print(steps)