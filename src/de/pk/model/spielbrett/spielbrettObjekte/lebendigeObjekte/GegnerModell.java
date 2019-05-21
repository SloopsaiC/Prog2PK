package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.gegenstaende.container.Container;

public class GegnerModell extends LebendigesObjektModell
{

	private float hauDraufModifkator = 0f; // Die Staerke dieses Gegners

	/**
	 * Erstellt einen Gegner
	 *
	 * @param lebensPunkte        Anzahl der Lebenspunkte des Gegners
	 * @param bewegungsPunkte     Anzahl der Bewegungspunkte des Gegners
	 * @param hauDraufModifikator Definiert die Staerke des Gegners
	 */
	public GegnerModell(int lebensPunkte, int bewegungsPunkte, int hauDraufModifikator)
	{
		super(lebensPunkte, bewegungsPunkte);
		this.hauDraufModifkator = hauDraufModifikator;
	}

	/**
	 * Generiert den Auswurf des Gegners als Container, wenn er stirbt
	 *
	 * @return Auswurf
	 */
	public Container generiereAuswurf()
	{
		return null;
	}

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
		return this.generiereAuswurf();
	}

}
