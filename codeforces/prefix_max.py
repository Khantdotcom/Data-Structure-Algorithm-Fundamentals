t = int(input())

for _ in range(t):
	length = int(input())
	arr = input().split(' ')
	result = 0
	for i in range(length):
		result += int(max(arr[0:i+1]))
	print(result)
