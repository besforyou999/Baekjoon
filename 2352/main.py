import sys

input = sys.stdin.readline

N = int(input())
array = list(map(int, input().split()))

answer = [-10000000000]

for number in array:
    if answer[-1] < number:
        answer.append(number)
    else:
        lp = 0
        rp = len(answer) - 1
        while lp < rp:
            mid = int((lp + rp) / 2)
            if answer[mid] < number:
                lp = mid + 1
            else:
                rp = mid

        answer[rp] = number

print(len(answer) - 1)


