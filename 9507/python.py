arr = [1,1,2,4]

for i in range(4,68) :
	nextNum = arr[i-1] + arr[i-2] + arr[i-3] + arr[i-4]
	arr.append(nextNum)

t = int(input())

for i in range(t) :
	n = int(input())
	print(arr[n])
