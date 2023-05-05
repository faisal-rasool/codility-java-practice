def solution(s: str) -> bool:

    reachedB = False
    for i in range(0,len(s)):
        if s[i] == 'b':              # iterating until we find the first 'b'
            reachedB = True
        if reachedB and s[i] == 'a': # after that if we find an 'a' return false
            return False

    # else return true
    return True

