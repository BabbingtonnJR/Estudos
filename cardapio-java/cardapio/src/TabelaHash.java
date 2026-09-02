public class TabelaHash {
    private No[] tabela;
    private int tamanho;
    private int quantidade;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new No[tamanho];
        this.quantidade = 0;
    }

    // função hash: transforma o nome do prato em um índice da tabela
    // soma os valores ASCII dos caracteres e calcula o resto da divisão
    private int funcaoHash(String chave) {
        int hash = 0;

        for (int i = 0; i < chave.length(); i++) {
            hash += chave.charAt(i);
        }

        return hash % tamanho;
    }

    // insere um prato na tabela hash
    // se houver colisão, adiciona no final da lista encadeada
    public void inserir(Prato prato) {
        int indice = funcaoHash(prato.getNome());
        No novoNo = new No(prato);

        if (tabela[indice] == null) {
            // posição vazia, adiciona direto
            tabela[indice] = novoNo;
        } else {
            // colisão: percorre até o final da lista e adiciona
            No atual = tabela[indice];
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }

        quantidade++;
        System.out.println("\n✓ Prato inserido com sucesso!");
    }

    // busca um prato pelo nome
    // retorna o prato se encontrado, ou null se não encontrado
    public Prato buscar(String nome) {
        int indice = funcaoHash(nome);
        No atual = tabela[indice];

        // percorre a lista encadeada nesse índice
        while (atual != null) {
            if (atual.prato.getNome().equalsIgnoreCase(nome)) {
                return atual.prato;
            }
            atual = atual.proximo;
        }

        return null;
    }

    // remove um prato da tabela
    // retorna true se removeu, false se não encontrou
    public boolean remover(String nome) {
        int indice = funcaoHash(nome);
        No atual = tabela[indice];
        No anterior = null;

        while (atual != null) {
            if (atual.prato.getNome().equalsIgnoreCase(nome)) {

                if (anterior == null) {
                    // remove o primeiro elemento da lista
                    tabela[indice] = atual.proximo;
                } else {
                    // remove do meio ou fim da lista
                    anterior.proximo = atual.proximo;
                }

                quantidade--;
                return true;
            }

            anterior = atual;
            atual = atual.proximo;
        }

        return false;
    }

    // exibe todos os pratos cadastrados na tabela
    public void exibir() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║           CARDÁPIO COMPLETO                       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        System.out.println("Nome do Prato            | Preço     | Tempo");
        System.out.println("────────────────────────────────────────────────────");

        for (int i = 0; i < tamanho; i++) {
            No atual = tabela[i];

            // percorre a lista encadeada de cada índice
            while (atual != null) {
                System.out.println(atual.prato);
                atual = atual.proximo;
            }
        }

        System.out.println("────────────────────────────────────────────────────");
        System.out.println("Total de pratos: " + quantidade);
    }

    // converte a tabela hash para um array simples
    // necessário para poder ordenar os elementos
    public Prato[] exportarParaVetor() {
        Prato[] pratos = new Prato[quantidade];
        int indiceVetor = 0;

        // percorre todos os índices da tabela
        for (int i = 0; i < tamanho; i++) {
            No atual = tabela[i];

            // percorre a lista encadeada de cada índice
            while (atual != null) {
                pratos[indiceVetor] = atual.prato;
                indiceVetor++;
                atual = atual.proximo;
            }
        }

        return pratos;
    }

    public int getQuantidade() {
        return quantidade;
    }
}