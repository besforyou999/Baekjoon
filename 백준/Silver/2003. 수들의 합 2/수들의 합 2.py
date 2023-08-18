import sys
input = sys.stdin.readline

N, M = map(int, input().split())
Ai = list(map(int, input().split()))

if N == 1:
    if Ai[0] == M:
        print(1)
    else:
        print(0)
    sys.exit(0)

lp = 0
rp = lp + 1
count = 0
while lp < N:
    tmp = Ai[lp]
    while rp < N:
        if tmp < M:
            tmp += Ai[rp]
            rp += 1
        elif tmp >= M:
            break
    if tmp == M:
        count += 1
    lp += 1
    rp = lp + 1

print(count)
