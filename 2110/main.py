from sys import stdin

n, c = map(int, stdin.readline().rstrip().split())

array = []
for _ in range(n):
    val = int(stdin.readline().rstrip())
    array.append(val)

array.sort()


def bsearch(array, start, end):
    while start <= end:
        mid = (start + end) // 2
        current = array[0]
        count = 1

        for i in range(1, len(array)):
            if array[i] >= current + mid:
                count += 1
                current = array[i]

        if count >= c:
            global answer
            start = mid + 1
            answer = mid
        else:
            end = mid - 1


start = 1
end = array[-1] - array[0]
answer = 0

bsearch(array, start, end)
print(answer)
