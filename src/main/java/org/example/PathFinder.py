def solution(A):
    m = len(A)
    n = len(A[0])

    # initializing a
    B = [[
        0
        for _ in range(n)
    ]   for _ in range(m)
    ]

    for i in range(m):
        for j in range(n):

            if A[i][j] != '.': B[i][j] = 1

            if A[i][j] == 'A':
                B[i][j] = 0
                starti, startj = i,j

            if A[i][j] == 'v':
                k = i+1
                while k < m and A[k][j] == '.':
                    B[k][j] = 1
                    k += 1

            if A[i][j] == '^':
                k = i-1
                while k >= 0 and A[k][j] == '.':
                    B[k][j] = 1
                    k -= 1

            if A[i][j] == '>':
                k = j+1
                while k < n and A[i][k] == '.':
                    B[i][k] = 1
                    k += 1

            if A[i][j] == '<':
                k = j-1
                while k >= 0 and A[i][k] == '.':
                    B[i][k] = 1
                    k -= 1


    def f(i,j, visited):

        if i < 0: return False
        if j < 0: return False
        if i >= m: return False
        if j >= n: return False
        if (i,j) in visited: return False
        if B[i][j] == 1    : return False
        if j       == n-1  : return True
        visited.add((i,j))

        return (
            f(i,j+1, visited)
         or f(i,j-1, visited)
         or f(i+1,j, visited)
         or f(i-1,j, visited)
        )

    return f(starti, startj, set())