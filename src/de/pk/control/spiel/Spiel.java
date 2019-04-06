package de.pk.control.spiel;

import java.util.InputMismatchException;
import java.util.Scanner;

import de.pk.control.spiel.phasen.ExplorationsPhase;
import de.pk.control.spiel.phasen.HeldenPhase;
import de.pk.model.karte.Weltkarte;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;

public class Spiel
{

	private Weltkarte weltkarte = null;
	private DungeonController aktiverDungeonController = null; // Der Controller des momentan aktiven Dungeons,
//null falls sich der Spieler auf der "Weltkarte" befindet

	/**
	 * Erstellt ein neues Spiel mit default-Weltkarte.
	 */
	public Spiel()
	{
		// TODO: Konstanten
		this(new Weltkarte(1));
	}

	/**
	 * Erstellt ein neues Spiel mit der uebergebenen Weltkarte.
	 *
	 * @param weltkarte Die Weltkarte mit Dungeons fuer das neue Spiel.
	 */
	public Spiel(Weltkarte weltkarte)
	{
		this.weltkarte = weltkarte;
	}

	/**
	 * Aendert den aktiven dungeon auf das Argument.
	 *
	 * @param dungeonController Der Dungeon der von nun an der im Spiel aktive
	 *                          Dungeon ist.
	 */
	public void aendereAktivenDungeon(DungeonController dungeonController)
	{
		this.aktiverDungeonController = dungeonController;
	}

	/**
	 * @return Der in diesem Spiel momentan aktive Dungeon
	 */
	public DungeonController getAktivenDungeonController()
	{
		return this.aktiverDungeonController;
	}

	/**
	 * @return Die Weltkarte dieses Spiels
	 */
	public Weltkarte getWeltkarte()
	{
		return this.weltkarte;
	}

	private void initDungeon(int dungeonNummer)
	{
		this.aktiverDungeonController.heldHinzufuegen(new Held(null, 0, 0));
		this.aktiverDungeonController.registrierePhase(new HeldenPhase());
		this.aktiverDungeonController.registrierePhase(new ExplorationsPhase());
	}

	/**
	 * Sorgt dafuer, dass das aktuelle Spiel laueft, startet den GameLoop im
	 * DungeonController.
	 */
	public void starteSpiel()
	{
		this.waehleDungeon();
		if (this.aktiverDungeonController != null)
		{
			this.aktiverDungeonController.dungeonAblaufSchleife();
		}
	}

	public void waehleDungeon()
	{
		DebugAusgabeKlasse.ausgeben("\n\nSie sind nun auf der Weltkarte des Spiels");
		Scanner s = null;
		while (true)
		{
			DebugAusgabeKlasse.ausgeben("Welchen Dungeon wollen wie wählen?");
			s = new Scanner(System.in);
			for (int i = 0; i < this.weltkarte.getEnhalteneDungeons(); i++)
			{
				DebugAusgabeKlasse.ausgeben("\t" + (i + 1) + " = Dungeon " + (i + 1) + "\n");
			}
			DebugAusgabeKlasse.ausgeben("\t0 = zurueck zum Hauptmenue\n");
			try
			{
				int eingabe = s.nextInt();
				if (eingabe == 0)
				{
					this.aktiverDungeonController = null;
					break;
				} else
				{
					this.initDungeon(eingabe - 1);
					break;
				}
			} catch (InputMismatchException ex)
			{
				DebugAusgabeKlasse.ausgeben("Inkorrekte Eingabe\n\n");
			}
		}
	}

}
