def get_depth(n):
    cnt = 0

    while n > 1:
        n //= 2
        cnt += 1
    return cnt


def solution(n, a, b):

    depth = get_depth(n)

    if a > b:
        tmp = a
        a = b
        b = tmp

    left = 1
    right = n
    ans = 0

    for d in range(depth):
        mid = (left + right) // 2
        if a <= mid and b <= mid:
            right = mid
        elif a > mid and b > mid:
            left = mid + 1
        else:
            ans = d
            break

    return depth - ans


print(solution(8, 4, 7))
