package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.ausruestung.Accessoire;
import de.pk.model.gegenstaende.ausruestung.Ruestung;
import de.pk.model.gegenstaende.ausruestung.Waffe;
import de.pk.model.spielbrett.spielbrettObjekte.container.Container;
import de.pk.utils.DebugAusgabeKlasse;

public class Held extends LebendigesObjekt
{

	private String name = null;
	private Container inventar = null; // Das Inventar dieses Helden
	private Waffe waffe = null; // Die Waffe dieses Helden
	private Ruestung ruestung = null; // Die Ruestung die dieser Held angelegt hat
	private Accessoire[] accessoires = null; // Alle Accessiores die dieser Held traegt
	private Faehigkeit[] faehigkeiten = null;
	private int sterbeZaehler = 0;

	/**
	 * Erstellt einen Helden mit Namen, Lebenspunkte und Bewegungspunkten
	 *
	 * @param name            Der Name des Helden
	 * @param lebensPunkte    Anzahl der Lebenspunkte des Helden
	 * @param bewegungsPunkte Anzahl der Bewegungspunkte des Helden
	 */
	public Held(String name, int lebensPunkte, int bewegungsPunkte)
	{
		super(lebensPunkte, bewegungsPunkte);
		this.name = name;
	}

	public Accessoire[] getAccessoires()
	{
		return this.accessoires;
	}

	public Faehigkeit[] getFaehigkeiten()
	{
		return this.faehigkeiten;
	}

	public Container getInventar()
	{
		return this.inventar;
	}

	public String getName()
	{
		return this.name;
	}

	public Ruestung getRuestung()
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

	public void setRuestung(Ruestung ruestung)
	{
		this.ruestung = ruestung;
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
		DebugAusgabeKlasse.ausgeben(this.getName() + " ist zum " + (this.getSterbeZaehler() + 1) + " mal gestorben");
		this.sterbeZaehler++;
		return this.inventar;
	}

}
