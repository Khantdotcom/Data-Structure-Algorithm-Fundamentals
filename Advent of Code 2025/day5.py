def checkrange(puzzle):
    ranges, nums = [data.splitlines() for data in puzzle.split('@')]
    ra = []
    for ran in ranges:
        lo,hi = ran.split('-')
        ra.append([lo,hi])
    new_ra = []
    for idx,ran in enumerate(ra):
        
        
    #preprocessing the ranges so that there is no overlap
    #defining if a number is greater than or equal to a min of continuous range and
    #it's less than or equal to a max of a continuous range, a number is counted as fresh
    #sort the mins in ranges -> check if max of each range is at least two less than the next min
    #if not merge by min of first one and max of second one (only if min of first one is less than next one's min, if )


checkrange('''3-5
10-14
12-18
16-20
@1
5
8
11
17
32''')