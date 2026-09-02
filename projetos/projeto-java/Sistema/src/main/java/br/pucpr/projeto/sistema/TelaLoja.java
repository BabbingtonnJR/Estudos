package br.pucpr.projeto.sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaLoja {
    private Loja loja;

    public TelaLoja(Loja loja) {
        this.loja = loja;
    }

    public void telaInicial() {
        Stage stage = new Stage();
        stage.setTitle("Tela da Loja: " + loja.getNome());

        Label label = new Label("Bem-vindo, " + loja.getNome());
        label.setFont(new Font("Arial", 20));
        label.setAlignment(Pos.CENTER);

        Button btnCriarPromocao = new Button("Criar Promoção");
        btnCriarPromocao.setOnAction(e -> abrirFormularioPromocao(stage));

        Button sair = new Button("Sair");
        sair.setOnAction(e -> {
            stage.close();
            new TelaLogin().telaInicial(); // Volta para a tela de login
        });

        VBox layout = new VBox(20, label, btnCriarPromocao, sair);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));


        Label promoTitulo = new Label("Suas promoções:");
        promoTitulo.setFont(new Font("Arial", 16));
        layout.getChildren().add(promoTitulo);

        VBox listaPromocoes = new VBox(10);
        for (Promocao promo : RepositorioUsuarios.promocoes) {
            if (promo.getIdLoja() == loja.getId()) {
                Label lblPromo = new Label(
                        "Produto: " + promo.getNomeProduto()
                                + " | De: R$" + promo.getPrecoInicial()
                                + " por: R$" + promo.getPrecoPromocional()
                                + " | Quantidade: " + promo.getQuantidade()
                                + " | Tipo: " + promo.getTipo()
                );

                Button btnEditar = new Button("Editar");
                btnEditar.setOnAction(e -> editarPromocao(promo, stage)); // criar função se quiser

                Button btnExcluir = new Button("Excluir");
                btnExcluir.setOnAction(e -> {
                    RepositorioUsuarios.promocoes.remove(promo);
                    PersistenciaUtils.salvarPromocoesDat();
                    stage.close();
                    telaInicial(); // recarrega
                });

                HBox linha = new HBox(10, lblPromo, btnEditar, btnExcluir);
                linha.setAlignment(Pos.CENTER_LEFT);
                listaPromocoes.getChildren().add(linha);
            }
        }

        layout.getChildren().add(listaPromocoes);

        Scene scene = new Scene(layout, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void abrirFormularioPromocao(Stage stagePrincipal) {
        Stage formStage = new Stage();
        formStage.setTitle("Nova Promoção");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        TextField tfNome = new TextField();
        TextField tfPrecoInicial = new TextField();
        TextField tfPrecoPromo = new TextField();
        TextField tfQuantidade = new TextField();
        TextField tfTipo = new TextField();

        Label msgLabel = new Label();

        Button btnSalvar = new Button("Salvar");
        Button voltar = new Button("Voltar");

        btnSalvar.setOnAction(ev -> {
            try {
                String nome = tfNome.getText();
                double precoInicial = Double.parseDouble(tfPrecoInicial.getText());
                double precoPromo = Double.parseDouble(tfPrecoPromo.getText());
                int qtd = Integer.parseInt(tfQuantidade.getText());
                String tipo = tfTipo.getText();

                Promocao nova = new Promocao(nome, loja.getId(), precoInicial, precoPromo, qtd, tipo);
                RepositorioUsuarios.promocoes.add(nova);
                PersistenciaUtils.salvarPromocoesDat();

                msgLabel.setText("Promoção criada com sucesso!");
                limparCampos(tfNome, tfPrecoInicial, tfPrecoPromo, tfQuantidade, tfTipo);

                formStage.close();
                stagePrincipal.close();
                telaInicial();

            } catch (NumberFormatException ex) {
                msgLabel.setText("Erro: verifique os valores numéricos.");
            }
        });

        voltar.setOnAction(e -> formStage.close());

        layout.getChildren().addAll(
                new Label("Nome do produto:"), tfNome,
                new Label("Preço original:"), tfPrecoInicial,
                new Label("Preço promocional:"), tfPrecoPromo,
                new Label("Quantidade:"), tfQuantidade,
                new Label("Tipo da promoção:"), tfTipo,
                btnSalvar, voltar, msgLabel
        );

        formStage.setScene(new Scene(layout, 300, 415));
        formStage.show();
    }


    private void limparCampos(TextField... fields) {
        for (TextField tf : fields) {
            tf.clear();
        }
    }

    private void editarPromocao(Promocao promo, Stage stagePrincipal) {
        Stage editStage = new Stage();
        editStage.setTitle("Editar Promoção");

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        TextField tfNome = new TextField(promo.getNomeProduto());
        TextField tfPrecoInicial = new TextField(String.valueOf(promo.getPrecoInicial()));
        TextField tfPrecoPromo = new TextField(String.valueOf(promo.getPrecoPromocional()));
        TextField tfQuantidade = new TextField(String.valueOf(promo.getQuantidade()));
        TextField tfTipo = new TextField(promo.getTipo());

        Button salvar = new Button("Salvar");
        Button voltar = new Button("Voltar");

        salvar.setOnAction(e -> {
                promo.setNomeProduto(tfNome.getText());
                promo.setPrecoInicial(Double.parseDouble(tfPrecoInicial.getText()));
                promo.setPrecoPromocional(Double.parseDouble(tfPrecoPromo.getText()));
                promo.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
                promo.setTipo(tfTipo.getText());

                PersistenciaUtils.salvarPromocoesDat();
                editStage.close();
                stagePrincipal.close();
                telaInicial(); // recarrega
        });

        voltar.setOnAction(e -> editStage.close());

        layout.getChildren().addAll(
                new Label("Nome do produto:"), tfNome,
                new Label("Preço original:"), tfPrecoInicial,
                new Label("Preço promocional:"), tfPrecoPromo,
                new Label("Quantidade:"), tfQuantidade,
                new Label("Tipo da promoção:"), tfTipo,
                salvar, voltar
        );

        editStage.setScene(new Scene(layout, 300, 415));
        editStage.show();
    }
}
