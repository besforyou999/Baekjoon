line = input()
parts = set()
size = len(line)

for length in range(1, size + 1):
    for j in range(size - length + 1):
        parts.add(line[j:j+length])

print(len(parts))