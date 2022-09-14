import sys
input = sys.stdin.readline

N, C = map(int, input().split())
xi = []
for _ in range(N):
    val = int(input())
    xi.append(val)

xi.sort()


def bsearch(array, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = array[0]
        count = 1

        for i in range(1, len(array)):
            if array[i] >= current + mid:
                count += 1
                current = array[i]

        if count >= C:
            global answer
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1   # 최소 거리
end = xi[-1] - xi[0] # 최대 거리
answer = 0

bsearch(xi, start, end)
print(answer)

