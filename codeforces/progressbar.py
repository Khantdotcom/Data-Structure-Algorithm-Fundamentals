n, k, t = map(int, input().split())

s = (n * k * t) // 100
full = s // k
rem = s % k

for i in range(n):
    if full > 0:
        print(k, end=" ")
        full -= 1
    elif rem > 0:
        print(rem, end=" ")
        rem = 0
    else:
        print(0, end=" ")
