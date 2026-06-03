def removeDuplicates(nums: list[int]) -> int:
    last_element = nums[0]
    unique_nums = [nums[0]]
    for i in range(1,len(nums)):
        if last_element != nums[i]:
            unique_nums.append(nums[i])
            last_element = nums[i]
    return unique_nums

print(removeDuplicates([1,1,2,2,3,4]))
    
