def display(function, inputs, outputs):

    for input,output in zip(inputs,outputs):
        
        print(f'input          : {input}')
        print(f'output         : {function(*input)}')
        print(f'expected output: {output}')
        print()