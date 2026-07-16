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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class PhonesContactsController implements Initializable {

    @FXML
    private Pane paineadd;
    @FXML
    private TextField name;
    @FXML
    private TextField telefone;
    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private ChoiceBox<String> atribuir;
    @FXML
    private ListView listaContatos;


    private ObservableList<String> Rio = FXCollections.observableArrayList();
    private ObservableList<String> Sp = FXCollections.observableArrayList();
    private ObservableList<String> Minas = FXCollections.observableArrayList();
    private ObservableList<String> Bsb = FXCollections.observableArrayList();

    Map<String, ObservableList<String>> contatos = new HashMap<>();

    private ObservableList<String> lista = contatos.get(atribuir.getValue());

    private String[] pracas = {"Rio de Janeiro", "São Paulo", "Belo Horizonte", "Brasília", "Outros"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(pracas);
        atribuir.getItems().addAll(pracas);
        paineadd.setVisible(false);

        rj.setItems(Rio);
        bh.setItems(Minas);
        sp.setItems(Sp);
        bsb.setItems(Bsb);

        contatos.put("Rio de Janeiro", Rio);
        contatos.put("São Paulo", Sp);
        contatos.put("Belo Horizonte", Minas);
        contatos.put("Brasília", Bsb);

        myChoiceBox.setOnAction(this::getPraca);

    }

    private void getPraca(javafx.event.ActionEvent actionEvent) {
        if (myChoiceBox.getValue().equals("Rio de Janeiro")) {
            rj.setVisible(true);
            sp.setVisible(false);
            bh.setVisible(false);
            bsb.setVisible(false);
        } else if (myChoiceBox.getValue().equals("São Paulo")) {
            rj.setVisible(false);
            sp.setVisible(true);
            bh.setVisible(false);
            bsb.setVisible(false);
        } else if (myChoiceBox.getValue().equals("Belo Horizonte")) {
            rj.setVisible(false);
            sp.setVisible(false);
            bh.setVisible(true);
            bsb.setVisible(false);
        } else if (myChoiceBox.getValue().equals("Brasília")) {
            rj.setVisible(false);
            sp.setVisible(false);
            bh.setVisible(false);
            bsb.setVisible(true);
        }
    }

    public void addContatos() {
        name.clear();
        telefone.clear();
        paineadd.setVisible(true);

    }

    public void atualizarcontatos() {

        contatos.get(atribuir.getValue()).add(name + " - " + telefone);

        paineadd.setVisible(false);
    }
}
