def solution(N: int, K: int) -> int:
    
    # at each betting step we have 2 options, bet 1 chip or go all in
    # we can imagine that all the possible sequences of bets form a tree structure
    # where each betting step is a node
    # and each node leads to two more nodes corresponding to the two options
    # so in order to find the minimum number of bets, we need to find the length of the smallest branch
    # we can perform depth first trraversal on this tree using recursive calls

    def f(K, currentChips):
        # K is the number of all-in bets remaining
        # currentChips is the number of chips we have at this node

        if N <  currentChips: return float('inf')       # if we overshot the goal, terminate this branch
        if N == currentChips: return 0                  # if goal is already satisfied no more bets are required
        if K == 0           : return N - currentChips   # if we run out of all-in bets, we can only satisfy the goal by winning the remaining chips 1 chip at a time
        return 1 + min(
            f(K  , currentChips+1),  # if we bet 1 chip, K remains same, currentChips increase by 1
            f(K-1, currentChips*2)   # if we bet all-in, K is reduced by 1, currentChips are doubled
        )
    
    return f(K,1) # we start with 1 chip

