package mietwagen.view;

import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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

		TableColumn<DataMietwagen, Text> spalte2 = new TableColumn<DataMietwagen, Text>("Id");
		spalte2.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("id"));
		spalte2.setMinWidth(100);
		spalte2.setMaxWidth(100);

		TableColumn<DataMietwagen, Text> spalte3 = new TableColumn<DataMietwagen, Text>("Marke");
		spalte3.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("marke"));
		spalte3.setMinWidth(100);
		spalte3.setMaxWidth(100);

		TableColumn<DataMietwagen, Text> spalte4 = new TableColumn<DataMietwagen, Text>("Vermietet");
		spalte4.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("vermietet"));
		spalte4.setMinWidth(100);
		spalte4.setMaxWidth(1);

		TableColumn<DataMietwagen, Text> spalte5 = new TableColumn<DataMietwagen, Text>("Tag");
		spalte5.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("tag"));
		spalte5.setMinWidth(70);
		spalte5.setMaxWidth(70);

		TableColumn<DataMietwagen, Text> spalte6 = new TableColumn<DataMietwagen, Text>("Monat");
		spalte6.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("monat"));
		spalte6.setMinWidth(70);
		spalte6.setMaxWidth(70);

		TableColumn<DataMietwagen, Text> spalte7 = new TableColumn<DataMietwagen, Text>("Jahr");
		spalte7.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("jahr"));
		spalte7.setMinWidth(70);
		spalte7.setMaxWidth(70);

		TableColumn<DataMietwagen, Text> spalte8 = new TableColumn<DataMietwagen, Text>("Vermietet von");
		spalte8.setCellValueFactory(new PropertyValueFactory<DataMietwagen, Text>("vermietetVon"));
		spalte8.setMinWidth(100);
		spalte8.setMaxWidth(100);

		tabelle.getColumns().addAll(spalte1, spalte2, spalte3, spalte4, spalte5, spalte6, spalte7, spalte8);
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

	public void addNeueZeile(int id, String marke, boolean vermietet, Integer tag, String monat, Integer jahr,
			String vermietetVon) {

		CheckBox cb = new CheckBox();
		Text tId = new Text();
		Text tMarke = new Text();
		Text tVermietet = new Text();
		Text tVermietetVon = new Text();
		Text tTag = new Text();
		Text tMonat = new Text();
		Text tJahr = new Text();

		tId.setText(id + "");
		tMarke.setText(marke);

		if (vermietet) {
			tVermietet.setText("ja");
			tTag.setText(Integer.toString(tag));
			tMonat.setText(monat);
			tJahr.setText(Integer.toString(jahr));
			tVermietetVon.setText(vermietetVon + "");
		} else
			tVermietet.setText("nein");

		boolean anlegenOK;
		Datum datum;

		if (vermietet)
			datum = new Datum(tag.intValue(), monat, jahr.intValue());
		else
			datum = null;

		Mietwagen m = new Mietwagen(id, marke, vermietet, datum, vermietetVon);
		anlegenOK = u.anlegen(m);

		DataMietwagen dm = new DataMietwagen();

		if (anlegenOK) {
			dm.setSelect(cb);
			dm.setId(tId);
			dm.setMarke(tMarke);
			dm.setVermietet(tVermietet);
			dm.setTag(tTag);
			dm.setMonat(tMonat);
			dm.setJahr(tJahr);
			dm.setVermietetVon(tVermietetVon);

			tabelle.getItems().add(dm);

		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Type Error...");
			alert.setContentText("Ein Mietwagen mit der id: " + id + " existiert schon. Versuche eine andere id!");
			alert.showAndWait();
		}
	}

	public void deleteZeile(int id) {
		Text tId = new Text();

		tId.setText(Integer.toString(id));

		Mietwagen m = new Mietwagen(id, null, false, null, null);
		int i;
		i = u.suchen(m);

		if (u.loschen(m))

			tabelle.getItems().remove(i);

		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Type Error...");
			alert.setContentText("Es gibt kein Mietwagen mit der id: " + id);
			alert.showAndWait();
		}
	}

	public void vermietenDatum(int id, String marke, boolean vermietet, Integer tag, String monat, Integer jahr,
			String vermietetVon) {

		CheckBox cb = new CheckBox();
		Text tId = new Text();
		Text tMarke = new Text();
		Text tVermietet = new Text();
		Text tTag = new Text();
		Text tMonat = new Text();
		Text tJahr = new Text();
		Text tVermietetVon = new Text();

		tId.setText(id + "");
		tMarke.setText(marke);

		tVermietet.setText("ja");
		tTag.setText(Integer.toString(tag));
		tMonat.setText(monat);
		tJahr.setText(Integer.toString(jahr));
		tVermietetVon.setText(vermietetVon);

		Datum datum;
		datum = new Datum(tag.intValue(), monat, jahr.intValue());

		Mietwagen m = new Mietwagen(id, null, false, null, null);

		int i;
		i = u.suchen(m);
		 Mietwagen mi = u.getMietwagenList().get(i);

		if (i != -1) {
			u.vermietenBisDatum(mi, datum);

			DataMietwagen dm = new DataMietwagen();
			dm = tabelle.getItems().get(i);

			dm.setVermietet(tVermietet);
			dm.setTag(tTag);
			dm.setMonat(tMonat);
			dm.setJahr(tJahr);
			dm.setVermietetVon(tVermietetVon);

			tabelle.getItems().set(i, dm);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Type Error...");
			alert.setContentText("Es gibt kein Mietwagen mit der id: " + id);
			alert.showAndWait();
		}

	}

	public String nachMarkeSuchen(String marke) {
		String markeListe;
		markeListe = arrayListToString(u.suchenMarke(marke));
		return markeListe;
	}

	public static String arrayListToString(ArrayList<Mietwagen> list) {

		String li = "";
		for (Mietwagen m : list) {
			li = li + " id: " + m.getId() + " marke: " + m.getMarke() + " vermietet: " + m.getVermietet() + " ";
			if (m.getVermietet()) {
				li = li + " vermietet bis: " + m.getVermietet_bis_Datum().toString();
				li = li + " vermietet von: " + m.getVermietetVon();
			}

			li = li + "\n";
		}

		return li;

	}
	/*
	 * public String listeSpeichern() { String liste="";
	 * System.out.println(u.getMietwagenList());
	 * 
	 * for (Mietwagen m : u.getMietwagenList()) { liste = liste +
	 * m.getId()+"\n"+ m.getMarke()+"\n" +
	 * Integer.toString(m.getVermietet_bis_Datum().getTag())+"\n" +
	 * m.getVermietet_bis_Datum().getMonat()+"\n" +
	 * Integer.toString(m.getVermietet_bis_Datum().getJahr())
	 * +"\n"+m.getVermietetVon()+"\n";
	 * 
	 * }
	 * 
	 * return liste; }
	 * 
	 */

	public boolean istVermietet(int id) {
		Mietwagen m = u.getMietwagenList().get(id);

		return m.getVermietet();
	}
}
