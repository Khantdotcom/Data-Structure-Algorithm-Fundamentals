t = int(input())
for _ in range(t):
    n = int(input())
    s = input().strip()

    ones = s.count('1')
    if ones == 0:
        print((n + 2) // 3)
        continue

    result = ones

    pre = -1  
    for i, ch in enumerate(s):
        if ch == '1':
            if pre == -1:
                L = i
                result += (L + 1) // 3
            else:
                L = i - pre - 1
                result += L // 3
            pre = i

    L = n - pre - 1
    result += (L + 1) // 3

    print(result)
