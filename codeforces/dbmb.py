t = int(input())

for _ in range(t):
	n,s,x = list(map(int,input().split()))
	arr = list(map(int, input().split()))

	#n = length(arr), s= equal, x = add
	result = sum(arr)
	if result > s:
		print("NO")
	else:
		target = s - result 
		if target%x == 0:
			print("YES")
		else
			print("NO")
