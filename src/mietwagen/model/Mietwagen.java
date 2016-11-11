package mietwagen.model;

public class Mietwagen {
	protected int id;
	protected String marke;
	protected boolean vermietet;
	protected Datum vermietet_bis_Datum;
	protected String vermietetVon;
	
	public Mietwagen(int id, String marke, boolean vermietet, Datum vermietet_bis_Datum, String vermietetVon) {
		this.id = id;
		this.marke = marke;
		this.vermietet = vermietet;
		this.vermietet_bis_Datum = vermietet_bis_Datum;
		this.vermietetVon = vermietetVon;
	}
	/**
	 * Uberschreiben der equals Method fur Mietwagen
	 * @return true wenn die Mietwagen dieseble id haben	
	*/
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Mietwagen)
		{
			Mietwagen other = (Mietwagen)o;
			return other.getId()==id;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public boolean getVermietet() {
		return vermietet;
	}

	public void setVermietet(boolean vermietet) {
		this.vermietet = vermietet;
	}

	public Datum getVermietet_bis_Datum() {
		return vermietet_bis_Datum;
	}

	public void setVermietet_bis_Datum(Datum vermietet_bis_Datum) {
		this.vermietet_bis_Datum = vermietet_bis_Datum;
	}

	public String getVermietetVon() {
		return vermietetVon;
	}

	public void setVermietetVon(String vermietetVon) {
		this.vermietetVon = vermietetVon;
	}

	@Override
	public String toString() {
		return "Mietwagen [id=" + id + ", marke=" + marke + ", vermietet=" + vermietet + ", vermietet_bis_Datum="
				+ vermietet_bis_Datum + ", vermietetVon=" + vermietetVon + "]";
	}
	

}
