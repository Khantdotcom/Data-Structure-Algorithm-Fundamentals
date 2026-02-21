from collections import Counter

n = int(input())
moods = list(map(int,input().split()))

inx_diff = []
pre = 0 if moods[0] == 1 else None

for i in range(1,len(moods)):
	if moods[i] == 1:
		if pre is None:
			pre = i
			continue
		inx_diff.append(i - pre)
		pre  = i
count = Counter(inx_diff)

print("YES" if any(x>=2 for x in count.values())  else "NO")
