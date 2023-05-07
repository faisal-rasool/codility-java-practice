import queue
import test

def solution(A: list) -> int:

    expenses       = queue.PriorityQueue(maxsize= len(A))
    currentBalance = 0
    nReschedules   = 0
    
    for i in range(len(A)):
        currentBalance += A[i]  # updating currentBalance
        
        if A[i] < 0:            # if current element is an expense
            expenses.put(A[i])  # add it to the queue
        
        if currentBalance < 0:                # if currentBalance has fallen below 0
            largestExpense  = expenses.get()  # reschedule the largest expense
            currentBalance -= largestExpense  # remove that expense from the current currentBalance
            nReschedules   += 1               # increase the number of reschedules 
            
    return nReschedules
            

# run the file to execute test
inputs = (
    ([10,-10,-1,-1,1],),
    ([-1,-1,-1,1,1,1,1],),
    ([5,-2,-3,1],),
)
outputs = (
    1,
    3,
    0
)
test.display(solution, inputs, outputs)