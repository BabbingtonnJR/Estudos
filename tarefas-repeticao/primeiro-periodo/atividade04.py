idades = []
num = int(input('Digite o numero de idades: '))
for i in range(0, num):
    idade = int(input('Digite a idade: '))
    idades.append(idade)
media = sum(idades)/len(idades)
print(f'A média das {num} idades é de: {media}')