operacao = int()
while True:
    print(f'1:SOMA\n2:SUBTRAÇÃO\n3:MULTIPLICAÇÃO\n4:DIVISÃO\n5:SAIR')
    operacao = int(input('Escolha a operação matemática: '))
    if operacao == 5:
        print(f'Você saiu da calculadora!')
        break
    elif operacao > 5 or operacao <= 0:
        print('\nEscolha uma das opções validas\n')
        continue
    num1 = float(input('Digite um número: '))
    num2 = float(input('Digite um segundo número: ')) 
    if operacao == 1:
        print(f'\nO resultado da operação é:\n {num1} + {num2} = {num1 + num2}\n\n')
    elif operacao == 2:
        print(f'\nO resultado da operação é:\n {num1} - {num2} = {num1 - num2}\n\n')
    elif operacao == 3: 
        print(f'\nO resultado da operação é:\n {num1} * {num2} = {num1 * num2}\n\n')
    elif operacao == 4:
        print(f'\nO resultado da operação é:\n {num1} / {num2} = {num1 / num2}\n\n')