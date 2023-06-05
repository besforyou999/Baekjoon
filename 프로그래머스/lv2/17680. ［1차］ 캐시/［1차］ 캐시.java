import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        if (cacheSize == 0) 
            return 5 * cities.length;

        ArrayDeque<String> cache = new ArrayDeque<>();
        // 캐시 맨 앞 : 가장 최근
        // 캐시 맨 뒤 : 가장 오래됨.

        int usedTime = 0;

        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            if (cache.contains(city)) { // 캐시 히트
                usedTime += 1;
                cache.remove(city);
                cache.addFirst(city);
            } else {    // 캐시 미스
                usedTime += 5;
                if (cache.size() < cacheSize) { // 캐시에 빈 공간 존재
                    cache.addFirst(city);
                } else { // 캐시에 빈 공간 없음
                    cache.pollLast();
                    cache.addFirst(city);
                }
            }
        }

        return usedTime;
    }
}