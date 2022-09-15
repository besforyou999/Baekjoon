import sys
input = sys.stdin.readline

N = int(input())
liq = sorted(list(map(int, input().split())))
lp = 0
rp = len(liq) - 1

ans = sys.maxsize
left = 0
right = 0

while lp < rp:
    sub = liq[lp] + liq[rp]
    if ans > abs(sub):
        ans = abs(sub)
        left = lp
        right = rp
    if sub < 0:
        lp += 1
    elif sub > 0:
        rp -= 1
    else:
        print(liq[lp], liq[rp])
        sys.exit(0)

print(liq[left], liq[right])

