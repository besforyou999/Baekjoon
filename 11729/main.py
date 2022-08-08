import sys
input = sys.stdin.readline

answer = ""

n = int(input())

print(pow(2, n) - 1)


def Han(n, start, mid, to):
    if n == 1:
        print(str(start) + " " + str(to))
        return

    Han(n - 1, start, to, mid)
    print(str(start) + " " + str(to))
    Han(n - 1, mid, start, to)


Han(n, 1, 2, 3)


