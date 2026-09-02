lista = [2, 4, 7, 2, 3, 3, 1, 0, 2, 6, 3]
num_freq = 0
num_repetido = 0
for i in lista:
    if lista.count(i) > num_freq:
        num_freq = lista.count(i)
        num_repetido = i
print(f'O numero que mais se repete é o {num_repetido} e se repetiu {num_freq} vezes')