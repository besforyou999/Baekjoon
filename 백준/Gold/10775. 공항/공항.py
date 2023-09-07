import sys

G = int(sys.stdin.readline().rstrip())
P = int(sys.stdin.readline().rstrip())

plane_list = []
for i in range(P):
    plane_list.append(int(sys.stdin.readline().rstrip()))

# 게이트는 처음 자기자신 값을 가진
gate_parent = [i for i in range(G + 1)]


def find(plane):
    # 게이트가 자기 자신을 가리키는 경우 == 게이트가 비어있음
    if gate_parent[plane] == plane:
        return plane
    # 부모 게이트를 재귀적으로 탐색하면서 비어있는 게이트를 찾는다.
    gate_parent[plane] = find(gate_parent[plane])
    return gate_parent[plane]


count = 0

for plane in plane_list:
    empty_gate = find(plane)
    if empty_gate == 0:
        break
    gate_parent[empty_gate] = gate_parent[empty_gate - 1]
    count += 1

print(count)