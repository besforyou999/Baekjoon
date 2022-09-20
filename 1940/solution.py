import sys
input = sys.stdin.readline

N = int(input())
M = int(input())

numbers = sorted(list(map(int, input().split())))

lp = 0
rp = N - 1
count = 0
while lp < rp:
    tmp = numbers[lp] + numbers[rp]
    if tmp < M:
        lp += 1
    elif tmp > M:
        rp -= 1
    elif tmp == M:
        count += 1
        lp += 1

print(count)

