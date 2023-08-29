def solution(cacheSize, cities):
    answer = 0

    if cacheSize == 0:
        return len(cities) * 5

    cities = list(map(to_lower, cities))

    # front LRU, 맨 뒤 최신
    cache = []

    for city in cities:
        if city in cache:  # 캐시 히트
            answer += 1
            cache.remove(city)
            cache.append(city)
        elif city not in cache:  # 캐시 미스
            if len(cache) == cacheSize:  # 캐시 꽉찬 경우
                cache.pop(0)
            cache.append(city)
            answer += 5

    return answer


def to_lower(string):
    return string.lower()