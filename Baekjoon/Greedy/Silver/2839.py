# 백준 silver4 설탕 배달

# input 값
N = int(input())

# 3키로 가방 개수
cnt = 0
result = -1

while N >= 0:
    if N % 5 == 0:
        result = N//5 + cnt
        break
    cnt += 1
    N -= 3

print(result)