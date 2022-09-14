import sys
input = sys.stdin.readline


def I_Block(mat):
    answer = -1
    # 수직 막대기
    for row in range(N - 3):
        for col in range(M):
            val = mat[row][col] + mat[row + 1][col] + mat[row + 2][col] + mat[row + 3][col]
            answer = max(answer, val)

    # 가로 막대기
    for row in range(N):
        for col in range(M - 3):
            val = mat[row][col] + mat[row][col + 1] + mat[row][col + 2] + mat[row][col + 3]
            answer = max(answer, val)

    return answer


def Square_Block(mat):
    answer = -1
    for row in range(N - 1):
        for col in range(M - 1):
            val = mat[row][col] + mat[row + 1][col] + mat[row][col + 1] + mat[row + 1][col + 1]
            answer = max(answer, val)
    return answer


def L_Block(mat):
    answer = -1

    for row in range(N - 2):
        for col in range(M - 1):
            val = mat[row][col] + mat[row + 1][col] + mat[row + 2][col] + mat[row + 2][col + 1]
            answer = max(answer, val)

            val = mat[row][col] + mat[row][col + 1] + mat[row + 1][col + 1] + mat[row + 2][col + 1]
            answer = max(answer, val)

            val = mat[row + 2][col] + mat[row][col + 1] + mat[row + 1][col + 1] + mat[row + 2][col + 1]
            answer = max(answer, val)

            val = mat[row][col] + mat[row][col + 1] + mat[row + 1][col] + mat[row + 2][col]
            answer = max(answer, val)

    for row in range(N - 1):
        for col in range(M - 2):
            val = mat[row][col] + mat[row + 1][col] + mat[row][col + 1] + mat[row][col + 2]
            answer = max(answer, val)

            val = mat[row + 1][col] + mat[row + 1][col + 1] + mat[row + 1][col + 2] + mat[row][col + 2]
            answer = max(answer, val)

            val = mat[row][col] + mat[row][col + 1] + mat[row][col + 2] + mat[row + 1][col + 2]
            answer = max(answer, val)

            val = mat[row][col] + mat[row + 1][col] + mat[row + 1][col + 1] + mat[row + 1][col + 2]
            answer = max(answer, val)

    return answer


def z_block(mat):
    answer = -1

    for row in range(N - 2):
        for col in range(M - 1):
            val = mat[row][col] + mat[row + 1][col] + mat[row + 1][col + 1] + mat[row + 2][col + 1]
            answer = max(answer, val)

            val = mat[row][col + 1] + mat[row + 1][col + 1] + mat[row + 1][col] + mat[row + 2][col]
            answer = max(answer, val)

    for row in range(N - 1):
        for col in range(M - 2):
            val = mat[row + 1][col] + mat[row + 1][col + 1] + mat[row][col + 1] + mat[row][col + 2]
            answer = max(answer, val)

            val = mat[row][col] + mat[row][col + 1] + mat[row + 1][col + 1] + mat[row + 1][col + 2]
            answer = max(answer, val)

    return answer


def t_block(mat):
    answer = -1
    # down
    for row in range(N - 1):
        for col in range(M - 2):
            val = mat[row][col] + mat[row][col + 1] + mat[row + 1][col + 1] + mat[row][col + 2]
            answer = max(answer, val)

            val = mat[row][col + 1] + mat[row + 1][col] + mat[row + 1][col + 1] + mat[row + 1][col + 2]
            answer = max(answer, val)

    for row in range(N - 2):
        for col in range(M - 1):
            val = mat[row][col] + mat[row + 1][col] + mat[row + 2][col] + mat[row + 1][col + 1]
            answer = max(answer, val)

            val = mat[row + 1][col] + mat[row][col + 1] + mat[row + 1][col + 1] + mat[row + 2][col + 1]
            answer = max(answer, val)

    return answer


N, M = map(int, input().split())
graph = [[0 for _ in range(M)] for _ in range(N)]

for row in range(N):
    line = list(map(int, input().split()))
    for col in range(M):
        graph[row][col] = line[col]

answers = []

answers.append(I_Block(graph))
answers.append(Square_Block(graph))
answers.append(L_Block(graph))
answers.append(z_block(graph))
answers.append(t_block(graph))

print(max(answers))

