import sys
input = sys.stdin.readline


def calc(line):
    sum = 0
    dup = 0
    for ch in line:
        if ch == "X":
            dup = 0
        else:
            dup += 1
            sum += dup

    return sum


N = int(input())
for _ in range(N):
    line = input().rstrip()
    tmp = calc(line)
    print(tmp)
