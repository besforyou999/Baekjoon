import sys
input = sys.stdin.readline

primes = [True] * (1000001)


def build_prime(n):

    limit = int(n ** 0.5)

    for i in range(2, limit + 1):
        if primes[i]:
            for j in range(i * i, n, i):
                primes[j] = False

    return [i for i in range(2, n + 1) if primes[i]]


prime_arr = build_prime(1000000)


while True:
    n = int(input())
    if n == 0:
        break
    found = False
    for i in range(len(prime_arr)):
        a = prime_arr[i]
        if primes[n - a]:
            found = True
            print(str(n) + ' = ' + str(a) + ' + ' + str(n - a))
            break

    if not found:
        print("Goldbach's conjecture is wrong.")