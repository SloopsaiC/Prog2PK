package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

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

	public float getHauDraufModifkator()
	{
		return this.hauDraufModifkator;
	}

}
