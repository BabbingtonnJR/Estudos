print('atividade 10')

universidade = int(input('Digite o código da sua universidade (1: PUCPR 2:UNICAMP): '))
nota1 = float(input('Digite a sua nota do primeiro bimestre: '))
nota2 = float(input('Digite a sua nota do segundo bimestre: '))
media = (nota1 + nota2)/2

if universidade == 1 and media >= 7:
    print('Estudante aprovado')
elif universidade == 1 and media >= 4 and media < 7:
    print('Estudante em recuperação')
elif universidade == 1 and media < 4:
    print('Estudante reprovado')

elif universidade == 2 and media >= 5:
    print('Estudante aprovado')
elif universidade == 2 and media < 5:
    print('Estudante em exame')