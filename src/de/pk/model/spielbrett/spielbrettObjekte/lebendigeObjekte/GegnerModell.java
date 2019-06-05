package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.gegner.GegnerArt;
import de.pk.model.gegenstaende.container.Container;

public class GegnerModell extends LebendigesObjektModell
{

	private float hauDraufModifkator = 0f; // Die Staerke dieses Gegners
	private GegnerArt art = null;

	/**
	 * Erstellt einen Gegner
	 *
	 * @param lebensPunkte        Anzahl der Lebenspunkte des Gegners
	 * @param bewegungsPunkte     Anzahl der Bewegungspunkte des Gegners
	 * @param hauDraufModifikator Definiert die Staerke des Gegners
	 */
	public GegnerModell(GegnerArt art, float hauDraufModifikator)
	{
		super(art.getMaxLeben(), art.getBewegungsPunkte());
		this.art = art;
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

}
