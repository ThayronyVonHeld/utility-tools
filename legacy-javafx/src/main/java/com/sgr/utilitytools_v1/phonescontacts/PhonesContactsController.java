package com.sgr.utilitytools_v1.phonescontacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class PhonesContactsController implements Initializable {

    @FXML private Pane paineadd;
    @FXML private TextField name;
    @FXML private TextField telefone;
    @FXML private ChoiceBox<String> myChoiceBox;
    @FXML private ChoiceBox<String> atribuir;
    @FXML private ListView rj;
    @FXML private ListView sp;
    @FXML private ListView bh;
    @FXML private ListView bsb;

    private ObservableList<String> Rio = FXCollections.observableArrayList();
    private ObservableList<String> Sp = FXCollections.observableArrayList();
    private ObservableList<String> Minas = FXCollections.observableArrayList();
    private ObservableList<String> Bsb = FXCollections.observableArrayList();

    private String[] pracas = {"Rio de Janeiro", "São Paulo", "Belo Horizonte", "Brasília", "Outros"};


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(pracas);
        atribuir.getItems().addAll(pracas);
        paineadd.setVisible(false);

    myChoiceBox.setOnAction(this::getPraca);

    }

    private void getPraca(javafx.event.ActionEvent actionEvent) {
        if(myChoiceBox.getValue().equals("Rio de Janeiro")){
            rj.setVisible(true);
            sp.setVisible(false);
            bh.setVisible(false);
            bsb.setVisible(false);
        } else if (myChoiceBox.getValue().equals("São Paulo")){
            rj.setVisible(false);
            sp.setVisible(true);
            bh.setVisible(false);
            bsb.setVisible(false);
        } else if(myChoiceBox.getValue().equals("Belo Horizonte")){
            rj.setVisible(false);
            sp.setVisible(false);
            bh.setVisible(true);
            bsb.setVisible(false);
        } else if(myChoiceBox.getValue().equals("Brasília")){
            rj.setVisible(false);
            sp.setVisible(false);
            bh.setVisible(false);
            bsb.setVisible(true);
        }
    }

    public void addContatos(){
        name.clear();
        telefone.clear();
        paineadd.setVisible(true);

    }

    public void atualizarcontatos(){
        if (atribuir.getValue().equals("Rio de Janeiro")){
            Rio.add(String.format("%s - %s",
                    name.getText(),
                    telefone.getText()));

            rj.setItems(Rio);

            paineadd.setVisible(false);
        } else if(atribuir.getValue().equals("São Paulo")){
            Sp.add(String.format("%s - %s",
                    name.getText(),
                    telefone.getText()));

            sp.setItems(Sp);

            paineadd.setVisible(false);
        } else if(atribuir.getValue().equals("Belo Horizonte")){
            Minas.add(String.format("%s - %s",
                    name.getText(),
                    telefone.getText()));

            bh.setItems(Minas);

            paineadd.setVisible(false);
        } else if(atribuir.getValue().equals("Brasília")){
            Bsb.add(String.format("%s - %s",
                    name.getText(),
                    telefone.getText()));

            bsb.setItems(Bsb);

            paineadd.setVisible(false);
        }
    }

}
