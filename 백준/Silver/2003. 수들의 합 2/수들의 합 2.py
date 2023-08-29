N, M = map(int, input().split())
arr = list(map(int, input().split()))

left, right = 0, 1
cnt = 0

while right <= N and left <= N:

    nums = arr[left:right]
    tmp = sum(nums)
    if tmp < M:
        right += 1
    elif tmp > M:
        left += 1
    else:
        right += 1
        cnt += 1

print(cnt)