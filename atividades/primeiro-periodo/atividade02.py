print('atividade 2')

a = float(input('Digite o valor de a: '))
b = float(input('Digite o valor de b: '))
c = float(input('Digite o valor de c: '))

calculo = b**2 - (4*a*c)

if a != 0:
    if calculo > 0:
        print('existem duas raízes reais distintas')
    elif calculo < 0:
        print('existem duas raízes imaginárias conjugadas')
    elif calculo == 0:
        print('existem duas raízes reais iguais')
else:
    print('erro, a necessita ser diferente de 0')