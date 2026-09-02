print('atividade 5')

sexo = str(input('Digite o seu Sexo (Masculino ou Feminino): '))
altura = float(input('Digite sua altura com . : '))

if sexo == 'Masculino':
    pesoIdeal = (72.7*altura)-58
    print(f'Seu peso ideal é:{pesoIdeal:.2f}')
if sexo == 'Feminino':
    pesoIdeal = (62.1*altura)-44.7
    print(f'Seu peso ideal é:{pesoIdeal:.2f}')