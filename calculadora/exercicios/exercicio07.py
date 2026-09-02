listaPessoa = []
matriz = []
n = 0
somaRenda = 0
somaIdade = 0

def adicionarNaMatriz(lista):
    for i in range(0, n):
        matriz.append(lista)
    return matriz

def arrumarMatriz(matriz):
    for i in range(0, n):
        print(matriz[i])           

while True:
    n += 1
    listaPessoa = []
    nome = str(input("Digite o seu nome: "))
    cpf = float(input("Digite o seu CPF: "))
    idade = int(input("Digite a sua idade: "))
    renda = float(input("Digite a sua renda mensal: "))
    continuar = input("Você deseja adicionar mais um cadastro?: ")
    listaPessoa.append(nome)
    listaPessoa.append(cpf)
    listaPessoa.append(idade)
    listaPessoa.append(renda)
    somaRenda += renda
    somaIdade += idade
    adicionarNaMatriz(listaPessoa)
    if continuar == "Sim":
        continue
    else:
        break

arrumarMatriz(matriz)

print(f"A média das idades é de: {somaIdade/n}")
print(f"A média das rendas é de: {somaRenda/n}")