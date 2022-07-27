numbers = [0 for _ in range(1, 10001)]

def d(n):
    sum = n
    string = str(n)
    for i in string:
        sum += int(i)
    return sum

for idx in range(1, 10000):
    if numbers[idx] == 0:
        constructor = idx
        while constructor <= 10000:
            result = d(constructor)
            if result >= 10000:
                break
            numbers[result] = 1
            constructor = result

for i in range(1, 10000):
    if numbers[i] == 0:
        print(i)

