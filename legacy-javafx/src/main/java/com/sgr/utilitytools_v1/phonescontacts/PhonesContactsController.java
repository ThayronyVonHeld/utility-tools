package com.sgr.utilitytools_v1.phonescontacts;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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
    private ListView<String> lista;


    private final ObservableList<String> Rio = FXCollections.observableArrayList();
    private final ObservableList<String> Sp = FXCollections.observableArrayList();
    private final ObservableList<String> Minas = FXCollections.observableArrayList();
    private final ObservableList<String> Bsb = FXCollections.observableArrayList();

    Map<String, ObservableList<String>> contatos = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paineadd.setVisible(false);

        contatos.put("Rio de Janeiro", Rio);
        contatos.put("São Paulo", Sp);
        contatos.put("Belo Horizonte", Minas);
        contatos.put("Brasília", Bsb);

        myChoiceBox.getItems().addAll(contatos.keySet());
        atribuir.getItems().addAll(contatos.keySet());

        myChoiceBox.setOnAction(this::getPraca);

    }


    private void getPraca(javafx.event.ActionEvent actionEvent) {
        lista.setItems(contatos.get(myChoiceBox.getValue()));
        lista.setVisible(true);
    }

    public void addContatos() {
        name.clear();
        telefone.clear();
        paineadd.setVisible(true);

    }

    public void salvarContato() {

        contatos.get(atribuir.getValue()).add(name.getText() + " - " + telefone.getText());
        paineadd.setVisible(false);
    }
}
