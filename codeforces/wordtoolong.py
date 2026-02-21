t = int(input())

for _ in range(t):
	i = input()
	l = len(i)
	if l > 10:
		print(i[1]+ str(l-2) + i[-1])
	else:
		print(i)