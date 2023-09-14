mushrooms = [0]

for _ in range(10):
    mushrooms.append(int(input()))

for i in range(1, 11):
    mushrooms[i] = mushrooms[i] + mushrooms[i - 1]

min_dist = 1e9
value = 0

for i in range(11):
    eat = mushrooms[i]
    d = int(abs(100 - eat))
    if d < min_dist:
        min_dist = d
        value = eat
    elif d == min_dist:
        if eat > value:
            value = eat

print(value)