import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int, input().split()))

answer = [0]

for number in array:
    if answer[-1] < number:
        answer.append(number)
    else:
        lp = 0
        rp = len(answer)
        while lp < rp:
            mid = (lp + rp) // 2
            if array[mid] < number:
                lp = mid + 1
            else:
                rp = mid
        answer[rp] = number


print(len(answer) - 1)

