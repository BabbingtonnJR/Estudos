print('atividade 4')

nota = float(input('Digite a sua nota: '))

if nota >= 7:
    print('Estudante aprovado')
elif nota >= 4 and nota < 7:
    print('Estudante em recuperação')
elif nota < 4:
    print('Estudante reprovado')