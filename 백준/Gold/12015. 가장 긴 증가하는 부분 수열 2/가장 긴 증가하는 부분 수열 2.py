import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

seq = [-1]

for a in arr:
    if seq[-1] < a:
        seq.append(a)
    else:
        left = 0
        right = len(seq) - 1

        while left < right:
            mid = (left + right) // 2
            if seq[mid] >= a:
                right = mid
            else:
                left = mid + 1

        seq[left] = a

print(len(seq) - 1)