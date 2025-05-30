# https://www.acmicpc.net/problem/1744
# 백준 gold4 수 묶기
from collections import deque

def calculate(num_list):
    result = 0
    while num_list:
        if len(num_list) == 1:
            result += num_list[0]
            break
        result += (num_list.popleft() * num_list.popleft())
    return result

N = int(input())
minus_list = []
plus_list = []
one = 0

for _ in range(N):
    num = int(input())
    if num == 1:
        one += 1
    elif num <= 0:
        minus_list.append(num)
    else:
        plus_list.append(num)

if minus_list:
    minus_list.sort()
if plus_list:
    plus_list.sort(reverse=True)

print(calculate(deque(minus_list)) + calculate(deque(plus_list)) + one)