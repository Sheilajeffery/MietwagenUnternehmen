package mietwagen.model;

import java.util.ArrayList;

public class Unternehmen {

	private ArrayList<Mietwagen> mietwagenList = new ArrayList<Mietwagen>();;

	public static Unternehmen instance = null;

	/**
	 * Wir wollen nur ein einziges Instanz dur die Unternehmen haben
	 * 
	 * @return die instance
	 */

	public static Unternehmen getInstance() {

		if (instance == null) {
			instance = new Unternehmen();
		}
		return instance;
	}

	public ArrayList<Mietwagen> getMietwagenList() {
		return mietwagenList;
	}

	/**
	 * Weil wir nur eine instance der Unternehmen haben fur die Teste muss die
	 * ArrayList leer sein.
	 */
	public void emptyList() {
		mietwagenList = new ArrayList<Mietwagen>();

	}

	/**
	 * Sucht die Position des Mietwagens
	 * 
	 * @param m
	 *            in der ArrayList
	 * @return indexOf m falls es existiert, oder -1 falls der Wagen nicht
	 *         existiert
	 */
	public int suchen(Mietwagen m) {

		if (mietwagenList.contains(m))
			return mietwagenList.indexOf(m);
		else
			return -1;
	}

	/**
	 * Wir wollen eine Liste von Mietwagen mit dieser Marke
	 * 
	 * @param marke
	 *            des Mietwagens
	 * @return liste von Mietwagen
	 */
	public ArrayList<Mietwagen> suchenMarke(String marke) {

		ArrayList<Mietwagen> markeList = new ArrayList<Mietwagen>();

		for (Mietwagen m : mietwagenList)
			if (m.getMarke().equals(marke))
				markeList.add(m);

		return markeList;

	}

	/**
	 * Wir prufen ob der Mietwagen mit der id schon in der liste existiert
	 * 
	 * @param m
	 *            den wir anlegen wollen
	 * @return true falls es angelegt wurde, anderenfalls false
	 */
	public boolean anlegen(Mietwagen m) {

		if (!mietwagenList.contains(m)) {
			mietwagenList.add(m);
			return true;
		} else
			return false; // mietwagen existiert

	}

	/**
	 * Wir prufen ob der Mietwagen mit der id in der liste existiert und
	 * loeschen es
	 * 
	 * @param m
	 *            den wir loeschen wollen
	 * @return true falls es geloescht wurde, sonst false
	 */

	public boolean loschen(Mietwagen m) {
		if (suchen(m) != -1) {
			mietwagenList.remove(suchen(m));
			return true;
		} else
			return false;// es existiert nicht!
	}

	/**
	 * Wenn der Mietwagen existiert unde falls es nicht vermietet ist, speichern
	 * wir ein Vermietendatum
	 * 
	 * @param m
	 *            Auto zu vermieten
	 * @param datum
	 *            Vermietet bis datum
	 * @return true falls es existiert,vermietbar war unde jezt vermietet wurde
	 */
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

}
