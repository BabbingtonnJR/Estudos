import java.util.Scanner;

class Menu {
    private Scanner scanner;
    private TabelaHash cardapio;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.cardapio = new TabelaHash(10);
        inicializarPratos();
    }

    // adiciona alguns pratos iniciais para teste
    private void inicializarPratos() {
        cardapio.inserir(new Prato("Feijoada", 35.90, 45));
        cardapio.inserir(new Prato("Lasanha", 28.50, 30));
        cardapio.inserir(new Prato("Pizza Margherita", 42.00, 25));
        cardapio.inserir(new Prato("Strogonoff", 32.00, 35));
        cardapio.inserir(new Prato("Picanha", 65.00, 40));

        cardapio.inserir(new Prato("Marcarrão", 22.90, 35));
        cardapio.inserir(new Prato("Cachorro Quente", 18.50, 20));
        cardapio.inserir(new Prato("Hambueguer", 30.00, 30));
        cardapio.inserir(new Prato("Suco de Maracujá", 12.00, 10));
        cardapio.inserir(new Prato("Vinho", 45.00, 30));
    }

    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    inserirPrato();
                    break;
                case 2:
                    buscarPrato();
                    break;
                case 3:
                    removerPrato();
                    break;
                case 4:
                    cardapio.exibir();
                    break;
                case 5:
                    menuOrdenacao(); // chama o menu de ordenação
                    break;
                case 0:
                    System.out.println("\nSistema encerrado. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }

            if (opcao != 0) {
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n═══════════════════════════════════════");
        System.out.println("   CARDÁPIO DIGITAL - RESTAURANTE");
        System.out.println("═══════════════════════════════════════");
        System.out.println("1. Inserir novo prato");
        System.out.println("2. Buscar prato");
        System.out.println("3. Remover prato");
        System.out.println("4. Exibir cardápio completo");
        System.out.println("5. Ordenar e exibir cardápio");
        System.out.println("0. Sair");
        System.out.println("───────────────────────────────────────");
        System.out.print("Escolha uma opção: ");
    }

    private void inserirPrato() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║     INSERIR NOVO PRATO          ║");
        System.out.println("╚══════════════════════════════════╝");

        System.out.print("Nome do prato: ");
        String nome = scanner.nextLine();

        System.out.print("Preço (R$): ");
        double preco = scanner.nextDouble();

        System.out.print("Tempo de preparo (minutos): ");
        int tempo = scanner.nextInt();
        scanner.nextLine();

        Prato novoPrato = new Prato(nome, preco, tempo);
        cardapio.inserir(novoPrato);
    }

    private void buscarPrato() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║        BUSCAR PRATO             ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.print("Nome do prato: ");
        String nome = scanner.nextLine();

        Prato prato = cardapio.buscar(nome);

        if (prato != null) {
            System.out.println("\n✓ Prato encontrado:");
            System.out.println(prato);
        } else {
            System.out.println("\n✗ Prato não encontrado no cardápio.");
        }
    }

    private void removerPrato() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║       REMOVER PRATO             ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.print("Nome do prato: ");
        String nome = scanner.nextLine();

        if (cardapio.remover(nome)) {
            System.out.println("\n✓ Prato removido com sucesso!");
        } else {
            System.out.println("\n✗ Prato não encontrado no cardápio.");
        }
    }

    // menu para escolher o critério de ordenação e o algoritmo
    private void menuOrdenacao() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║   ORDENAR E EXIBIR CARDÁPIO         ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Ordenar por:");
        System.out.println("1. Nome (A-Z)");
        System.out.println("2. Preço (menor → maior)");
        System.out.println("3. Tempo de preparo (mais rápido → mais demorado)");
        System.out.print("Escolha: ");

        int criterio = scanner.nextInt();
        scanner.nextLine();

        if (criterio < 1 || criterio > 3) {
            System.out.println("\n✗ Opção inválida!");
            return;
        }

        System.out.println("\nEscolha o algoritmo de ordenação:");
        System.out.println("1. BubbleSort");
        System.out.println("2. InsertionSort");
        System.out.println("3. QuickSort");
        System.out.print("Escolha: ");

        int algoritmo = scanner.nextInt();
        scanner.nextLine();

        if (algoritmo < 1 || algoritmo > 3) {
            System.out.println("\n✗ Opção inválida!");
            return;
        }

        // converte a tabela hash para um array comum
        Prato[] pratos = cardapio.exportarParaVetor();

        if (pratos.length == 0) {
            System.out.println("\n✗ Cardápio vazio! Adicione pratos primeiro.");
            return;
        }

        // marca o tempo inicial
        long tempoInicio = System.nanoTime();

        // executa o algoritmo escolhido
        switch (algoritmo) {
            case 1:
                bubbleSort(pratos, criterio);
                System.out.println("\n✓ Ordenado com BubbleSort!");
                break;
            case 2:
                insertionSort(pratos, criterio);
                System.out.println("\n✓ Ordenado com InsertionSort!");
                break;
            case 3:
                quickSort(pratos, 0, pratos.length - 1, criterio);
                System.out.println("\n✓ Ordenado com QuickSort!");
                break;
        }

        // marca o tempo final e calcula a diferença
        long tempoFim = System.nanoTime();
        double tempoDecorrido = (tempoFim - tempoInicio) / 1_000_000.0;

        exibirPratosOrdenados(pratos, criterio, algoritmo, tempoDecorrido);
    }

    // bubble sort: compara pares de elementos adjacentes e troca se necessário
    // vai fazendo isso até o array ficar ordenado
    private void bubbleSort(Prato[] pratos, int criterio) {
        int n = pratos.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // se os elementos estão fora de ordem, troca
                if (comparar(pratos[j], pratos[j + 1], criterio) > 0) {
                    System.out.println("O pivo é: " + pratos[i]);
                    Prato temp = pratos[j];
                    pratos[j] = pratos[j + 1];
                    pratos[j + 1] = temp;
                }
            }
        }
    }

    // insertion sort: pega cada elemento e insere na posição correta
    // funciona bem para listas pequenas ou quase ordenadas
    private void insertionSort(Prato[] pratos, int criterio) {
        int n = pratos.length;

        for (int i = 1; i < n; i++) {
            Prato chave = pratos[i];
            System.out.println("O pivo é: " + chave);
            int j = i - 1;

            // move os elementos maiores uma posição para frente
            while (j >= 0 && comparar(pratos[j], chave, criterio) > 0) {
                pratos[j + 1] = pratos[j];
                j--;
            }

            pratos[j + 1] = chave;
        }
    }

    // quicksort: escolhe um pivô e divide o array em menores e maiores
    // depois ordena cada parte recursivamente
    private void quickSort(Prato[] pratos, int inicio, int fim, int criterio) {
        if (inicio < fim) {
            // encontra a posição final do pivô
            int indicePivo = particionar(pratos, inicio, fim, criterio);
            System.out.println("O pivo é: " + pratos[indicePivo]);
            // ordena a parte esquerda (elementos menores)
            quickSort(pratos, inicio, indicePivo - 1, criterio);

            // ordena a parte direita (elementos maiores)
            quickSort(pratos, indicePivo + 1, fim, criterio);
        }
    }

    // particiona o array: coloca elementos menores antes do pivô
    // e elementos maiores depois do pivô
    private int particionar(Prato[] pratos, int inicio, int fim, int criterio) {
        Prato pivo = pratos[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (comparar(pratos[j], pivo, criterio) <= 0) {
                i++;
                // troca os elementos
                Prato temp = pratos[i];
                pratos[i] = pratos[j];
                pratos[j] = temp;
            }
        }

        // coloca o pivô na posição correta
        Prato temp = pratos[i + 1];
        pratos[i + 1] = pratos[fim];
        pratos[fim] = temp;

        return i + 1;
    }

    // compara dois pratos de acordo com o critério escolhido
    // retorna valor negativo se p1 < p2, positivo se p1 > p2, zero se iguais
    private int comparar(Prato p1, Prato p2, int criterio) {
        switch (criterio) {
            case 1: // ordenar por nome
                return p1.getNome().compareToIgnoreCase(p2.getNome());

            case 2: // ordenar por preço
                return Double.compare(p1.getPreco(), p2.getPreco());

            case 3: // ordenar por tempo de preparo
                return p1.getTempoPreparo() - p2.getTempoPreparo();

            default:
                return 0;
        }
    }

    // exibe os pratos já ordenados com informações sobre a ordenação
    private void exibirPratosOrdenados(Prato[] pratos, int criterio, int algoritmo, double tempo) {
        String[] criterios = {"", "Nome", "Preço", "Tempo de Preparo"};
        String[] algoritmos = {"", "BubbleSort", "InsertionSort", "QuickSort"};

        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║         CARDÁPIO ORDENADO                         ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("Ordenado por: " + criterios[criterio]);
        System.out.println("Algoritmo: " + algoritmos[algoritmo]);
        System.out.printf("Tempo de execução: %.4f ms\n", tempo);
        System.out.println("────────────────────────────────────────────────────");
        System.out.println("Nome do Prato            | Preço     | Tempo");
        System.out.println("────────────────────────────────────────────────────");

        for (Prato prato : pratos) {
            System.out.println(prato);
        }

        System.out.println("────────────────────────────────────────────────────");
        System.out.println("Total de pratos: " + pratos.length);
    }
}