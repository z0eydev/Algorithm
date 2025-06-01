# 교재 : 이것이 취업을 위한 코딩테스트이다
# DFS/BFS 예제 5-10 음료수 얼려 먹기(p. 149)

n, m = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(n)]

def dfs(x, y):
    if x <= -1 or x >= n or y <= -1 or y > m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x-1, y)
        dfs(x, y-1)
        dfs(x+1, y)
        dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i,j):
            restul += 1

print(result)