def gerarMatriz(linhas, colunas):
    matriz = []
    for i in range(0, linhas):
        linha = []
        for j in range(0, colunas):
            if i < j:
                numero = 2*i + 7*j + 2
            elif i > j:
                numero = 4*i**3 + 5*j**2 + 1
            else:
                numero = 3*i**2 + 1
            linha.append(numero)
        matriz.append(linha)
    return matriz

def imprimirMatriz(matriz, linhas):
    for i in range(0, linhas):
        print(matriz[i])

m = gerarMatriz(10,10)

print(imprimirMatriz(m, 10))

#numero = 2*i + 7*j + 2

#numero = 4*i**3 + 5*j**2 + 1

#numero = 3*i**2 + 1