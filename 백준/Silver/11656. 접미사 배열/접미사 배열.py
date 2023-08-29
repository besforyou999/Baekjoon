line = input().rstrip()

post = []

for i in range(len(line)):
    post.append(line[i:])

post.sort()

for item in post:
    print(item)