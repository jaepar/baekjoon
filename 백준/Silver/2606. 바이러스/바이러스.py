n = int(input())
e = int(input())
graph = [[] for i in range(n+1)]
visited = [False]*(n+1)
count = 0

for i in range(e):
    a, b = map(int, input().split())
    graph[a] += [b]
    graph[b] += [a]

def dfs(v):
    global count
    visited[v] = True
    count += 1
    for nx in graph[v]:
        if not visited[nx]:
            dfs(nx)
    return count-1

dfs(1)
print(count-1)