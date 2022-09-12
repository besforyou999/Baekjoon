import sys
input = sys.stdin.readline

t = int(input())


def isPalin(line):
    lp = 0
    rp = len(line) - 1

    while lp < rp:
        if line[lp] == line[rp]:
            lp += 1
            rp -= 1
        else:
            if lp < rp - 1:
                new_line = line[:rp] + line[rp + 1:]
                if new_line[:] == new_line[::-1]:
                    return 1
            if lp + 1 < rp:
                new_line = line[:lp] + line[lp + 1:]
                if new_line[:] == new_line[::-1]:
                    return 1

            return 2

    return 0


for _ in range(t):
    line = input().rstrip()
    print(isPalin(line))

