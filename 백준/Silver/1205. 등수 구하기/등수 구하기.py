import sys
input = sys.stdin.readline

N, new_score, P = map(int, input().split())
if N == 0:
    print(1)
    sys.exit(0)

scores = list(map(int, input().split()))


idx = -1

for i in range(N):
    if scores[i] < new_score:
        scores.insert(i, new_score)
        idx = i

if idx == -1:
    scores.append(new_score)
    idx = len(scores) - 1


if idx >= P:
    print(-1)
    sys.exit(0)


ranks = [0] * (N+1)
ranks[0] = 1
cnt = 1
for i in range(1, N +1 ):
    if scores[i-1] > scores[i]:
        ranks[i] = ranks[i-1] + cnt
        cnt = 1
    elif scores[i-1] == scores[i]:
        cnt += 1
        ranks[i] = ranks[i-1]


print(ranks[idx])