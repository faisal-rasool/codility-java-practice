import math

def solution(s: str):

    continiousSubstringsLengths = []     # lengths of continious substrings

    # first we will find the lengts of all continious substrings 
    # a substring of length of 1 is also considered continious

    i = 0   # start index of substring
    j = 0   # end index of substring
    while j < len(s):

        while s[j] == s[i] and j < len(s):  # while s[i:j] is continious
            j += 1                          # increment j
        
        continiousSubstringsLengths.append(j-i) # adding the length of the continious substring
        i = j                                   # start of next substring will be the end of current substring

    
    totalOpsRequired = 0    # total number of ops required to fix the string

    for i in range(0,len(continiousSubstringsLengths)): # iterating over the lengths of the substrings
        substringLength   = continiousSubstringsLengths[i]
        opsRequired      += math.floor(substringLength / 3)  # we find the number of ops required to fix this substring
        totalOpsRequired += totalOpsRequired                 # add this to total number of ops required

        # math.floor(x / 3) returns the number of multiples of 3 less then x
        # so a string of 
        # length 1 needs 0 operation
        # length 2 needs 0 operation
        # length 3 needs 1 operation
        # length 4 needs 1 operation
        # length 5 needs 1 operation
        # length 6 needs 2 operations
        # and so on

    return totalOpsRequired
    
