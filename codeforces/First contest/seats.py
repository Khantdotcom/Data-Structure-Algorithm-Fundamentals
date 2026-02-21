t = int(input())

for _ in range(t):
	seats = int(input())
	row = input()
	result = 0
	one_indx = [index for index,char in enumerate(row) if char == "1"]
	l = len(one_indx)
	if l == 0 :
	    if seats == 1 :
	        result += 1
	    else:
		    result += seats//2
	elif l == 1 or seats == 1:
		result = 0
	else:
		pre = 0
		for i in one_indx:
			diff = i-pre
			if diff >= 4:
				result += (diff-1)//2 + 1
			pre = i
	print(result)


	#if all zeros and place in even-th number -> which means floor division by 2

	t = int(input())

for _ in range(t):
	seats = int(input())
	row = list(map(int,input().split(' ')))
	result = 0

	l = len(row)
	pre = 0
	found_one = False
	for num in range(row):
		if num == 1:
			diff = num-pre
			if diff >= 4:
				result += (diff-1)//2 + 1
			pre = i
			found_one = True
	if not found_one:
		if seats == 1:
		    result += 1
	    else:
			result += seats//2
	print(result)