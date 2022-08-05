from sys import stdin

n = int(stdin.readline().rstrip())
A = list(map(int, stdin.readline().rstrip().split()))
m = int(stdin.readline().rstrip())
X = list(map(int, stdin.readline().rstrip().split()))

A.sort()

def search_x_in_array(target):
    lp = 0
    rp = n - 1
    while lp <= rp:
        mid = int( (lp + rp) / 2)
        if A[mid] < target:
            lp = mid + 1
        elif A[mid] > target:
            rp = mid - 1
        else:
            return 1
    return 0

ans = ""

for x in X:
    ans += (str(search_x_in_array(x)) + "\n")

print(ans)

