from collections import deque

N, K = map(int, input().split())
belt = deque(list(map(int, input().split())))
robot = deque([0] * N)


def step1():
    belt.rotate(1)
    robot.rotate(1)
    robot[-1] = 0


def step2():
    if sum(robot):
        for i in range(N - 2, -1, -1):
            if robot[i] == 1 and robot[i+1] == 0 and belt[i+1] >= 1:
                robot[i + 1] = 1
                robot[i] = 0
                belt[i + 1] -= 1
        robot[-1] = 0


def step3():
    if robot[0] == 0 and belt[0] >= 1:
        robot[0] = 1
        belt[0] -= 1


def step4():
    return belt.count(0) >= K


ans = 1

while True:
    step1()
    step2()
    step3()
    if step4():
        break
    ans += 1

print(ans)