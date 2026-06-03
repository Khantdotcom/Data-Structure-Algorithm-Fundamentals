def isInvalid(number):
    n = len(number)
    result = []
    for i in range(1,6):
        if n % i != 0:
            continue
        if i >= n:
            break
        unique_arr = len(set([number[j:j+i] for j in range(0,n,i)]))
        result.append(unique_arr ==1)
    return sum(result) >= 1
    
def invalid_sum(start,end):
    su = 0
    for i in range(int(start),int(end)+1):
        if isInvalid(str(i)):
            su += i
    return su


raw_data = "9595822750-9596086139,1957-2424,88663-137581,48152-65638,12354817-12385558,435647-489419,518494-609540,2459-3699,646671-688518,195-245,295420-352048,346-514,8686839668-8686892985,51798991-51835611,8766267-8977105,2-17,967351-995831,6184891-6331321,6161577722-6161678622,912862710-913019953,6550936-6625232,4767634976-4767662856,2122995-2257010,1194-1754,779-1160,22-38,4961-6948,39-53,102-120,169741-245433,92902394-92956787,531-721,64-101,15596-20965,774184-943987,8395-11781,30178-47948,94338815-94398813"
rang = raw_data.split(",")

total_sum = 0
for i in range(0,len(rang)):
    start, end = rang[i].split("-")
    total_sum += invalid_sum(start,end)

print(total_sum)

##Advent of Code Day 2 : 
##Problem Breakdown - You are given a string of id ranges seperated by "comma", for example - "48152-65638,12354817-12385558". 
##What to do : An ID is invalid when:
##They have repeated patterns in strings (for example, 101101 counts as invalid since "101" is repeated.)
##More examples - "1111", "101010", "11"
##Question - What the sum of all invalid ids in the string