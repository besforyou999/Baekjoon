import sys
input = sys.stdin.readline
n = int(input())
poll = list(map(int, input().split()))
arr = [-1]

for num in poll:
    if arr[-1] < num:
        arr.append(num)
    else:
        lp = 0
        rp = len(arr) - 1
        while lp < rp:
            mid = int((lp + rp) / 2)
            if arr[mid] >= num:
                rp = mid
            else:
                lp = mid + 1

        arr[rp] = num

print(n - len(arr) + 1)

