from collections import deque


def solution(bridge_length, max_weight, truck_weights):
    time = 0
    weight = 0
    bridge = deque()
    trucks = deque(truck_weights)
    truck_cnt = len(trucks)
    out = 0
    while out < truck_cnt:
        if bridge:
            if time - bridge[0][1] == bridge_length:
                weight -= bridge[0][0]
                bridge.popleft()
                out += 1
        
        if trucks:
            if weight + trucks[0] <= max_weight:
                bridge.append((trucks[0], time))
                weight += trucks[0]
                trucks.popleft()
        
        time += 1

    
    return time