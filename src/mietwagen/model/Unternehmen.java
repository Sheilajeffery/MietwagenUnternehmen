package mietwagen.model;

import java.util.ArrayList;

public class Unternehmen {

	private ArrayList<Mietwagen> mietwagenList = new ArrayList<Mietwagen>();;

	public static Unternehmen instance = null;

	public static Unternehmen getInstance() {

		if (instance == null) {
			instance = new Unternehmen();
		}
		return instance;
	}

	/*
	 * public Unternehmen() { mietwagenList = new ArrayList<Mietwagen>(); }
	 */
	public ArrayList<Mietwagen> getMietwagenList() {
		return mietwagenList;
	}

	public void emptyList() {
		mietwagenList = new ArrayList<Mietwagen>();

	}

	// gives you the position of the car in the array
	public int suchen(Mietwagen m) {

		if (mietwagenList.contains(m))
			return mietwagenList.indexOf(m);
		else
			return -1;
	}

	public int suchenIdMarke(int id, String marke) {

		Mietwagen m = new Mietwagen(id, marke, false, null, null);

		if (suchen(m) != -1 && m.marke.equals(marke))
			return suchen(m); // position des Mietwagens
		else
			return -1; // kein Miwetwagen mit dieser Id und Marke

	}

	public boolean anlegen(Mietwagen m) {

		if (!mietwagenList.contains(m)) {
			mietwagenList.add(m);
			return true;
		} else
			return false; // mietwagen existiert

	}

	public boolean loschen(Mietwagen m) {
		if (suchen(m) != -1) {
			mietwagenList.remove(suchen(m));
			return true;
		} else
			return false;// es existiert nicht!
	}

	public boolean vermietenBisDatum(Mietwagen m, Datum datum) {
		if (mietwagenList.contains(m) && !m.vermietet) {
			{
				m.setVermietet_bis_Datum(datum);
				m.vermietet = true;
				return true;
			}
		}
		return false; // ist schon vermietet oder existiert nicht
	}
/*
	public void printList() {

		for (Mietwagen m : mietwagenList)
			System.out.println("id: " + Integer.toString(m.getId()) + ", marke: " + m.getMarke() + ", vermietet: "
					+ Boolean.toString(m.vermietet) + ", datum:" + m.getVermietet_bis_Datum() + ", vermietetVon: "
					+ m.getVermietetVon());

	}
*/
}
