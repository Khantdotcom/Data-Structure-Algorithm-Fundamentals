def findLargestCombo(num_str):
    index_dict = {}
    for idx,ch in enumerate(num_str):
        ch = int(ch)
        if ch not in index_dict:
            index_dict[ch] = []
        index_dict[ch].append(idx)
    result = ""
    while True:
        biggest_num = None
        smallest_idx = None
        for digit in sorted(index_dict.keys(),reverse=True):
            if not index_dict[digit]:
                continue
            candidate_index = index_dict[digit][0]
            if biggest_num is None:
                biggest_num = digit
                smallest_idx = candidate_index
            else:
                if digit > biggest_num or candidate_index < smallest_idx:
                    biggest_num = digit
                    smallest_idx = candidate_index
        if biggest_num is None:
            break
        result += str(biggest_num)
        index_dict[biggest_num].pop(0)
    return result
