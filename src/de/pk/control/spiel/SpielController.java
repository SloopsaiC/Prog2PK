package de.pk.control.spiel;

import java.util.InputMismatchException;
import java.util.Scanner;

import de.pk.control.karte.WeltkarteController;
import de.pk.model.spiel.Spiel;
import de.pk.utils.DebugAusgabeKlasse;

public class SpielController
{
	private Spiel spielModell = null;

	public SpielController(WeltkarteController weltkarte)
	{
		this.spielModell = new Spiel(weltkarte);
	}

	/**
	 * Erstellt ein Spiel mit default Weltkarte
	 */
	public SpielController()
	{
		this(new WeltkarteController(1));
	}

	public void waehleDungeon()
	{
		DebugAusgabeKlasse.ausgeben("\n\nSie sind nun auf der Weltkarte des Spiels");
		boolean ausgewaehlt = false;
		Scanner s = null;
		while (!ausgewaehlt)
		{
			DebugAusgabeKlasse.ausgeben("Welchen Dungeon wollen wie wählen?");
			s = new Scanner(System.in);
			for (int i = 0; i < this.getWeltkarte().getEnthalteneDungeonsAnzahl(); i++)
			{
				DebugAusgabeKlasse.ausgeben("\t" + (i + 1) + " = Dungeon " + (i + 1) + "\n");
			}
			DebugAusgabeKlasse.ausgeben("\t0 = zurueck zum Hauptmenue\n");
			try
			{
				int eingabe = s.nextInt();
				if (eingabe == 0)
				{
					this.spielModell.aendereAktivenDungeon(null);
					ausgewaehlt = true;
					break;
				} else
				{
					this.initDungeon(eingabe - 1);
					ausgewaehlt = true;
					break;
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
			this.getAktiverDungeonController().dungeonAblaufSchleife();
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
