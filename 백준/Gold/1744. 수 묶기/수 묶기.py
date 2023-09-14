N = int(input())

arr = []

for _ in range(N):
    arr.append(int(input()))

minus = []
plus = []
zero = False

for num in arr:
    if num < 0:
        minus.append(num)
    elif num > 0:
        plus.append(num)
    else:
        zero = True

ans = 0

# 덧셈 처리
plus.sort()

# 1 이상 숫자들 모으기
over_one = [num for num in plus if num > 1]
ones = [num for num in plus if num == 1]

# 큰 순서대로 두개씩 곱해서 더하기
while len(over_one) > 1:
    one = over_one.pop()
    two = over_one.pop()
    ans += one * two

if over_one:
    ans += over_one[0]

# print(ans)

# 뺄셈 처리
minus.sort(reverse=True)

# print(minus)

# 절대값 큰 순서대로 두개씩 곱해서 더하기
while len(minus) > 1:
    one = minus.pop()
    two = minus.pop()
    ans += one * two

# 남은 -1과 0을 곱해서 최대값 구함
if zero:
    ans += sum(ones)
else:
    ans += sum(ones) + sum(minus)

print(ans)