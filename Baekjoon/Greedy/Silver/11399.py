# 백준 silver4 ATM

N = int(input())
P = list(map(int, input().split()))

P.sort()
result = 0
wait = 0

for p in P:
    wait += p
    result += wait

print(result)