dentro = []
fora = []
for i in range(1, 11):
    numero = int(input(f'Digite o numero {i}: '))
    if numero <= 20 and numero >= 10:
        dentro.append(numero)
    else:
        fora.append(numero)
print(f'A quantidade de numeros fora do intervalo de (10,20) é de {len(fora)}\nA quantidade de numeros dentro do intervalo de (10,20) é de {len(dentro)}')