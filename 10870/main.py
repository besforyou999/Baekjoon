Fib = [ 0 , 1 ]

Fib.append(2)

n = input()

N = int(n)

i = 3

while ( i < len(Fib) ) :

	Fib1 = Fib[i-1]
	Fib2 = Fib[i-2]

	Fib.append(Fib1 + Fib2)

	i += 1



print(Fib[N-1])






