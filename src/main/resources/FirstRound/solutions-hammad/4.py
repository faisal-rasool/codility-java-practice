
def solution(x: int) -> int:
    x: str       = str(x)  # converting the number to it's string representation
    x: list[str] = list(x) # converting the string to an array of characters
    
    for i in range(0,len(x)):   # iterating on the array from the left side
        if x[i] == '6':         # finding the first '6' (most significant 6)
            x[i] = '9'          # changing it to '9'
            break               
    
    x: str = ''.join(x)  # converting the array of characters to a string
    x: int = int(x)      # converting the string to an integer

    return x