A, B = map(int, input().split())


def GCD(a, b):
    if b == 0:
        return a
    return GCD(b, a % b)


gcd = GCD(A, B)
print(gcd)
print(int(A * B / gcd))