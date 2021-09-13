fib = [ 0 , 1 , 1]

n = int(input())

i = 3

while ( i <= n ) :

	f1 = fib[i-1] 
	f2 = fib[i-2]
	fib.append(f1 + f2)

	i += 1

print(fib[n])
