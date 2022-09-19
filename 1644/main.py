import sys
input = sys.stdin.readline

N = int(input())


def prime_list(N):
    rec = [False] * (N + 1)
    M = int(N ** 0.5)
    for i in range(2, M + 1):
        if rec[i] is False:
            for j in range(i + i, N + 1, i):
                rec[j] = True

    return [i for i in range(2, N + 1) if rec[i] is False]


primes = prime_list(N)
primes.append(0)
lp = rp = count = 0
S = primes[0]

while lp <= rp < len(primes) - 1:
    if S < N:
        rp += 1
        S += primes[rp]
    elif S > N:
        S -= primes[lp]
        lp += 1
    else:
        count += 1
        lp += 1

print(count)

