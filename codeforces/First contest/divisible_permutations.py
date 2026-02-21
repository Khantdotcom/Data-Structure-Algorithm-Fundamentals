t = int(input())

for _ in range(t):
	order = int(input())
	if order %2 == 0:
		left = (order+1)//2
	else:
		left = order//2
	right = left + 1
	for i in range(1,order+1):
	    if i % 2 == 0:
	        print(left,end=" ")
	        left -= 1
	    else:
	        print(right,end=" ")
	        right += 1


	

