line1 = input()
line2 = input()

len1 = len(line1)
len2 = len(line2)

dp = [[0] * (len1 + 1) for _ in range(len2 + 1)]

for c in range(1, len1 + 1):
    for r in range(1, len2 + 1):
        if line1[c - 1] == line2[r - 1]:
            dp[r][c] = dp[r-1][c-1] + 1
        else:
            dp[r][c] = max(dp[r][c], dp[r-1][c], dp[r][c-1])

print(dp[len2][len1])