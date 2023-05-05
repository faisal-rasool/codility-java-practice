
def solution(D: list, X: int) -> int:

    nDays = 1               # start from day 1
    minDifficulty = D[0]    # keep track of minimum difficulty each day
    maxDifficulty = D[0]    # keep track of maximum difficulty each day

    for i in range(1, len(D)):  # iterating from 2nd level onwards (not days)
        
        currentDifficulty = D[i]

        # if the difference of current difficulty and min/max is more than X
        if (X < (currentDifficulty - minDifficulty)) or (X < (maxDifficulty - currentDifficulty)):
            # then we move to the next day
            nDays += 1                          
            
            # at the start of each day
            # min/max difficulty is the difficulty of the first level of that day
            minDifficulty = currentDifficulty
            maxDifficulty = currentDifficulty
        
        else:
            # we stay in the same day and
            # we update the min/max difficulties for that day
            minDifficulty = min(minDifficulty, currentDifficulty)
            maxDifficulty = max(maxDifficulty, currentDifficulty)
    
    return nDays

print(solution([5,8,2,7],3))
print(solution([2,5,9,2,1,4],4))
print(solution([1,5,9,13],3))