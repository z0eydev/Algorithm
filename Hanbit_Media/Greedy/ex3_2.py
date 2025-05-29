# 교재 : 이것이 취업을 위한 코딩테스트이다
# 그리디 예제 3-2 큰 수의 법칙(p. 92)

N, M, K = map(int, input().split())
data = list(map(int, input().split()))

data.sort(reverse=True)
first, second = data[0], data[1]

result = 0
cnt = 0

for _ in range(M):
    cnt += 1
    if cnt > K:
        cnt = 0
        result += second
    else:
        result += first

print(result)