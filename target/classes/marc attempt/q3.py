'''
An industrial company has N factories, each producing some pollution every month. The company has decided to 
reduce its total fume emissions by equipping some of the factories with one or more filters. 
Every such filter reduces the pollution of a factory by half. When a second (or subsequent) filter is applied, it again 
reduces by half the remaining pollution emitted after fitting the existing filter(s). For example, a factory that initially 
produces 6 units of pollution will generate 3 units with one filter, 1.5 units with two filters and 0.75 units with three 
filters. 

You are given an array of N integers describing the amount of pollution produced by the factories. Your task is to find 
the minimum number of filters needed to decrease the total sum of pollution by at least half. 
Write a function: 
which, given an array of integers A of length N, returns the minimum number of filters needed to reduce the total 
pollution by at least half. 
Examples: 
1. Given A = [5, 19, 8, 1], your function should return 3. The initial total pollution is 5+ 19 +8+ 1 = 33. We install two 
filters at the factory producing 1 g units and one filter at the factory producing 8 units. Then the total pollution will be 5 
+ ((19 / 2) / 2) + (8 / 2) + 1 = 5 + 4.75 + 4 + 1 = 14.75 which is less than 33 / 2 = 16.5, so we have achieved our goal. 
2. Given A = [10, 10], your function should retum 2, because we may install one filter at each factory. 
3. Given A = [3, O, 51, your function should return 2, because it is sufficient to install one filter at each factory producing a non-zero amount of pollution. 

Write an efficient algorithm for the following assumptions: 
• N is an integer within the range [1 .. 30,000]; 
• each element of array A is an integer within the range [0... 70,000]. 
'''

test1 = [5, 19, 8, 1] # output = 4
test2 = [10 , 10] # output 2
test3 = [3, 0, 5] # output 2
test4 = []


def solution(A):
   # count number of filters
    count = 0
    filters = 0
    # loop through list
    for i in range(len(A)):
        # if pollution is greater than half, add filter and divide pollution by 2
        if A[i] > A[i]/2:
            filters += 1
            A[i] = A[i]/2 
            # count number of filters
            count += 1
            # if count is greater than half, return number of filters
            if count > len(A)/2:
                return filters
    return filters

print(solution(test1))
print(solution(test2)) 
print(solution(test3))
print(solution(test4))

