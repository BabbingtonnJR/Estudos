num = int(input('Digite um numero de 1 a 10: '))
if num < 11 and num > 0:
    for i in range(1, 11):
        operacao = num * i
        print(f'{num} x {i} = {operacao}')
else:
    print('Reinicie e escolha um numero valido')