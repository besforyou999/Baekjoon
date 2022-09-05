import sys
input = sys.stdin.readline

T = int(input())

answer = ""
A = 300
countA = 0
B = 60
countB = 0
C = 10
countC = 0

if T >= A:
    divA = int(T / A)
    remain = int(T % A)
    countA = divA
    T = remain

if T >= B:
    divB = int(T / B)
    remain = int(T % B)
    countB = divB
    T = remain

if T >= C:
    divC = int(T / C)
    remain = int(T % C)
    countC += divC
    T = remain

if T != 0:
    answer = -1
elif T == 0:
    answer = str(countA) + " " + str(countB) + " " + str(countC)

print(answer)

