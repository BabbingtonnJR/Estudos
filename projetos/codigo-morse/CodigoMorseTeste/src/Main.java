import java.util.Scanner;

// classe principal que roda tudo
public class Main {
    public static void main(String[] args) {
        // cria a arvore de morse
        MorseCodeTree arvore = new MorseCodeTree();
        Scanner scanner = new Scanner(System.in);

        // titulo bonito com uns caracteres unicode
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║          SISTEMA DE CÓDIGO MORSE - ITU               ║");
        System.out.println("║    International Telecommunication Union Standard    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // mostra a arvore completa
        arvore.imprimirArvore();

        // mostra umas estatísticas da arvore (só pra deixar mais completo)
        System.out.println("┌─────────────────────────────────┐");
        System.out.println("│   Estatísticas da Árvore        │");
        System.out.println("├─────────────────────────────────┤");
        System.out.println("│ Altura: " + arvore.getAltura() + " níveis             │");
        System.out.println("│ Total de nós: " + arvore.getTotalNos() + " nós        │");
        System.out.println("└─────────────────────────────────┘");

        // faz uns testes automáticos de codificação
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║                  TESTES DE CODIFICAÇÃO               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // array com textos de teste
        String[] testesCodificacao = {"SOS", "HELLO WORLD", "JAVA 2025"};
        for (String texto : testesCodificacao) {
            String morse = arvore.codificar(texto); // codifica o texto
            System.out.println("✓ Texto: " + texto);
            System.out.println("  Morse: " + morse);
            System.out.println();
        }

        // agora testa a decodificação
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                TESTES DE DECODIFICAÇÃO               ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");

        // array com códigos morse pra testar
        String[] testesDecodificacao = {
                "... --- ...",                                    // SOS
                ".... . .-.. .-.. --- / .-- --- .-. .-.. -..",   // HELLO WORLD
                ".--- .- ...- .- / ..--- ----- ..--- ....."      // JAVA 2025
        };

        for (String morse : testesDecodificacao) {
            String texto = arvore.decodificar(morse); // decodifica
            System.out.println("✓ Morse: " + morse);
            System.out.println("  Texto: " + texto);
            System.out.println();
        }

        // mostra a arvore por niveis (tipo aquela travessia BFS que vimos na aula)
        arvore.imprimirPorNiveis();

        // modo interativo pra gente testar o que quiser
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║                   MODO INTERATIVO                    ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println("Digite 'sair' para encerrar\n");

        // loop infinito até o usuário digitar 'sair'
        while (true) {
            System.out.print("Digite um texto para codificar: ");
            String entrada = scanner.nextLine();

            // se digitar 'sair', para o programa
            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("\n✓ Programa encerrado. Até logo!");
                break;
            }

            // se digitou alguma coisa, codifica e depois decodifica pra conferir
            if (!entrada.trim().isEmpty()) {
                String morse = arvore.codificar(entrada);
                System.out.println("→ Morse: " + morse);
                System.out.println("→ Decodificado: " + arvore.decodificar(morse));
                System.out.println();
            }
        }

        scanner.close(); // fecha o scanner (boa prática)
    }
}