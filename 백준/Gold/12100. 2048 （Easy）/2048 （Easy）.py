import copy

N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]


def moveUp(graph):
    for c in range(N):
        queue1 = []
        queue2 = []
        for r in range(N):
            num = graph[r][c]
            if num == 0:
                continue
            graph[r][c] = 0
            queue1.append(num)
            if len(queue1) >= 2:
                if queue1[0] == queue1[1]:
                    queue2.append(queue1[0] * 2)
                    queue1.clear()
                else:
                    queue2.append(queue1[0])
                    queue1.pop(0)

        for num in queue1:
            queue2.append(num)

        for i in range(len(queue2)):
            graph[i][c] = queue2[i]


def moveRight(graph):
    for r in range(N):
        queue1 = []
        queue2 = []
        for c in reversed(range(N)):
            num = graph[r][c]
            if num == 0:
                continue
            graph[r][c] = 0
            queue1.append(num)
            if len(queue1) >= 2:
                if queue1[0] == queue1[1]:
                    queue2.append(queue1[0] * 2)
                    queue1.clear()
                else:
                    queue2.append(queue1[0])
                    queue1.pop(0)

        for num in queue1:
            queue2.append(num)

        for c in range(len(queue2)):
            graph[r][N - c - 1] = queue2[c]


def moveDown(graph):
    for c in range(N):
        queue1 = []
        queue2 = []
        for r in reversed(range(N)):
            num = graph[r][c]
            if num == 0:
                continue
            graph[r][c] = 0
            queue1.append(num)
            if len(queue1) >= 2:
                if queue1[0] == queue1[1]:
                    queue2.append(queue1[0] * 2)
                    queue1.clear()
                else:
                    queue2.append(queue1[0])
                    queue1.pop(0)

        for num in queue1:
            queue2.append(num)

        for r in range(len(queue2)):
            graph[N - r - 1][c] = queue2[r]


def moveLeft(graph):
    for r in range(N):
        queue1 = []
        queue2 = []
        for c in range(N):
            num = graph[r][c]
            if num == 0:
                continue
            graph[r][c] = 0
            queue1.append(num)
            if len(queue1) >= 2:
                if queue1[0] == queue1[1]:
                    queue2.append(queue1[0] * 2)
                    queue1.clear()
                else:
                    queue2.append(queue1[0])
                    queue1.pop(0)

        for num in queue1:
            queue2.append(num)

        for c in range(len(queue2)):
            graph[r][c] = queue2[c]


def rec(depth, graph):
    if depth == 5:
        global ans
        for r in range(N):
            for c in range(N):
                ans = max(ans, graph[r][c])
        return

    for i in range(4):
        new_graph = copy.deepcopy(graph)
        if i == 0:
            moveUp(new_graph)
        elif i == 1:
            moveRight(new_graph)
        elif i == 2:
            moveDown(new_graph)
        else:
            moveLeft(new_graph)
        rec(depth + 1, new_graph)


ans = -1
rec(0, board)
print(ans)