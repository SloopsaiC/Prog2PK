package de.pk.control.spiel;

import java.util.InputMismatchException;

import de.pk.control.karte.Weltkarte;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.model.spiel.SpielModell;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.lokalisierung.DE_de;

public class Spiel
{
	private SpielModell spielModell = null;

	/**
	 * Erstellt ein Spiel mit default Weltkarte
	 */
	public Spiel(Held[] helden)
	{
		this(new Weltkarte(), helden);
	}

	public Spiel(Weltkarte weltkarte, Held[] helden)
	{
		this.spielModell = new SpielModell(weltkarte, helden);
	}

	public Dungeon getAktiverDungeon()
	{
		return this.spielModell.getAktivenDungeon();
	}

	public Weltkarte getWeltkarte()
	{
		return this.spielModell.getWeltkarte();
	}

	private void initDungeon(int index)
	{
		if (this.getWeltkarte().hatDungeon(index))
		{
			this.spielModell.aendereAktivenDungeon(this.getWeltkarte().getDungeonBei(index));
		}
	}

	/**
	 * Stellt ein Untermenue im Spiel dar, bei dem man sich auf der Weltkarte
	 * befindet und von welchem man die einzelnen Dungeons betreten kann.
	 */
	public void waehleDungeon(Dungeon zuWaehlen)
	{
		this.spielModell.aendereAktivenDungeon(zuWaehlen);
	}

	public void waehleDungeon(int index)
	{
		this.waehleDungeon(this.spielModell.getWeltkarte().getDungeonBei(index));
	}
}
