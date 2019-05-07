package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.ausruestung.Accessoire;
import de.pk.model.gegenstaende.ausruestung.Ruestung;
import de.pk.model.gegenstaende.ausruestung.Waffe;
import de.pk.model.gegenstaende.container.Container;
import de.pk.utils.DebugAusgabeKlasse;

public class HeldModell extends LebendigesObjektModell
{

	public static final int ANZAHL_MAXIMALE_ACCESSOIRES = 5;
	public static final int ANZAHL_MAXIMALE_RUESTUNGS_GEGENSTAENDE = 3;
	private String name = null;
	private Container inventar = null; // Das Inventar dieses Helden
	private Waffe waffe = null; // Die Waffe dieses Helden
	private Map<Integer, Ruestung> ruestung = null; // Die Ruestungsgegenstaende die dieser Held angelegt hat
	private Map<Integer, Accessoire> accessoires = null; // Alle Accessiores die dieser Held traegt
	private List<Faehigkeit> faehigkeiten = null; // Die Faehigkeiten, die der Held hat
	private int sterbeZaehler = 0;

	/**
	 * Erstellt einen Helden mit Namen, Lebenspunkte und Bewegungspunkten
	 *
	 * @param name            Der Name des Helden
	 * @param lebensPunkte    Anzahl der Lebenspunkte des Helden
	 * @param bewegungsPunkte Anzahl der Bewegungspunkte des Helden
	 */
	public HeldModell(String name, int lebensPunkte, int bewegungsPunkte)
	{
		super(lebensPunkte, bewegungsPunkte);
		this.ruestung = Collections.synchronizedMap(new HashMap<>(HeldModell.ANZAHL_MAXIMALE_RUESTUNGS_GEGENSTAENDE));
		this.accessoires = Collections.synchronizedMap(new HashMap<>(HeldModell.ANZAHL_MAXIMALE_ACCESSOIRES));
		this.faehigkeiten = Collections.synchronizedList(new ArrayList<>());
		this.name = name;
	}

	public void fuegeFaehigkeitenHinzu(Faehigkeit... faehigkeiten)
	{
		this.faehigkeiten.addAll(Arrays.asList(faehigkeiten));
	}

	public Map<Integer, Accessoire> getAccessoires()
	{
		return this.accessoires;
	}

	public List<Faehigkeit> getFaehigkeiten()
	{
		return Collections.unmodifiableList(this.faehigkeiten);
	}

	public Container getInventar()
	{
		return this.inventar;
	}

	public String getName()
	{
		return this.name;
	}

	public Map<Integer, Ruestung> getRuestung()
	{
		return this.ruestung;
	}

	public int getSterbeZaehler()
	{
		return this.sterbeZaehler;
	}

	public Waffe getWaffe()
	{
		return this.waffe;
	}

	public void setWaffe(Waffe waffe)
	{
		this.waffe = waffe;
	}

	/**
	 * Definiert das Sterben des Helden.
	 *
	 * @return das Inventar des toten Helden als Container
	 */
	@Override
	public Container sterben()
	{
		this.sterbeZaehler++;
		return this.inventar;
	}

}
