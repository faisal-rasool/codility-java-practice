def solution(s: str) -> int:

    n = len(s)

    totalA = 0
    for i in range(n):
        if s[i] == 'A':
            totalA += 1

    AsoFar = 0
    BsoFar = 0
    res    = n
    for i in range(n):
        if s[i] == 'A': AsoFar += 1
        else          : BsoFar += 1

        nBtoRemove = BsoFar
        nAtoRemove = totalA - AsoFar
        res = min(res, nBtoRemove + nAtoRemove)

    return res