package mietwagen.model;

public class Datum {
	private int tag;
	private String monat;
	private int jahr;
	
	public Datum(int tag, String monat, int jahr) {
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
	}
	
	/**
	 * Uberschreben der equals Methode fur Datum Objekte
	 * @return true wenn die Daten denselben Tag, Monat und Jahr haben
	 */
	
@Override
	public boolean equals(Object o){
	
	if(o instanceof Datum)
	{
		Datum other = (Datum)o;
		return other.getTag() == tag && other.getMonat().equals(monat)
				&& other.getJahr() == jahr;
	}
	return false;
}
	public int getTag() {
		return tag;
	}

	@Override
	public String toString() {
		return tag +". "+ monat + " " + jahr;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}

	public String getMonat() {
		return monat;
	}

	public void setMonat(String monat) {
		this.monat = monat;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

}
