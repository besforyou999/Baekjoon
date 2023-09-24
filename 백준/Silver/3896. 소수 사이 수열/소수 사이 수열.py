import sys

input = sys.stdin.readline
MAX = 1300000
T = int(input())


def build_prime():
    MAX = 1300000
    isprime = [True] * MAX
    isprime[0] = isprime[1] = False

    M = int(MAX ** 0.5)
    for i in range(2, M + 1):
        if isprime[i]:
            for j in range(i + i, MAX, i):
                isprime[j] = False

    return isprime


primes = build_prime()

for _ in range(T):
    k = int(input())
    if primes[k]:
        print(0)
    else:
        rp = k
        while rp < MAX:
            rp += 1
            if primes[rp]:
                break
        lp = k
        while lp >= 2:
            lp -= 1
            if primes[lp]:
                break

        print(rp - lp)