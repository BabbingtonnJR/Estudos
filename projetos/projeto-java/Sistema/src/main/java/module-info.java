module br.pucpr.projeto.sistema {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens br.pucpr.projeto.sistema to javafx.fxml;
    exports br.pucpr.projeto.sistema;
}