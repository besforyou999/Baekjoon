from collections import deque

T = int(input())

wheels = ['empty']

for _ in range(T):
    wheels.append(deque(list(map(int, input().rstrip()))))


def spinWheels(start, spin_dir):

    queue = [(start, spin_dir)]

    left = start - 1
    prev = start
    spin_direction = spin_dir

    while left >= 1:
        if wheels[left][2] != wheels[prev][6]: # 극이 서로 다르다면
            queue.append((left, spin_direction * -1))
            spin_direction *= -1
            prev = left
            left -= 1
        else:
            break

    right = start + 1
    prev = start
    spin_direction = spin_dir

    while right <= T:
        if wheels[prev][2] != wheels[right][6]: # 극이 서로 다르다면
            queue.append((right, spin_direction * -1))
            spin_direction *= -1
            prev = right
            right += 1
        else:
            break

    # spin이 양수면 오른쪽 rotate, 음수면 왼쪽 rotate
    for idx, spinD in queue:
        wheels[idx].rotate(spinD)


K = int(input())

for _ in range(K):
    num, spin = map(int, input().split())
    spinWheels(num, spin)

cnt = 0

for wheel in wheels:
    if wheel[0] == 1:
        cnt += 1

print(cnt)