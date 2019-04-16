package de.pk.control.spiel;

import java.util.InputMismatchException;

import de.pk.control.karte.WeltkarteController;
import de.pk.model.spiel.Spiel;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;

public class SpielController
{
	private Spiel spielModell = null;

	public SpielController(WeltkarteController weltkarte, Held[] helden)
	{
		this.spielModell = new Spiel(weltkarte, helden);
	}

	/**
	 * Erstellt ein Spiel mit default Weltkarte
	 */
	public SpielController(Held[] helden)
	{
		this(new WeltkarteController(), helden);
	}

	public void waehleDungeon()
	{
		boolean ausgewaehlt = false;
		DebugAusgabeKlasse.ausgeben("\n\nSie sind nun auf der Weltkarte des Spiels");
		while (!ausgewaehlt)
		{
			DebugAusgabeKlasse.ausgeben("Welchen Dungeon wollen wie waehlen?");
			for (int i = 0; this.spielModell.getWeltkarte().hatDungeon(i); i++)
			{
				DebugAusgabeKlasse.ausgeben("\t" + (i + 1) + " = Dungeon " + (i + 1) + "\n");
			}
			DebugAusgabeKlasse.ausgeben("\t0 = zurueck zum Hauptmenue\n");
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
			} catch (InputMismatchException ex)
			{
				DebugAusgabeKlasse.ausgeben("Inkorrekte Eingabe\n\n");
			}
		}
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

	public DungeonController getAktiverDungeonController()
	{
		return this.spielModell.getAktivenDungeonController();
	}

	public WeltkarteController getWeltkarte()
	{
		return this.spielModell.getWeltkarte();
	}
}
