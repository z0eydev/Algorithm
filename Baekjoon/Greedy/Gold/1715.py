# https://www.acmicpc.net/problem/1715
# 백준 gold4 카드 정렬하기
from heapq import heappop, heappush

N = int(input())
card_list = []
for _ in range(N):
    heappush(card_list, int(input()))
result = 0

while len(card_list) > 1:
    first = heappop(card_list)
    second = heappop(card_list)
    bundle = first + second
    result += bundle
    heappush(card_list, bundle)

print(result)