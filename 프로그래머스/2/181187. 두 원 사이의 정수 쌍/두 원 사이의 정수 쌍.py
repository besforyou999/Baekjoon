from math import sqrt, floor, ceil


def solution(r1, r2):
    cnt = 0
    for x in range(1, r2 + 1):
        y_start = ceil(sqrt(r1 * r1 - x * x)) if r1 > x else 0
        y_end = floor(sqrt(r2 * r2 - x * x))
        cnt += y_end - y_start + 1

    return cnt * 4

