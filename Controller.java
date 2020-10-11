package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller{
    @FXML
    TextField textField;
    @FXML
    TextArea textArea;
    @FXML
        ListView<String> listView = new ListView<String>(); ;
    public void handle (ActionEvent event) throws Exception {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        dictionaryCommandline.dic.insertFromFile();
        String text_out = textField.getText();
        ObservableList<String> listWord = FXCollections.observableArrayList(dictionaryCommandline.dictionarySearch(text_out));

        listView.setItems(listWord);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        String Text = dictionaryCommandline.dic.dictionarylook(text_out);
        textArea.setText(Text);

    }
}
