import sys
input = sys.stdin.readline

N = int(input())
times = []
for _ in range(N):
    start, end = map(int, input().split())
    times.append((start, end))

times.sort(key=lambda e: (e[1], e[0]))

cnt = 1
end_time = times[0][1]

for i in range(1, N):
    if end_time <= times[i][0]:
        cnt += 1
        end_time = times[i][1]

print(cnt)