M, N = map(int, input().split())


def prime_list(n):
    sieve = [True] * n

    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i]:
            for j in range(i + i, n, i):
                sieve[j] = False

    return [i for i in range(2, n) if sieve[i]]


for prime in prime_list(N + 1):
    if M <= prime <= N:
        print(prime)