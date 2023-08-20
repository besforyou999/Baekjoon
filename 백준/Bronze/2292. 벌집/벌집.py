val = int(input())

lastNumber = 1
depth = 1
while val > lastNumber:
    lastNumber = lastNumber + 6 * depth
    depth += 1

print(depth)