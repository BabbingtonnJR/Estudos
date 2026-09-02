divisores = []
num = int(input('Digite um numero: '))
for i in range(1, num + 1):
    if num % i == 0:
        divisores.append(i)
print(divisores)