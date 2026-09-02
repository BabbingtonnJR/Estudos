ordem = []
for i in range(1, 11):
    numero = int(input(f'Digite o numero {i}: '))
    ordem.append(numero)
print(sorted(ordem))