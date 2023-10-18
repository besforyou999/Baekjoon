def solution(m, n, matrix):
    answer = 0

    board = [[' '] * n for _ in range(m)]
    for r in range(m):
        line = matrix[r]
        for c in range(n):
            board[r][c] = line[c]

    while True:

        hasBlock = False
        blocks = [[False] * n for _ in range(m)]

        # 사라질 블록 기록
        for r in range(m - 1):
            for c in range(n - 1):
                if board[r][c] == ' ':
                    continue
                if board[r][c] == board[r][c + 1] == board[r + 1][c] == board[r + 1][c + 1]:
                    blocks[r][c] = blocks[r][c + 1] = blocks[r + 1][c] = blocks[r + 1][c + 1] = True
                    hasBlock = True

        if not hasBlock:
            break

        # 기록된 블록 모두 제거
        for r in range(m):
            for c in range(n):
                if blocks[r][c]:
                    board[r][c] = ' '
                    answer += 1

        # 블록 아래로 떨어짐
        new_board = [[' '] * n for _ in range(m)]

        for c in range(n):
            idx = m - 1
            for r in range(m - 1, -1, -1):
                if board[r][c] != ' ':
                    new_board[idx][c] = board[r][c]
                    idx -= 1

        # board 업데이트
        for r in range(m):
            for c in range(n):
                board[r][c] = new_board[r][c]

    return answer