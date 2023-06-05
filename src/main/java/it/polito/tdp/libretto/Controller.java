package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import it.polito.tdp.libretto.model.Libretto; // libretto importato

public class Controller {
	
	// righe aggiunte
	private Libretto model;

	public void setModel(Libretto model) {
		this.model = model;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bntInserisci;

    @FXML
    private ComboBox<Integer> cmbPunti;

    @FXML
    private DatePicker selData;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	String corso = txtCorso.getText();
    	Integer punti = cmbPunti.getValue();
    	LocalDate dataEsame = selData.getValue();
    	
    	Voto v = new Voto(corso, punti, dataEsame);
    	this.model.add(v);
    	
    	txtResult.setText(this.model.toString());
    }

    @FXML
    void initialize() {
        assert bntInserisci != null : "fx:id=\"bntInserisci\" was not injected: check your FXML file 'main.fxml'.";
        assert cmbPunti != null : "fx:id=\"cmbPunti\" was not injected: check your FXML file 'main.fxml'.";
        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";

        for (int p=18; p<=30; p++) {
        	cmbPunti.getItems().add(p);
        }
        
    }

	
	
	
	
	
}
