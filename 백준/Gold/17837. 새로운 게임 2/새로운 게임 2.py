N, K = map(int, input().split())

dr = ['empty', 0, 0, -1, 1]
dc = ['empty', 1, -1, 0, 0]

stacks = [[[] for _ in range(N + 1)] for _ in range(N + 1)]

mat = []

for i in range(1, N + 1):
    line = list(map(int, input().split()))
    mat.append(line)

horses = ['empty']
for i in range(1, K + 1):
    row, col, direction = map(int, input().split())
    horses.append((row, col, direction))
    stacks[row][col].append(i)

turn = 1

while turn <= 1000:
    # print("turn %d " % turn)
    # print()
    more_than_four = False
    for k in range(1, K + 1):
        row, col, d = horses[k]

        nr = row + dr[d]
        nc = col + dc[d]

        # 체스판을 벗어나는 경우 혹은 다음칸이 파랑인 경우
        if 1 > nr or nr > N or 1 > nc or nc > N or mat[nr - 1][nc - 1] == 2:
            # 방향을 변경한다.
            if d == 1:
                d = 2
            elif d == 2:
                d = 1
            elif d == 3:
                d = 4
            else:
                d = 3

            nr = row + dr[d]
            nc = col + dc[d]
            horses[k] = row, col, d

        if 1 <= nr <= N and 1 <= nc <= N:
            if mat[nr - 1][nc - 1] == 0: # 흰색이라면
                stack = stacks[row][col]
                idx = stack.index(k)

                move_horse = stack[idx:] # 옮길 말과 그 위 말들
                stacks[row][col] = stack[:idx] # 원래 스택 조정

                for num in move_horse:
                    stacks[nr][nc].append(num)
                    horses[num] = (nr, nc, horses[num][2]) # horses 업데이트

            elif mat[nr - 1][nc - 1] == 1:
                stack = stacks[row][col]
                idx = stack.index(k)

                move_horse = stack[idx:]
                stacks[row][col] = stack[:idx]  # 원래 스택 조정

                for i in range(len(move_horse) - 1, -1, -1):
                    stacks[nr][nc].append(move_horse[i])      # 해당 말과 위에 있는 모든말을 역순으로 옮김

                for num in move_horse:
                    horses[num] = (nr, nc, horses[num][2])

            if len(stacks[nr][nc]) >= 4:
                more_than_four = True

        # for r in range(1, N + 1):
        #     for c in range(1, N + 1):
        #         print(stacks[r][c], end=' ')
        #     print()
        # print()
        #
        # print(horses)
        # print()

    if more_than_four:
        break

    turn += 1

if turn > 1000:
    print(-1)
else:
    print(turn)