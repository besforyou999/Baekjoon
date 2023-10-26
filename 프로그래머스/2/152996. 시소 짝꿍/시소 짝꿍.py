# def solution(weights):
#     answer = 0
    
#     dict = {}
    
#     for w in weights:
#         if w in dict:
#             dict[w] += 1
#         else:
#             dict[w] = 1
    
    
#     for key in dict:
#         # 같은 몸무게
#         cnt = dict[key]
#         answer += (cnt * (cnt - 1)) // 2
        
#         # 2배
#         if key * 2 in dict:
#             answer += (cnt * dict[key*2])
        
#         # 1.5배
#         if int(key * 1.5) in dict:
#             answer += (cnt * dict[int(key * 1.5)])
        
#         # 4/3배
#         if (key * 4) // 3 in dict:
#             answer += (cnt * dict[(key * 4) // 3])
    
#     return answer


from collections import Counter

def solution(weights):
    answer, counter = 0, Counter(weights)

    for i in counter:
            answer += counter[i] * (counter[i] - 1) // 2 # nC2 n!/2!(n - 2)!
            answer += counter[i] * counter[i * 3 / 2]
            answer += counter[i] * counter[i * 2]
            answer += counter[i] * counter[i * 4 / 3]

    return answer