div = 10007

n = int(input())

i = 0

dp = [0,1,3]


for i in range(3,n+1) :
	new = (  ( dp[i-1] % div) + ( 2 * dp[i-2] ) % div ) % div
	dp.append(new)
		
print(dp[n])
