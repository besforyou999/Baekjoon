import heapq


def solution(jobs):
    answer = 0
    N = len(jobs)
    queue = []
    current_job = []

    job = [[] for _ in range(1001)]

    for req, cost in jobs:
        job[req].append(cost)
        job[req].sort()

    time = 0
    finish = 0

    while finish < N:
        if time < 1001:
            for cost in job[time]:
                heapq.heappush(queue, [cost, time, 0])

        if len(current_job) == 0 and queue:
            current_job = heapq.heappop(queue)

        if len(current_job) > 0:
            current_job[2] += 1
            if current_job[0] == current_job[2]:
                answer += time - current_job[1] + 1
                current_job = []
                finish += 1

        time += 1

    return int(answer // len(jobs))