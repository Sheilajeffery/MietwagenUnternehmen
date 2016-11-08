package mietwagen.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import mietwagen.model.Datum;
import mietwagen.model.Mietwagen;
import mietwagen.model.Unternehmen;

public class MietwagenTabelle {

	Unternehmen u = Unternehmen.getInstance();

	final ObservableList<DataMietwagen> tableViewDaten = FXCollections.observableArrayList();

	TableView<DataMietwagen> tabelle;

	public TableView<DataMietwagen> intTabelle() {
		tabelle = new TableView<DataMietwagen>(tableViewDaten);

		TableColumn<DataMietwagen, CheckBox> spalte1 = new TableColumn<DataMietwagen, CheckBox>("#");
		spalte1.setCellValueFactory(new PropertyValueFactory<DataMietwagen, CheckBox>("select"));
		spalte1.setMinWidth(22);
		spalte1.setMaxWidth(22);

		TableColumn<DataMietwagen, TextField> spalte2 = new TableColumn<DataMietwagen, TextField>("Id");
		spalte2.setCellValueFactory(new PropertyValueFactory<DataMietwagen, TextField>("id"));
		spalte2.setMinWidth(100);
		spalte2.setMaxWidth(100);

		TableColumn<DataMietwagen, Text> spalte3 = new TableColumn<DataMietwagen, Text>("Marke");
		spalte3.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("marke"));
		spalte3.setMinWidth(100);
		spalte3.setMaxWidth(100);

		TableColumn<DataMietwagen, TextField> spalte4 = new TableColumn<DataMietwagen, TextField>("Vermietet");
		spalte4.setCellValueFactory(new PropertyValueFactory<DataMietwagen, TextField>("vermietet"));
		spalte4.setMinWidth(100);
		spalte4.setMaxWidth(1);

		TableColumn<DataMietwagen, ComboBox<Integer>> spalte5 = new TableColumn<DataMietwagen, ComboBox<Integer>>("Tag");
		spalte5.setCellValueFactory(new PropertyValueFactory<DataMietwagen, ComboBox<Integer>>("tag"));
		spalte5.setMinWidth(70);
		spalte5.setMaxWidth(70);
		
		TableColumn<DataMietwagen, ComboBox<String>> spalte6 = new TableColumn<DataMietwagen, ComboBox<String>>("Monat");
		spalte6.setCellValueFactory(new PropertyValueFactory<DataMietwagen, ComboBox<String>>("monat"));
		spalte6.setMinWidth(70);
		spalte6.setMaxWidth(70);
		
		TableColumn<DataMietwagen, ComboBox<Integer>> spalte7 = new TableColumn<DataMietwagen, ComboBox<Integer>>("Jahr");
		spalte7.setCellValueFactory(new PropertyValueFactory<DataMietwagen, ComboBox<Integer>>("jahr"));
		spalte7.setMinWidth(70);
		spalte7.setMaxWidth(70);

		TableColumn<DataMietwagen, TextField> spalte8 = new TableColumn<DataMietwagen, TextField>("Vermietet von");
		spalte8.setCellValueFactory(new PropertyValueFactory<DataMietwagen, TextField>("vermietetVon"));
		spalte8.setMinWidth(100);
		spalte8.setMaxWidth(100);

		tabelle.getColumns().addAll(spalte1, spalte2, spalte3, spalte4, spalte5, spalte6,spalte7,spalte8);
		return tabelle;
	}

	public GridPane grid() {
		GridPane grid = new GridPane();
		grid.setHgap(40);
		grid.setVgap(40);
		grid.setPadding(new Insets(100, 200, 0, 200));

		grid.add(intTabelle(), 0, 0);

		return grid;
	}

	public void addNeueZeile(int id, String marke, boolean vermietet, Integer tag,String monat,Integer jahr, String vermietetVon) {

		CheckBox cb = new CheckBox();
		TextField tId = new TextField();
		Text tMarke = new Text();
		TextField tVermietet = new TextField();
		TextField tVermietetVon = new TextField();
		
		ObservableList<Integer> tage = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
		ComboBox<Integer> tagcb = new ComboBox<Integer>(tage);
		
		ObservableList<String> monate = FXCollections.observableArrayList("januar","februar","marz","april","mai","juni","juli","august","september","oktober","november","dezember");
		ComboBox<String> monatcb = new ComboBox<String>(monate);
		
		ObservableList<Integer> jahre = FXCollections.observableArrayList(2016,2017);
		ComboBox<Integer> jahrcb = new ComboBox<Integer>(jahre);
		
		tId.setText(id + "");
		tMarke.setText(marke + "");

		if(vermietet){
		tVermietet.setText("ja");
		tagcb.setValue(tag);  ///getSelectionModel().select(tage.get(tag));
		monatcb.setValue(monat);
		jahrcb.setValue(jahr);
		}
		else
			tVermietet.setText("nein");
		
		
		

		tVermietetVon.setText(vermietetVon);

		boolean anlegenOK;
		Datum datum;
		
		if(vermietet)
			 datum = new Datum(tag.intValue(),monat,jahr.intValue()); 
		else
			 datum = null;
		
		Mietwagen m = new Mietwagen(id, marke, vermietet,datum, vermietetVon);
		anlegenOK = u.anlegen(m);

		DataMietwagen dm = new DataMietwagen();

		if (anlegenOK) {
			dm.setSelect(cb);
			dm.setId(tId);
			dm.setMarke(tMarke);
			dm.setVermietet(tVermietet);
			dm.setTag(tagcb);
			dm.setMonat(monatcb);
			dm.setJahr(jahrcb);
			dm.setVermietetVon(tVermietetVon);
			
			tabelle.getItems().add(dm);
		}
	}

}
