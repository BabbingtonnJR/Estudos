print('atividade 9')

idade = int(input('Digite sua idade: '))
tempoDeServico = int(input('Digite quantos a anos você trabalha: '))

if idade >= 65 or tempoDeServico >= 30 or (idade >= 60 and tempoDeServico >= 25):
    print('Pode aposentar')
else:
    print('Não pode aposentar')