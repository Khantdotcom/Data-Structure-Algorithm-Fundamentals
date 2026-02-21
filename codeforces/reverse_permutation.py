t = int(input())

for _ in range(t):
	n = int(input())
	per = list(map(int,input().split('')))
	sorted_per = sorted(per,ascending=False)
	if per == sorted_per:
		print(sorted_per.join(' '))
	else:
		