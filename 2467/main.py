import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int, input().split()))

left = 0
right = N - 1
_sum = sys.maxsize

answerL = left
answerR = right
prevVal = abs(_sum)

while left < right:
    _sum = array[left] + array[right]

    if abs(_sum) < prevVal:
        answerL = left
        answerR = right
        prevVal = abs(_sum)

    if _sum < 0:
        left += 1
    elif _sum > 0:
        right -= 1
    else:
        break

print(array[answerL], array[answerR])
