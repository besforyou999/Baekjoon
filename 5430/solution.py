import sys
input = sys.stdin.readline

T = int(input())

def oper(cmd, n , numbers):
    state = 0   # 0 -> left, 1 -> right
    lp = 0
    rp = len(numbers)
    countD = 0
    countR = 0

    for ch in cmd:
        if ch == 'R':
            state += 1
            if state == 2: state = 0
            countR += 1
        elif ch == 'D':
            countD += 1
            if countD > n:
                return -1, countR
            if state == 0:
                lp += 1
            else:
                rp -= 1
    result = numbers[lp: rp]
    return result, countR


def flip(numbers):
    size = len(numbers)
    answer = [0] * size
    for i in range(size):
        answer[i] = numbers[size - 1 - i]
    return answer


def buildAnswer(numbers):
    answer = "[" + ','.join(numbers) + "]"
    return answer


for _ in range(T):
    cmd = input().rstrip()
    n = int(input())
    arr = input().rstrip()
    numbers = list(arr[1:-1].split(','))
    op, R = oper(cmd, n , numbers)
    if op == -1:
        print("error")
        continue
    if R % 2 == 1:
        op = flip(op)

    print(buildAnswer(op))

