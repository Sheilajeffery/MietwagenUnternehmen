package mietwagen.view;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DataMietwagen {

	private SimpleObjectProperty<CheckBox> select;
	private SimpleObjectProperty<Text> id;
	private SimpleObjectProperty<Text> marke;
	private SimpleObjectProperty<Text> vermietet;
	private SimpleObjectProperty<Text> tag;
	private SimpleObjectProperty<Text> monat;
	private SimpleObjectProperty<Text> jahr;
	private SimpleObjectProperty<Text> vermietetVon;
	
	public DataMietwagen() {
		select = new SimpleObjectProperty<CheckBox>();
		id = new SimpleObjectProperty<Text>();
		marke = new SimpleObjectProperty<Text>();
		vermietet = new SimpleObjectProperty<Text>();
		tag = new SimpleObjectProperty<Text>();
		monat = new SimpleObjectProperty<Text>();
		jahr = new SimpleObjectProperty<Text>();
		vermietetVon = new SimpleObjectProperty<Text>();
}
	
	
	public CheckBox getSelect() {

		return select.get();
	}

	public void setSelect(CheckBox cb) {
		select.set(cb);
	}

	public Text getId() {

		return id.get();
	}

	public void setId(Text id) {
		this.id.set(id);
	}

	
	public void setMarke(Text marke) {
		this.marke.set(marke);
	}
	
	public Text getMarke(){
		return marke.get();
	}
	
	public Text getTag() {
		return tag.get();
	}

	public void setTag(Text tag) {
		this.tag.set(tag);
	}
	
	public Text getMonat() {
		return monat.get();
	}

	public void setMonat(Text monat) {
		this.monat.set(monat);
	}
	
	public Text getJahr() {
		return jahr.get();
	}

	public void setJahr(Text jahr) {
		this.jahr.set(jahr);
	}
	
	public void setVermietetVon(Text vermietetVon) {
		this.vermietetVon.set(vermietetVon);
	}
	
	public Text getVermietetVon(){
		return vermietetVon.get();
	}
	
	public Text getVermietet() {

		return vermietet.get();
	}

	public void setVermietet(Text vermietet) {
		this.vermietet.set(vermietet);
	}
	
}