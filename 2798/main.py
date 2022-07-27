n, m = map(int, input().split(' '))
cards = list(map(int, input().split(' ')))


def calc_diff(a, b, c):
    sum = a + b + c
    if m < sum:
        return -1
    return sum


ans = -1


for i in range(n):
    for j in range(i + 1, n):
        for k in range(j + 1, n):
            a = cards[i]
            b = cards[j]
            c = cards[k]
            diff = calc_diff(a, b, c)
            if diff == -1:
                continue
            if diff > ans:
                ans = diff

print(ans)


