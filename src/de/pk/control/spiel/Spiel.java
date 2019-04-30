package de.pk.control.spiel;

import java.util.InputMismatchException;

import de.pk.control.karte.WeltkarteController;
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
		this(new WeltkarteController(), helden);
	}

	public Spiel(WeltkarteController weltkarte, Held[] helden)
	{
		this.spielModell = new SpielModell(weltkarte, helden);
	}

	public Dungeon getAktiverDungeonController()
	{
		return this.spielModell.getAktivenDungeonController();
	}

	public WeltkarteController getWeltkarte()
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
	 * Sorgt dafuer, dass das aktuelle Spiel laueft, startet den GameLoop im
	 * DungeonController.
	 */
	public void starteSpiel()
	{
		this.waehleDungeon();
		if (this.getAktiverDungeonController() != null)
		{
			this.getAktiverDungeonController().dungeonAblaufSchleife(this.spielModell.getHelden());
		}
	}

	/**
	 * Stellt ein Untermenue im Spiel dar, bei dem man sich auf der Weltkarte
	 * befindet und von welchem man die einzelnen Dungeons betreten kann.
	 */
	public void waehleDungeon()
	{
		boolean ausgewaehlt = false;
		DebugAusgabeKlasse.ausgeben(DE_de.WELTKARTE);
		while (!ausgewaehlt)
		{
			DebugAusgabeKlasse.ausgeben(DE_de.WELTKARTE_DUNGEONWAHL);
			for (int i = 0; this.spielModell.getWeltkarte().hatDungeon(i); i++)
			{
				DebugAusgabeKlasse.ausgeben("\t" + (i + 1) + DE_de.WELTKARTE_DUNGEON + (i + 1) + "\n");
			}
			DebugAusgabeKlasse.ausgeben(DE_de.WELTKARTE_ZURUECK);
			try
			{
				int dungeonWahl = Integer.valueOf(DebugEingabeKlasse.leseZeileEin());
				if (dungeonWahl == 0)
				{
					ausgewaehlt = true;
					this.spielModell.aendereAktivenDungeon(null);
					return;
				} else
				{
					ausgewaehlt = true;
					this.initDungeon(dungeonWahl - 1);
					return;
				}
			} catch (InputMismatchException e)
			{
				DebugAusgabeKlasse.ausgeben(DE_de.MENUE_INKORREKTE_KONSOLEN_EINGABE);
			}
		}
	}
}
