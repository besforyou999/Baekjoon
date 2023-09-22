import sys
input = sys.stdin.readline

g, S = map(int, input().split())
W = input().strip()
line = input().strip()


alphas = {}
for a in W:
    if a in alphas:
        alphas[a] += 1
    else:
        alphas[a] = 1

queue = {}
for i in range(g):
    a = line[i]
    if a in queue:
        queue[a] += 1
    else:
        queue[a] = 1

answer = 0

for i in range(S - g):
    # 다 같은지 체크
    same = True
    for ele in queue:
        if ele not in alphas:
            same = False
        else:
            if alphas[ele] != queue[ele]:
                same = False

        if not same:
            break

    if same:
        answer += 1

    remove = line[i]
    new_ch = line[i+g]

    queue[remove] -= 1
    if queue[remove] == 0:
        del queue[remove]

    if new_ch in queue:
        queue[new_ch] += 1
    else:
        queue[new_ch] = 1


same = True
for ele in queue:
    if ele not in alphas:
        same = False
    else:
        if alphas[ele] != queue[ele]:
            same = False

    if not same:
        break

if same:
    answer += 1



print(answer)