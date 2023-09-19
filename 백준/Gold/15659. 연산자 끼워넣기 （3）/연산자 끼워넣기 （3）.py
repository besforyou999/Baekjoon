N = int(input())
A = list(map(int, input().split()))
plus, minus, multi, div = map(int, input().split())
max_ans = int(-1e11)
min_ans = int(1e11)


def rec(string, p, m1, m2, d, cnt):
    if cnt == N:
        global max_ans, min_ans
        result = eval(string)
        max_ans = max(max_ans, result)
        min_ans = min(min_ans, result)
        return

    if p > 0:
        rec(string + '+' + str(A[cnt]), p - 1, m1, m2, d, cnt + 1)
    if m1 > 0:
        rec(string + '-' + str(A[cnt]), p, m1 - 1, m2, d, cnt + 1)
    if m2 > 0:
        rec(string + '*' + str(A[cnt]), p, m1, m2 - 1, d, cnt + 1)
    if d > 0:
        rec(string + '//' + str(A[cnt]), p, m1, m2, d - 1, cnt + 1)


rec(str(A[0]), plus, minus, multi, div, 1)

print(max_ans)
print(min_ans)