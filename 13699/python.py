t = []

t.append(1)
t.append(1)
t.append(2)

for i in range(3,36) :
	nextv = 0
	for j in range(0,i) :
		nextv += t[j] * t[i-1-j]
	t.append(nextv)

n = int(input())

print(t[n])

