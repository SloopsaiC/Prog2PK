package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

<<<<<<< HEAD
import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
=======
import de.pk.model.gegenstaende.container.Container;
>>>>>>> refs/heads/Phillip
import de.pk.model.interaktion.aktionen.Aktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjektModell;

public abstract class LebendigesObjektModell extends SpielbrettObjektModell
{

	private HashMap<LebendigesObjektPunkteIndex, Integer> punkte = null; // Alle Punkte die ein LebendigesObjekt haben
																			// kann, beschrieben in
	// "LebendigesObjektPunkteIndex"

	private HashMap<String, Aktion> aktionen = null; // Alle Aktionen die diese Objekt ausfuehren kann, welche durch den
														// Namen abgebildet werden
	private Map<Effekt, SpielbrettObjekt> effekteMitVerursacher = null; // Alle Statuseffekte die auf dieses Objekt
																		// wirken

	/**
	 * Dient lediglich als super-Konstruktor fuer abgeleitete
	 * LebendigeObjekt-Klassen
	 *
	 * @param lebensPunkte    Anzahl der Lebenspunkte
	 * @param bewegungsPunkte Anzahl der Bewegungspunkte
	 */
	protected LebendigesObjektModell(int lebensPunkte, int bewegungsPunkte)
	{
		this.punkte = new HashMap<>();
		this.punkte.put(LebendigesObjektPunkteIndex.LEBENS_PUNKTE, lebensPunkte);
		this.punkte.put(LebendigesObjektPunkteIndex.BEWEGUNGS_PUNKTE, bewegungsPunkte);
		this.aktionen = new HashMap<>();
		this.effekteMitVerursacher = Collections.synchronizedMap(new HashMap<Effekt, SpielbrettObjekt>());
	}

	public void aenderePunkteVon(LebendigesObjektPunkteIndex index, int aenderung)
	{
		this.setAnzahlPunkteVon(index, this.getAnzahlPunkteVon(index) + aenderung);
	}

	/**
	 * Entfernt den Effekt, der auf diesen Helden wirkt
	 */
	public void entferneEffekt(Effekt entfernen)
	{
		this.effekteMitVerursacher.remove(entfernen);
	}

	public void fuegeAktionHinzu(String name, Aktion hinzufuegen)
	{
		this.aktionen.put(name, hinzufuegen);
	}

	/**
	 * Fuegt einen Effekt hinzu der auf diesen Helden wirkt
	 */
	public void fuegeEffektHinzu(Effekt hinzufuegen, SpielbrettObjekt verursacher)
	{
		this.effekteMitVerursacher.put(hinzufuegen, verursacher);
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

	public int getAnzahlPunkteVon(LebendigesObjektPunkteIndex index)
	{
		return this.punkte.get(index);
	}

	/**
	 *
	 * @return Array mit allen Statuseffekten des Lebendigen Objekts
	 */
	public Set<Effekt> getEffekte()
	{
		return this.effekteMitVerursacher.keySet();
	}

	public SpielbrettObjekt getVerursacherVonEffekt(Effekt effekt)
	{
		return this.effekteMitVerursacher.get(effekt);
	}

	@Override
	public boolean istLebendig()
	{
		return true;
	}

	public void setAnzahlPunkteVon(LebendigesObjektPunkteIndex index, int neuerWert)
	{
		this.punkte.replace(index, neuerWert);
	}

	/**
	 * Definiert das Sterben eines Lebendigen Objekts
	 *
	 * @return Einen Container (Inventar/Gegenstaende) des Gestorbenen
	 */
	public abstract Container sterben();

}
