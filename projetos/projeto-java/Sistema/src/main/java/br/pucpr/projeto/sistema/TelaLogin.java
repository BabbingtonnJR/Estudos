package br.pucpr.projeto.sistema;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class TelaLogin {

    public void telaInicial() {
        Stage stage = new Stage();
        stage.setTitle("PromoSearch");

        Label loginLBL = new Label("Login");
        loginLBL.setFont(new Font("Arial", 24));
        loginLBL.setAlignment(Pos.CENTER);

        Label user = new Label("Digite seu usuário");
        user.setFont(new Font("Arial", 12));
        user.setAlignment(Pos.CENTER);

        TextField login = new TextField();
        login.setPrefWidth(250);
        login.setPrefHeight(30);
        login.setMaxWidth(250);
        login.setAlignment(Pos.CENTER);

        Label senhatxt = new Label("Digite sua senha");
        senhatxt.setFont(new Font("Arial", 12));
        senhatxt.setAlignment(Pos.CENTER);

        PasswordField senha = new PasswordField();
        senha.setPrefWidth(250);
        senha.setPrefHeight(30);
        senha.setMaxWidth(250);
        senha.setAlignment(Pos.CENTER);

        Button entrar = new Button("Entrar");
        entrar.setOnAction(e -> {
            String loginDigitado = login.getText().trim();
            String senhaDigitada = senha.getText().trim();

            // Verificação de administrador
            if (loginDigitado.equals("admin") && senhaDigitada.equals("1234")) {
                stage.close();
                new TelaAdministrador().telaInicial();
                return;
            }

            // Carrega dados dos clientes e lojas
            PersistenciaUtils.carregarClientesDat();
            PersistenciaUtils.carregarLojasDat();

            // Verificação de cliente
            for (Cliente cliente : RepositorioUsuarios.clientes) {
                if (cliente.getLogin().equals(loginDigitado) && cliente.getSenha().equals(senhaDigitada)) {
                    new TelaCliente(cliente).telaInicial();
                    stage.close();
                    return;
                }
            }

            // Verificação de loja
            for (Loja loja : RepositorioUsuarios.lojas) {
                if (loja.getLogin().equals(loginDigitado) && loja.getSenha().equals(senhaDigitada)) {
                    new TelaLoja(loja).telaInicial();
                    stage.close();
                    return;
                }
            }

            // Se chegar até aqui (nenhum login válido), mostra alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro de Login");
            alerta.setHeaderText(null);
            alerta.setContentText("Login ou senha inválidos.");
            alerta.showAndWait();
        });

        Button cadastrar = new Button("Cadastrar");
        cadastrar.setOnAction(e -> new TelaCadastro().selecao());

        VBox layout = new VBox(10, loginLBL, user, login, senhatxt, senha, entrar, cadastrar);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 1000, 1000);
        stage.setScene(scene);
        stage.show();
    }
}
