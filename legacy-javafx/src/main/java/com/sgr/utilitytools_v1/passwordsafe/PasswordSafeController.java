package com.sgr.utilitytools_v1.passwordsafe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class PasswordSafeController implements Initializable {

    @FXML private AnchorPane LoginSenha;
    @FXML private AnchorPane Cofre;
    @FXML private Pane senhaAdd;
    @FXML private ListView listaSenhas;
    @FXML private TextField lblSenha;
    @FXML private TextField lblUsuario;
    @FXML private TextField name;
    @FXML private TextField senha;

    private final ObservableList<String> senhas = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    LoginSenha.setVisible(true);
    Cofre.setVisible(false);
        senhaAdd.setVisible(false);

    }



    public void entrarCofre(){
        senhaAdd.setVisible(false);

        if(lblUsuario.getText().equals("thay") && (lblSenha.getText().equals("thay3"))){
            System.out.println("Login realizado com sucesso");
            LoginSenha.setVisible(false);
            Cofre.setVisible(true);
        } else {
            System.out.println("Tente novamente");
        }
    }

    public void abrirSenha(){
        senhaAdd.setVisible(true);
    }

    public void salvarSenha(){
        senhas.add(String.format("%s - %s", name.getText(), senha.getText()));
        listaSenhas.setItems(senhas);
        senhaAdd.setVisible(false);
        name.clear();
        senha.clear();
    }

    public void cancelar(){
        senhaAdd.setVisible(false);
    }

    public void remover() {
    int select = listaSenhas.getSelectionModel().getSelectedIndex();
        senhas.remove(select);
    }

    public void editar(){
        int itemID = listaSenhas.getSelectionModel().getSelectedIndex();

        abrirSenha();

        senhas.set(itemID, String.format("%s - %s", name.getText(), senha.getText()));


    }
}
