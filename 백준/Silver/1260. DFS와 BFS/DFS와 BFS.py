import sys
from collections import deque
input = sys.stdin.readline

N, M, start = map(int, input().split())
edge = [[] for i in range(N + 1)]
visited_dfs = [False] * (N + 1)
visited_bfs = [False] * (N + 1)
result_dfs = []
result_bfs = []

for i in range(M):
    a, b = map(int, input().split())
    edge[a].append(b)
    edge[b].append(a)

for i in edge:
    i.sort()

def dfs(v):
    visited_dfs[v] = True
    result_dfs.append(v)

    for nx in edge[v]:
        if not visited_dfs[nx]:
            dfs(nx)
    return

def bfs(v):
    visited_bfs[v] = True
    Q = deque([v])
    result_bfs.append(v)

    while Q:
        temp = Q.popleft()

        for nx in edge[temp]:
            if not visited_bfs[nx]:
                Q.append(nx)
                visited_bfs[nx] = True
                result_bfs.append(nx)


dfs(start)
bfs(start)
print(" ".join(map(str, result_dfs)))
print(" ".join(map(str, result_bfs)))