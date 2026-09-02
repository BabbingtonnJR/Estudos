import random

def gerarMatriz(n_linhas, n_colunas):
    matriz = []
    for i in range(0, n_linhas):
        linha = []
        for j in range(0, n_colunas):
            linha.append(random.randint(1, 20))
        matriz.append(linha)
    return matriz

def imprimirMatriz(matriz):
    for i in range(0, linhas):
        print(matriz[i])

def acharPar(matriz):
    listaPar = []
    for i in range(0, linhas):
        for j in range(0, colunas):
            if matriz[i][j] % 2 == 0:
                listaPar.append(matriz[i][j])
    return listaPar

def somaColuna(matriz):
    listaColuna = []
    for i in range(0, linhas):
        for j in range(escolhaColuna - 1, escolhaColuna):
            listaColuna.append(matriz[i][j])
    return listaColuna

def maiorLinha(matriz):
    listaLinha = []
    maior = int(0)
    for i in range(escolhaLinha - 1, escolhaLinha):
        for j in range(0, colunas):
            if maior < matriz[i][j]:
                maior = matriz[i][j]
    listaLinha.append(maior)
    return listaLinha
            

linhas = int(input("Informe o numero de linhas da matriz: "))
colunas = int(input("Informe o numero de colunas da matriz: "))

m = gerarMatriz(linhas, colunas)

imprimirMatriz(m)

print(f"\nSoma dos números Pares: {sum(acharPar(m))}")

while True:
    escolhaColuna = int(input("Informe a coluna da matriz que quer somar: "))
    if escolhaColuna > colunas or escolhaColuna == 0:
        print("Escolha um número válido")
        continue
    else:
        break

print(f"A soma da coluna {escolhaColuna} é de: {sum(somaColuna(m))}")

while True:
    escolhaLinha = int(input("Informe a linha da matriz que quer achar o maior valor: "))
    if escolhaLinha > linhas or escolhaLinha == 0:
        print("Escolha um número válido")
        continue
    else:
        break
    
print(f"O maior número da linha {escolhaLinha} é o: {maiorLinha(m)}")