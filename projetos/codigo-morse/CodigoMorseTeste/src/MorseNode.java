// classe simples pro nó da arvore, cada nó guarda uma letra
public class MorseNode {
    char caractere;      // a letra que fica no nó (tipo 'A', 'S', etc)
    MorseNode esquerda;  // filho da esquerda = ponto (.)
    MorseNode direita;   // filho da direita = traço (-)

    // construtor básico, só inicializa o caractere
    public MorseNode(char caractere) {
        this.caractere = caractere;
        // esquerda e direita já começam null automaticamente
    }
}