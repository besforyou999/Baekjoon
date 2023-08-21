import sys
input = sys.stdin.readline

N, game = input().split()

players = {}

for _ in range(int(N)):
    player = input()
    if not player in players.keys():
        players[player] = 1

div = 0

if game == 'Y':
    div = 1
elif game == 'F':
    div = 2
else:
    div = 3

print(int(len(players.keys()) / div))