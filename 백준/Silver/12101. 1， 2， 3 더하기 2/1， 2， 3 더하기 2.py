n, k = map(int, input().split())

# 1 <= n <= 11
# 1 <= k <= 2^31 - 1

arr = []


def rec(line):
    string = line
    value = eval(line)
    if value == n:
        arr.append(line)
        return
    elif value > n:
        return

    for i in range(1, 4):
        next_str = string + '+' + str(i)
        rec(next_str)


rec('1')
rec('2')
rec('3')
arr.sort()

# print(*arr)

if len(arr) >= k:
    print(arr[k-1])
else:
    print(-1)