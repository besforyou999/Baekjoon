def is_sang(x):
    used = set()

    while True:
        tmp = 0
        for ch in str(x):
            tmp += int(ch) * int(ch)

        if tmp == 1:
            return True

        if tmp in used:
            break

        used.add(tmp)
        x = tmp

    return False


N = int(input())

isprime = [True] * (N + 1)
isprime[0] = isprime[1] = False

MAX = int(N**0.5)

for i in range(2, MAX + 1):
    if isprime[i]:
        for j in range(i + i, N + 1, i):
            isprime[j] = False

primes = [i for i in range(N + 1) if isprime[i]]

for prime in primes:
    if is_sang(prime):
        print(prime)