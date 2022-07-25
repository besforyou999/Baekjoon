computer_number = int(input())
connections_number = int(input())

network = [[0 for col in range(computer_number)] for row in range(computer_number)]

for _ in range(connections_number):
    start, end = map(int, input().split())
    network[start - 1][end - 1] = network[end - 1][start - 1] = 1

visited = [False for idx in range(computer_number)]

def dfs(node):
    if visited[node] is True:
        return
    visited[node] = True
    for idx in range(computer_number):
        if network[node][idx] == 1 and visited[idx] is False:
            dfs(idx)

def count_infected():
    count = 0
    for i in visited:
        if i is True:
            count += 1
    return count

dfs(0)

print(count_infected() - 1)
