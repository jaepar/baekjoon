import sys

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
plus, minus, multiply, divide = map(int, input().split())

minimum = 1e9
maximum = -1e9

def dfs(depth, result, plus, minus, multiply, divide):
    global minimum, maximum

    if depth == N:
        minimum = min(result, minimum)
        maximum = max(result, maximum)
        return

    if plus:
        dfs(depth + 1, result + A[depth], plus - 1, minus, multiply, divide)
    if minus:
        dfs(depth + 1, result - A[depth], plus, minus - 1, multiply, divide)
    if multiply:
        dfs(depth + 1, result * A[depth], plus, minus, multiply - 1, divide)
    if divide:
        dfs(depth + 1, int(result / A[depth]), plus, minus, multiply, divide - 1)

dfs(1, A[0], plus, minus, multiply, divide)
print(maximum)
print(minimum)