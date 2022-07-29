from sys import stdin

r = 31
M = 1234567891
a_ascii = ord('a')
H = 0

L = int(stdin.readline())
string = stdin.readline()

for i in range(L):
    ch_ascii = ord(string[i])
    a = ch_ascii - a_ascii + 1
    H += a * pow(r,i)
    H = H % M

print(H)
