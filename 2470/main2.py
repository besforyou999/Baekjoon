import sys
input = sys.stdin.readline

N = int(input())
liquid = sorted(list(map(int, input().rstrip().split())))

lp = 0
rp = N - 1
S = liquid[lp] + liquid[rp]
recL = lp
recR = rp
while lp < rp:
    mix = liquid[lp] + liquid[rp]
    if abs(S) > abs(mix):
        recL = lp
        recR = rp
        S = mix

    if mix < 0:
        lp += 1
    elif mix == 0:
        print(liquid[lp], liquid[rp])
        sys.exit(0)
    else:
        rp -= 1

print(liquid[recL], liquid[recR])

