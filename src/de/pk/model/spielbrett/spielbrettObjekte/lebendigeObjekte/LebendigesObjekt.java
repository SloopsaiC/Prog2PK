package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ArrayList;
import java.util.HashMap;

import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.Effekt;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.spielbrett.spielbrettObjekte.container.Container;

public abstract class LebendigesObjekt extends SpielbrettObjekt
{

	private int lebensPunkte = 0;
	private int bewegungsPunkte = 0;
	private int ruestungsPunkte = 0;
	private int angriffsPunkte = 0;

	private HashMap<String, Aktion> aktionen = null; // Alle Aktionen die diese Objekt ausfuehren kann, welche durch den
														// Namen abgebildet werden
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

	public void aendereAngriffsPunkte(int aenderung)
	{
		this.setAngriffsPunkte(this.getRuestungsPunkte() + aenderung);
	}

	public void aendereBewegungsPunkte(int aenderung)
	{
		this.setBewegungsPunkte(this.getBewegungsPunkte() + aenderung);
	}

	public void aendereLebensPunkte(int aenderung)
	{
		this.setLebensPunkte(this.getLebensPunkte() + aenderung);
	}

	public void aendereRuestungsPunkte(int aenderung)
	{
		this.setRuestungsPunkte(this.getRuestungsPunkte() + aenderung);
	}

	/**
	 * Entfernt den Effekt, der auf diesen Helden wirkt
	 */
	public void entferneEffekt(Effekt entfernen)
	{
		this.effekte.remove(entfernen);
	}

	public void fuegeAktionHinzu(String name, Aktion hinzufuegen)
	{
		this.aktionen.put(name, hinzufuegen);
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
	 * @return Array mit allen Aktionen des Lebendigen Objekts
	 */
	public HashMap<String, Aktion> getAktionen()
	{
		return this.aktionen;
	}

	public Aktion getAktionMitNamen(String name)
	{
		return this.aktionen.get(name);
	}

	public int getAngriffsPunkte()
	{
		return this.angriffsPunkte;
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
	 *
	 * @return Array mit allen Statuseffekten des Lebendigen Objekts
	 */
	public ArrayList<Effekt> getEffekte()
	{
		return this.effekte;
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

	@Override
	public boolean istLebendig()
	{
		return true;
	}

	public void setAngriffsPunkte(int angriffsPunkte)
	{
		this.angriffsPunkte = angriffsPunkte;
	}

	/**
	 *
	 * @param bewegungsPunkte Neue Anzahl Bewegungspunkte
	 */
	public void setBewegungsPunkte(int bewegungsPunkte)
	{
		this.bewegungsPunkte = bewegungsPunkte;
	}

	/**
	 *
	 * @param lebensPunkte Neue Anzahl Lebenspunkte
	 */
	public void setLebensPunkte(int lebensPunkte)
	{
		this.lebensPunkte = lebensPunkte;
	}

	/**
	 *
	 * @param ruestungsPunkte Neue Anzahl Ruestungspunkte
	 */
	public void setRuestungsPunkte(int ruestungsPunkte)
	{
		this.ruestungsPunkte = ruestungsPunkte;
	}

	/**
	 * Definiert das Sterben eines Lebendigen Objekts
	 *
	 * @return Einen Container (Inventar/Gegenstaende) des Gestorbenen
	 */
	public abstract Container sterben();

}
