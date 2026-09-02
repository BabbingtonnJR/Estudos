numPar = []
numImpar = []
for i in range(1, 11):
    numero = int(input(f'Digite o numero {i}: '))
    if numero % 2 == 0:
        numPar.append(numero)
    else:
        numImpar.append(numero)
print(f'A quantidade de numeros pares da tabela {numPar} é de {len(numPar)}\nA quantidade de numeros impares da tabela {numImpar} é de {len(numImpar)}')