H, W, N, M = map(int, input().split())

import math

a = math.ceil(H / (N + 1))
b = math.ceil(W / (M + 1))
print(a * b)