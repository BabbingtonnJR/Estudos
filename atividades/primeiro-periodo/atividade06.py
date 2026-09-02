print('atividade 6')

numero = float(input('Digite um número: '))
calculo = numero % 2

if calculo == 0:
    p = numero
    print(f'O número é par\n{p}')
else:
    i = numero
    print(f'O número é impar\n{i}')