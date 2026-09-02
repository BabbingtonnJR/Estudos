import math
import numpy as np
import matplotlib.pyplot as plt

def menu():
    print(f"\n1 - Conjuntos Numéricos")
    print("2 - Funções de Segundo Grau")
    print("3 - Funções Exponenciais")
    print("4 - Matrizes")
    print(f"5 - Sair\n")
    escolha = int(input("Escolha uma operação matemática: "))
    return escolha

def menuConjunto():
    print(f"\n1 - Verificar Subconjunto Próprio")
    print("2 - União de Conjuntos")
    print("3 - Intersecção de Conjuntos")
    print("4 - Diferença de Conjuntos")
    print(f"5 - Voltar\n")
    escolha = int(input("Escolha uma opção: "))
    return escolha

def menuFuncaoSegundoGrau():
    print(f"\n1 - Cálculo de Raízes")
    print("2 - Cálculo em Função de x")
    print("3 - Cálculo do Vértice")
    print("4 - Gráfico")
    print(f"5 - Voltar\n")
    escolha = int(input("Escolha uma opção: "))
    return escolha

def menuFuncaoExponencial():
    print(f"\n1 - Crescente ou Decrescente")
    print("2 - Calcular em Função de x")
    print("3 - Gráfico")
    print(f"4 - Voltar\n")
    escolha = int(input("Escolha uma opção: "))
    return escolha

def menuMatriz():
    print(f"\n1 - Cálculo Determinante")
    print("2 - Matriz A x Matriz B")
    print("3 - Matriz Transposta")
    print(f"4 - Voltar\n")
    escolha = int(input("Escolha uma opção: "))
    return escolha

def subconjunto(a, b):
    if set(a).issubset(b):
        return print(f"\nA é subconjunto proprio de B")
    elif set(b).issubset(a):
        return print(f"\nB é subconjunto proprio de A")
    else:
        return print(f"\nNenhum é subconjunto de outro")

def uniaoInterseccaoDiferenca(a, b, x):
    if x == 1:
        return set(a).union(b)
    elif x == 2:
        return set(a).intersection(b)
    elif x == 3:
        if a > b:
            print(f"\nA diferença do conjunto A - B resulta em: {set(a) - set(b)}")
        elif b > a:
            print(f"\nA diferença do conjunto B - A resulta em: {set(b) - set(a)}")
    
def calcularRaiz(a, b, c):
    lista = []
    delta = b*b - (4*a*c)
    if delta >= 0:
        raiz = math.sqrt(delta)
    elif delta < 0:
        raiz = math.sqrt(-delta)
    if delta >= 0:
        x1 = (-b + raiz)/(2 * a)
        x2 = (-b - raiz)/(2 * a)
        lista.append(x1)
        lista.append(x2)
        return print(f"\nRaízes:\nx1: {lista[0]}\nx2: {lista[1]}")
    if delta < 0:
        x1 = (-b + (-raiz))/(2 * a)
        x2 = (-b - (-raiz))/(2 * a)
        lista.append(x1)
        lista.append(x2)
        return print(f"\nRaízes:\nx1: {lista[0]}i\nx2: {lista[1]}i")

def resolverFuncao(a, b, c, x):
    f = a * x ** 2 + b * x + c
    return print(f"\nf({x}) = {a}*{x}^2 + {b}*{x} + {c}\nf({x}) = {f}")

def calculoVertice(a, b, c):
    delta = b*b - (4*a*c)
    xv = -b/(2*a)
    yv = delta/(4*a)
    if a > 0:
        return print(f"\n(Xv:{xv}, Yv:{yv}) e o ponto é mínimo")
    elif a < 0:
        return print(f"\n(Xv:{xv}, Yv:{yv}) e o ponto é máximo")

def graficoFuncaoSegundoGrau(a, b, c, x, calc):
    f = a * x ** 2 + b * x + c
    plt.plot(x, f)
    plt.title(calc)
    plt.grid()
    plt.show()

def verificarCrescenteDescrescente(a):
    if a > 1:
        return print(f"\nA função é Crescente")
    elif a < 1:
        return print(f"\nA função é Decrescente")

def calcularFuncaoX(a, x):
    f = a ** x
    return print(f"\nf({x}) = {a}^{x}\nf({x}) = {f}")

def graficoFuncaoX(a, x, calc):
    f = a ** x
    plt.plot(x, f)
    plt.title(calc)
    plt.grid()
    plt.show()

def criarMatriz(nLinhas, nColunas):
    matriz = []
    for i in range(0, nLinhas):
        lista = []
        for j in range(0, nColunas):
            numero = float(input(f"\nEscolha o número da posição {[i+1]} {[j+1]}: "))
            lista.append(numero)
        matriz.append(lista)
    return matriz

def gerarMatriz(matriz, nLinhas):
    for i in range(0, nLinhas):
        print(matriz[i])

def calcularDeterminante(matriz):
    if linhasA == 2 and colunasA == 2:
        determinante = matriz[0][0] * matriz[1][1] - (matriz[0][1] * matriz[1][0])
        return print(f"\nO valor do determinante é: {determinante}")
    elif linhasA == 3 and colunasA == 3:
        determinante = (matriz[0][0] * matriz[1][1] * matriz[2][2]) + \
                    (matriz[0][1] * matriz[1][2] * matriz[2][0]) + \
                    (matriz[0][2] * matriz[1][0] * matriz[2][1]) - \
                    (matriz[2][0] * matriz[1][1] * matriz[0][2]) - \
                    (matriz[2][1] * matriz[1][2] * matriz[0][0]) - \
                    (matriz[2][2] * matriz[1][0] * matriz[0][1])
        return print(f"\nO valor do determinante é: {determinante}")
    else:
        return print(f"\nNecessário ser uma matriz quadrada 2x2 ou 3x3")

def calcularMultiplicaçãoAxB(matriz, matriz2):
    ordemResultado = [
        [0 for _ in range(len(matriz2[0]))] for _ in range(len(matriz))
    ] 
    for i in range(len(matriz)):
        for j in range(len(matriz2[0])):
            for k in range(len(matriz2)):
                ordemResultado[i][j] += matriz[i][k] * matriz2[k][j]
    return ordemResultado

def matrizTransposta(matriz):
    matrizT = []
    for i in range (0, colunasA):
        linha = []
        for j in range (0, linhasA):
            linha.append(0)
        matrizT.append(linha)
    for i in range (0, linhasA):
        for j in range (0, colunasA):
            matrizT[j][i] = matriz[i][j]
    for i in range(0, len(matrizT)):
        print(matrizT[i])

while True:
    op = menu()
    if op == 5:
        print(f"\nSaindo da Calculadora...\n")
        break
    elif op == 1:
        a = []
        numeroDaListaA = int(input("\nEscolha a quantidade de números do conjunto A: "))
        for i in range(0, numeroDaListaA):
            numA = float(input(f"\nEscolha um número {[i+1]}: "))
            a.append(numA)
        b = []
        numeroDaListaB = int(input("\nEscolha a quantidade de números do conjunto B: "))
        for i in range(0, numeroDaListaB):
            numB = float(input(f"\nEscolha um número {[i+1]}: "))
            b.append(numB)
        while True:
            print(f"\nConjunto A: {a}")
            print(f"Conjunto B: {b}")
            co = menuConjunto()
            if co == 5:
                print(f"\nVoltando...")
                break
            elif co == 1:
                subconjunto(a, b)
            elif co == 2:
                print(f"\nA união dos conjuntos A e B resulta em: {uniaoInterseccaoDiferenca(a, b, 1)}")
            elif co == 3:
                print(f"\nA intersecção dos conjuntos A e B resulta em: {uniaoInterseccaoDiferenca(a, b, 2)}")
            elif co == 4:
                uniaoInterseccaoDiferenca(a, b, 3)
        continue
    elif op == 2:
        fa = float(input(f"\nDigite o valor de a, na função f(x) = ax^2 + bx + c: "))
        fb = float(input(f"\nDigite o valor de b, na função f(x) = ax^2 + bx + c: "))
        fc = float(input(f"\nDigite o valor de c, na função f(x) = ax^2 + bx + c: "))
        while True:
            print(f"\nf(x) = {fa}x^2 + {fb}x + {fc}")
            fx = menuFuncaoSegundoGrau()
            if fx == 5:
                print(f"\nVoltando...")
                break
            elif fx == 1:
                calcularRaiz(fa, fb, fc)
            elif fx == 2:
                x = float(input(f"\nDigite o valor de x: "))
                resolverFuncao(fa, fb, fc, x)
            elif fx == 3:
                calculoVertice(fa, fb, fc)
            elif fx == 4:
                x = np.linspace(-100,100)
                graficoFuncaoSegundoGrau(fa, fb, fc, x, calculoVertice(fa, fb, fc))
        continue
    elif op == 3:
        while True:
            fxa = float(input("\nDigite o valor de a na função f(x) = a^x: "))
            if fxa > 0 and fxa != 1:
                break
            else:
                print("\nFunção inexistente, escolha outro valor")
                continue
        while True:
            fe = menuFuncaoExponencial()
            if fe == 4:
                print(f"\nVoltando...")
                break
            elif fe == 1:
                verificarCrescenteDescrescente(fxa)
            elif fe == 2:
                xf = float(input(f"\nDigite o valor de x na função f(x) = {fxa}^x"))
                calcularFuncaoX(fxa, xf)
            elif fe == 3:
                xf = np.linspace(-100,100)
                graficoFuncaoX(fxa, xf, calcularFuncaoX(fxa, xf))
        continue
    elif op == 4:
        linhasA = int(input(f"\nInforme o numero de linhas da matriz A: "))
        colunasA = int(input(f"\nInforme o numero de colunas da matriz A: "))
        m = criarMatriz(linhasA, colunasA)
        while True:
            print(f"\nMatriz:")
            gerarMatriz(m, linhasA)
            ma = menuMatriz()
            if ma == 4:
                print(f"\nVoltando...")
                break
            elif ma == 1:
                calcularDeterminante(m)
            elif ma == 2:
                while True:
                    linhasB = int(input(f"\nInforme o numero de linhas da matriz B: "))
                    if linhasB != colunasA:
                        print("O numero de linhas da matriz B tem que ser igual o número de colunas da matriz A")
                        continue
                    else:
                        break
                colunasB = int(input(f"\nInforme o numero de colunas da matriz B: "))
                m2 = criarMatriz(linhasB, colunasB)
                print(f"\nMatriz A:")
                gerarMatriz(m, linhasA)
                print(f"\nMatriz B:")
                gerarMatriz(m2, linhasB)
                print(f"\nMultiplicação de A x B:")
                calcularMultiplicaçãoAxB(m, m2)
                gerarMatriz(calcularMultiplicaçãoAxB(m, m2), linhasB)
            elif ma == 3:
                print(f"\nMatriz Transposta:")
                matrizTransposta(m)
        continue