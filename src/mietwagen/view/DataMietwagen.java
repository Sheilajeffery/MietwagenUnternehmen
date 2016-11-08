package mietwagen.view;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DataMietwagen {

	private SimpleObjectProperty<CheckBox> select;
	private SimpleObjectProperty<TextField> id;
	private SimpleObjectProperty<Text> marke;
	private SimpleObjectProperty<TextField> vermietet;
	private SimpleObjectProperty<ComboBox<Integer>> tag;
	private SimpleObjectProperty<ComboBox<String>> monat;
	private SimpleObjectProperty<ComboBox<Integer>> jahr;

	private SimpleObjectProperty<TextField> vermietetVon;
	
	public DataMietwagen() {
		select = new SimpleObjectProperty<CheckBox>();
		id = new SimpleObjectProperty<TextField>();
		marke = new SimpleObjectProperty<Text>();
		vermietet = new SimpleObjectProperty<TextField>();
		tag = new SimpleObjectProperty<ComboBox<Integer>>();
		monat = new SimpleObjectProperty<ComboBox<String>>();
		jahr = new SimpleObjectProperty<ComboBox<Integer>>();
		vermietetVon = new SimpleObjectProperty<TextField>();
}
	
	
	public CheckBox getSelect() {

		return select.get();
	}

	public void setSelect(CheckBox cb) {
		select.set(cb);
	}

	public TextField getId() {

		return id.get();
	}

	public void setId(TextField id) {
		this.id.set(id);
	}

	public void TextField(TextField id) {
		this.id.set(id);
	}
	
	public void setMarke(Text marke) {
		this.marke.set(marke);
	}
	
	public Text getMarke(){
		return marke.get();
	}
	
	public ComboBox<Integer> getTag() {
		return tag.get();
	}

	public void setTag(ComboBox<Integer> tag) {
		this.tag.set(tag);
	}
	
	public ComboBox<String> getMonat() {
		return monat.get();
	}

	public void setMonat(ComboBox<String> monat) {
		this.monat.set(monat);
	}
	
	public ComboBox<Integer> getJahr() {
		return jahr.get();
	}

	public void setJahr(ComboBox<Integer> jahr) {
		this.jahr.set(jahr);
	}
	
	public void setVermietetVon(TextField vermietetVon) {
		this.vermietetVon.set(vermietetVon);
	}
	
	public TextField vermietetVon(){
		return vermietetVon.get();
	}
	
	public TextField getVermietet() {

		return vermietet.get();
	}

	public void setVermietet(TextField vermietet) {
		this.vermietet.set(vermietet);
	}
	
}