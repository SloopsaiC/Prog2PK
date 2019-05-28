package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

public abstract class Boss extends GegnerModell
{

	private String name = null;

	/**
	 * Erstellt einen neuen Boss-Gegner
	 *
	 * @param name                Name des Boss-Gegners
	 * @param lebensPunkte        Anzahl der Lebenspunkte des Boss-Gegners
	 * @param bewegungsPunkte     Anzahl der Bewegungspunkte des Boss-Gegners
	 * @param hauDraufModifikator Definert die Staerke des Boss-Gegners
	 */
	public Boss(String name, int lebensPunkte, int bewegungsPunkte, int hauDraufModifikator)
	{
		super(lebensPunkte, bewegungsPunkte, hauDraufModifikator);
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

}
