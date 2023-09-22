N, L = map(int, input().split())
hi = list(map(int, input().split()))

hi.sort()

while True:
    eat = False
    for h in hi:
        if L >= h:
            L += 1
            eat = True
            hi.remove(h)
            break

    if not eat:
        break

print(L)