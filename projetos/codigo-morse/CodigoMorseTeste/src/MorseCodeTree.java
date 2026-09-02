import java.util.*;

// classe principal que monta e gerencia a arvore de morse
public class MorseCodeTree {
    private MorseNode raiz; // o nó raiz da arvore (começa vazio)

    // tabela com os códigos morse oficiais (peguei da ITU, é o padrão internacional)
    // HashMap é tipo um dicionário, procura super rápido
    private static final Map<Character, String> TABELA_MORSE = new HashMap<Character, String>() {{
        // letras A-Z com seus códigos
        put('A', ".-");    put('B', "-...");  put('C', "-.-.");  put('D', "-..");
        put('E', ".");     put('F', "..-.");  put('G', "--.");   put('H', "....");
        put('I', "..");    put('J', ".---");  put('K', "-.-");   put('L', ".-..");
        put('M', "--");    put('N', "-.");    put('O', "---");   put('P', ".--.");
        put('Q', "--.-");  put('R', ".-.");   put('S', "...");   put('T', "-");
        put('U', "..-");   put('V', "...-");  put('W', ".--");   put('X', "-..-");
        put('Y', "-.--");  put('Z', "--..");
        // numeros 0-9 também tem morse
        put('0', "-----"); put('1', ".----"); put('2', "..---"); put('3', "...--");
        put('4', "....-"); put('5', "....."); put('6', "-...."); put('7', "--...");
        put('8', "---.."); put('9', "----.");
    }};

    // construtor - cria a raiz e já monta a arvore inteira
    public MorseCodeTree() {
        raiz = new MorseNode('\0'); // \0 = caractere vazio
        construirArvore(); // chama o método que bota tudo na arvore
    }

    // esse método percorre a tabela e insere cada letra na arvore
    private void construirArvore() {
        // pra cada par (letra, codigo) na tabela
        for (Map.Entry<Character, String> entry : TABELA_MORSE.entrySet()) {
            inserir(entry.getKey(), entry.getValue()); // insere na arvore
        }
    }

    // insere um caractere na arvore seguindo o codigo morse
    // ponto vai pra esquerda, traço vai pra direita
    public void inserir(char c, String codigo) {
        MorseNode atual = raiz; // começa na raiz

        // percorre cada simbolo do codigo (. ou -)
        for (char simbolo : codigo.toCharArray()) {
            if (simbolo == '.') {
                // ponto = vai pra esquerda
                if (atual.esquerda == null) atual.esquerda = new MorseNode('\0');
                atual = atual.esquerda;
            } else {
                // traço = vai pra direita
                if (atual.direita == null) atual.direita = new MorseNode('\0');
                atual = atual.direita;
            }
        }
        // quando chegar no final do caminho, bota o caractere ali
        atual.caractere = c;
    }

    // transforma texto normal em codigo morse
    // exemplo: "SOS" vira "... --- ..."
    public String codificar(String texto) {
        StringBuilder morse = new StringBuilder(); // pra concatenar strings rápido

        // pra cada letra do texto (converte pra maiúscula antes)
        for (char c : texto.toUpperCase().toCharArray()) {
            if (c == ' ') {
                // espaço vira " / " no morse
                morse.append(" / ");
            } else if (TABELA_MORSE.containsKey(c)) {
                // pega o codigo da tabela e adiciona um espaço depois
                morse.append(TABELA_MORSE.get(c)).append(" ");
            }
        }
        return morse.toString().trim(); // remove espaços extras no final
    }

    // transforma codigo morse em texto normal
    // exemplo: "... --- ..." vira "SOS"
    public String decodificar(String morse) {
        StringBuilder texto = new StringBuilder();

        // divide em palavras (separadas por " / ")
        for (String palavra : morse.split(" / ")) {
            // divide cada palavra em letras (separadas por espaço)
            for (String codigo : palavra.trim().split(" ")) {
                if (!codigo.isEmpty()) {
                    char c = decodificarLetra(codigo); // decodifica uma letra
                    if (c != '\0') texto.append(c);
                }
            }
            texto.append(" "); // adiciona espaço entre palavras
        }
        return texto.toString().trim();
    }

    // decodifica uma única letra em morse
    // navega pela arvore seguindo o codigo
    private char decodificarLetra(String codigo) {
        MorseNode atual = raiz;

        // percorre o codigo
        for (char simbolo : codigo.toCharArray()) {
            // ponto = esquerda, traço = direita
            atual = (simbolo == '.') ? atual.esquerda : atual.direita;
            if (atual == null) return '\0'; // caminho invalido
        }
        return atual.caractere; // retorna a letra que tá no nó
    }

    // imprime a arvore bonitinha no console
    // usei caracteres unicode pra ficar tipo aqueles comandos tree do linux
    public void imprimirArvore() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   Árvore Binária - Código Morse ITU   ║");
        System.out.println("╚════════════════════════════════════════╝");
        imprimirNoEstilo(raiz, "", "", true);
    }

    // método recursivo pra imprimir cada nó com estilo
    private void imprimirNoEstilo(MorseNode no, String prefixo, String tipo, boolean isRaiz) {
        if (no == null) return; // nó vazio, para aqui

        if (isRaiz) {
            System.out.println("    ROOT"); // imprime a raiz
        } else {
            // mostra o caractere ou [ ] se tiver vazio
            String valor = no.caractere != '\0' ? " [" + no.caractere + "] " : " [ ] ";
            System.out.println(prefixo + tipo + valor);
        }

        // imprime os filhos recursivamente
        if (no.esquerda != null || no.direita != null) {
            if (no.esquerda != null) {
                // filho esquerdo (ponto)
                String novoPrefixo = isRaiz ? "    " : prefixo + (no.direita != null ? "│   " : "    ");
                imprimirNoEstilo(no.esquerda, novoPrefixo, "├─(.)─", false);
            }
            if (no.direita != null) {
                // filho direito (traço)
                String novoPrefixo = isRaiz ? "    " : prefixo + "    ";
                imprimirNoEstilo(no.direita, novoPrefixo, "└─(-)─", false);
            }
        }
    }

    // imprime a arvore nivel por nivel (tipo uma BFS)
    // nivel 0 = raiz, nivel 1 = E e T, nivel 2 = I,A,N,M, etc
    public void imprimirPorNiveis() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║    Travessia por Níveis (Level-Order) ║");
        System.out.println("╚════════════════════════════════════════╝");

        // usa uma fila pra fazer BFS (busca em largura)
        Queue<ParNivel> fila = new LinkedList<>();
        fila.offer(new ParNivel(raiz, 0)); // começa com a raiz no nivel 0
        int nivelAtual = -1;

        // enquanto tiver nó na fila
        while (!fila.isEmpty()) {
            ParNivel par = fila.poll(); // pega o primeiro da fila

            // se mudou de nivel, pula linha
            if (par.nivel != nivelAtual) {
                if (nivelAtual != -1) System.out.println();
                System.out.print("Nível " + par.nivel + ": ");
                nivelAtual = par.nivel;
            }

            // imprime o caractere (ou _ se vazio)
            char exibir = par.no.caractere != '\0' ? par.no.caractere : '_';
            System.out.print(exibir + " ");

            // adiciona os filhos na fila pro próximo nivel
            if (par.no.esquerda != null) fila.offer(new ParNivel(par.no.esquerda, par.nivel + 1));
            if (par.no.direita != null) fila.offer(new ParNivel(par.no.direita, par.nivel + 1));
        }
        System.out.println("\n");
    }

    // classe auxiliar pra guardar o nó e o nivel dele
    // usei isso pra fazer a BFS funcionar
    private static class ParNivel {
        MorseNode no;
        int nivel;

        ParNivel(MorseNode no, int nivel) {
            this.no = no;
            this.nivel = nivel;
        }
    }

    // retorna a altura da arvore (quantos niveis tem)
    public int getAltura() {
        return calcularAltura(raiz);
    }

    // calcula a altura recursivamente
    private int calcularAltura(MorseNode no) {
        if (no == null) return -1; // nó vazio = altura -1
        // altura = 1 + maior altura entre esquerda e direita
        return 1 + Math.max(calcularAltura(no.esquerda), calcularAltura(no.direita));
    }

    // conta quantos nós tem na arvore toda
    public int getTotalNos() {
        return contarNos(raiz);
    }

    // conta recursivamente
    private int contarNos(MorseNode no) {
        if (no == null) return 0; // nó vazio = 0
        // 1 (esse nó) + nós da esquerda + nós da direita
        return 1 + contarNos(no.esquerda) + contarNos(no.direita);
    }
}