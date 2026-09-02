print('atividade 8')

idade = int(input('Digite sua idade: '))

if idade >= 16 and idade <= 17 or idade > 65:
    print('Eleitor facultativo')
elif idade >= 18:
    print('Eleitor obrigatório')
else:
    print('Não eleitor')