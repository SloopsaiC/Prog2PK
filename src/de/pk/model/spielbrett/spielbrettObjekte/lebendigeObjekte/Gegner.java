package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.spielbrett.spielbrettObjekte.container.Container;
import de.pk.utils.DebugAusgabeKlasse;

public abstract class Gegner extends LebendigesObjekt
{

	private float hauDraufModifkator = 0f; // Die Staerke dieses Gegners

	/**
	 * Erstellt einen Gegner
	 *
	 * @param lebensPunkte        Anzahl der Lebenspunkte des Gegners
	 * @param bewegungsPunkte     Anzahl der Bewegungspunkte des Gegners
	 * @param hauDraufModifikator Definiert die Staerke des Gegners
	 */
	public Gegner(int lebensPunkte, int bewegungsPunkte, int hauDraufModifikator)
	{
		super(lebensPunkte, bewegungsPunkte);
		this.hauDraufModifkator = hauDraufModifikator;
	}

	/**
	 * Generiert den Auswurf des Gegners als Container, wenn er stirbt
	 *
	 * @return Auswurf
	 */
	abstract Container generiereAuswurf();

	public float getHauDraufModifkator()
	{
		return this.hauDraufModifkator;
	}

	/**
	 * Definert das Sterben des Gegners
	 *
	 * @return Den Auswurf (die Hinerlassenschaften) des Gegners als Container
	 */
	@Override
	public Container sterben()
	{
		DebugAusgabeKlasse.ausgeben("Der Gegner ist gestorben.");
		return this.generiereAuswurf();
	}

}
