# 교재 : 이것이 취업을 위한 코딩테스트이다
# 그리디 예제 3-1 거스름돈(p. 87)

# 받은 돈
M = int(input())

# 동전 종류
coin_list = [500, 100, 50, 10]
N = 0

# 거스름돈 구하는 식
for c in coin_list:
    N += M // c
    M %= c

print(N)