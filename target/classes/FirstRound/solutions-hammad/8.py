def solution(A: list) -> int:

    maxSoFar = -float('inf')

    for i in range(0, len(A)-5):
        sumOfTile1 = A[i] + A[i+1]

        for j in range(i, len(A)-3):
            sumOfTile2 = A[j] + A[j+1]

            for k in range(j, len(A-1)):
                sumOfTile3 =  A[k] + A[k+1]

                maxSoFar = max(maxSoFar,  sumOfTile1 + sumOfTile2 + sumOfTile3)
    
    return maxSoFar