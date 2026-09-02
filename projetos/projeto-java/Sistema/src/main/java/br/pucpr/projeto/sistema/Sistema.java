package br.pucpr.projeto.sistema;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Sistema extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        new TelaLogin().telaInicial();
    }

    public static void main(String[] args) {

        Administrador admin = new Administrador(
                0,
                "Admin",
                "Master",
                "admin@admin.com",
                "admin",// login
                "1234",// senha
                "0000-0000",
                "Endereço",
                "100",
                "000.000.000-00"
        );

        PersistenciaUtils.carregarClientesDat();
        PersistenciaUtils.carregarLojasDat();
        PersistenciaUtils.carregarPromocoesDat();
        PersistenciaUtils.carregarDenunciasDat();

        launch();
    }
}