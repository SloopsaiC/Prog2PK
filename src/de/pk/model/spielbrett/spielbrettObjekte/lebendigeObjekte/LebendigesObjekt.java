package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ArrayList;

import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.Effekt;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.spielbrett.spielbrettObjekte.container.Container;

public abstract class LebendigesObjekt extends SpielbrettObjekt
{

	private int lebensPunkte = 0;
	private int bewegungsPunkte = 0;
	private int ruestungsPunkte = 0;
	private Aktion[] aktionen = null; // Alle Aktionen die dieses lebendige Objekt ausfuehren kann
	private ArrayList<Effekt> effekte = null; // Alle Statuseffekte die auf dieses Objekt wirken

	/**
	 * Dient lediglich als super-Konstruktor fuer abgeleitete
	 * LebendigeObjekt-Klassen
	 *
	 * @param lebensPunkte    Anzahl der Lebenspunkte
	 * @param bewegungsPunkte Anzahl der Bewegungspunkte
	 */
	protected LebendigesObjekt(int lebensPunkte, int bewegungsPunkte)
	{
		this.lebensPunkte = lebensPunkte;
		this.bewegungsPunkte = bewegungsPunkte;
	}

	/**
	 *
	 * @return Array mit allen Aktionen des Lebendigen Objekts
	 */
	public Aktion[] getAktionen()
	{
		return this.aktionen;
	}

	/**
	 *
	 * @return Bewegungspunkte des Lebendigen Objekts
	 */
	public int getBewegungsPunkte()
	{
		return this.bewegungsPunkte;
	}

	/**
	 * Anzahl der Lebenspunkte des Lebendigen Objekts
	 *
	 * @return
	 */
	public int getLebensPunkte()
	{
		return this.lebensPunkte;
	}

	/**
	 *
	 * @return Anzahl der Ruestungspunkte des Lebendigen Objekts
	 */
	public int getRuestungsPunkte()
	{
		return this.ruestungsPunkte;
	}

	/**
	 *
	 * @return Array mit allen Statuseffekten des Lebendigen Objekts
	 */
	public ArrayList<Effekt> getEffekte()
	{
		return this.effekte;
	}

	/**
	 * Fuegt einen Effekt hinzu der auf diesen Helden wirkt
	 */
	public void fuegeEffektHinzu(Effekt hinzufuegen)
	{
		this.effekte.add(hinzufuegen);
	}

	/**
	 *
	 * @param bewegungsPunkte Neue Anzahl Bewegungspunkte
	 */
	public void setBewegungsPunkte(int bewegungsPunkte)
	{
		this.bewegungsPunkte = bewegungsPunkte;
	}

	public void aendereBewegungsPunkte(int aenderung)
	{
		this.setBewegungsPunkte(this.getBewegungsPunkte() + aenderung);
	}

	/**
	 *
	 * @param lebensPunkte Neue Anzahl Lebenspunkte
	 */
	public void setLebensPunkte(int lebensPunkte)
	{
		this.lebensPunkte = lebensPunkte;
	}

	public void aendereLebensPunkte(int aenderung)
	{
		this.setLebensPunkte(this.getLebensPunkte() + aenderung);
	}

	/**
	 *
	 * @param ruestungsPunkte Neue Anzahl Ruestungspunkte
	 */
	public void setRuestungsPunkte(int ruestungsPunkte)
	{
		this.ruestungsPunkte = ruestungsPunkte;
	}

	public void aendereRuestungsPunkte(int aenderung)
	{
		this.setRuestungsPunkte(this.getRuestungsPunkte() + aenderung);
	}

	/**
	 * Definiert das Sterben eines Lebendigen Objekts
	 *
	 * @return Einen Container (Inventar/Gegenstaende) des Gestorbenen
	 */
	public abstract Container sterben();

}
