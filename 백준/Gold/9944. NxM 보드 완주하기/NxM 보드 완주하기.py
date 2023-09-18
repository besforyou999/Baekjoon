import sys
sys.setrecursionlimit(10**7)
answer = float('inf') # 최소 횟수를 찾기 위해 초깃값을 inf로 지정
case = 1  # 테스트케이스

d = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1]
]


def check():
    for i in range(N):
        for j in range(M):
            if board[i][j] == ".":
                return False
    return True

# 백트래킹.
# 프루닝 조건은 현재 answer보다 탐색중인 횟수 cnt가 작을 경우만 다음 번 경로 탐색
# 2차원 배열인 board를 deepcopy하여 매개변수로 전달하지 않기 위해 이번 탐색에서 지나간 좌표들을 저장하고 탐색이 끝난 후 다시 "."로 초기화해주는 방법을 사용
def bt(x, y, cnt):
    global answer
    if check(): # 모든 좌표를 탐색한 경우
        answer = min(answer, cnt) # answer를 최솟값으로 갱신
    if cnt < answer: # 현재까지 탐색한 경로의 수가 answer보다 작을 경우만 탐색
        for i in range(4): # 4방향 탐색
            tmp = []
            ax = x
            ay = y
            while True:
                ax += d[i][0]
                ay += d[i][1]
                if 0 <= ax < N and 0 <= ay < M and board[ax][ay] == ".": # 구슬을 놓을 수 있는 공간이라면 다음 좌표 탐색
                    tmp.append([ax, ay])
                    board[ax][ay] = "*"
                else:
                    break
            if tmp: bt(ax-d[i][0], ay-d[i][1], cnt + 1) # tmp가 비어있지 않다는 것은 탐색을 진행했다는 것이므로 다음 경로의 탐색도 진행하여야 함.
            for a,b in tmp:
                board[a][b] = "."
        board[x][y] = "."


while True:
    try :
        N, M = map(int, input().split())
        board = [list(input().strip()) for _ in range(N)]
        answer = float("inf")
        for i in range(N):
            for j in range(N):
                if board[i][j] == ".":
                    board[i][j] = "*"
                    bt(i, j, 0)
        if answer == float("inf"):
            answer = -1
        print("Case {}: {}".format(case,answer))
        case += 1
    except :
        break