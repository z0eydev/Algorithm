# https://www.acmicpc.net/problem/1931
# 백준 gold5 회의실 배정

N = int(input())
time_list = [list(map(int, input().split())) for _ in range(N)]
time_list.sort(key=lambda x:[x[1], x[0]])
end_time = time_list[0][1]
result = 1

for i in range(1, N):
    if time_list[i][0] < end_time:
        continue
    end_time = time_list[i][1]
    result += 1

print(result)