N, M = map(int, input().split())

packs = []
singles = []
for _ in range(M):
    pack, one = map(int, input().split())
    packs.append(pack)
    singles.append(one)

pack_needed = (N // 6) + 1

packs.sort()
singles.sort()

blobs = []
for i in range(M):
    blobs.append(packs[i])
    blobs.append(singles[i] * 6)

blobs.sort()

ans = 1000000000

# 팩 할 수 있는 만큼 + 낱개 할 수 있는 만큼

# 전부 다 팩
ans = min(ans, pack_needed * packs[0])

# 전부 다 낱개
ans = min(ans, N * singles[0])

# 팩 1개, 낱개 * 6 가격 중 가장 작은걸 찾는다.

tmp = 0

for _ in range(N // 6):
    tmp += blobs[0]

remain = N % 6

if remain == 0:
    ans = min(ans, tmp)
else:
    p = packs[0]
    s = singles[0] * remain
    if p >= s:
        ans = min(ans, tmp + s)
    else:
        ans = min(ans, tmp + p)

print(ans)