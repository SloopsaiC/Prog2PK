package de.pk.control.spiel;

import java.util.Scanner;

import de.pk.model.dungeon.Dungeon;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;

/**
 * Verwaltet ein Dungeon und sorgt fuer den Ablauf des Spiels.
 *
 * @author Dylan
 */
public class DungeonController
{

	private Dungeon aktiverDungeon = null;
	private Held[] helden = null;
	private int anzahlAktiverHelden = 0;
	private int naechstePhaseIndex = 0;

	public DungeonController(int maxAnzahlHelden)
	{
		this.helden = new Held[maxAnzahlHelden];
	}

	/**
	 * Fuehrt die jeweils naechste Phase des Dungeons aus.
	 */
	private void behandleNaechstePhase()
	{
		this.aktiverDungeon.getPhasen()[this.naechstePhaseIndex].fuerePhaseAus(this);
		this.naechstePhaseIndex = (this.naechstePhaseIndex + 1) % this.aktiverDungeon.getPhasen().length;
	}

	/**
	 * Preuft, ob die als naechstes auszufuehrende Phase eine Eingabe benoetigt.
	 *
	 * @return
	 */
	public boolean brauchtEingabeFuerNaechstePhase()
	{
		return this.aktiverDungeon.getPhasen()[this.naechstePhaseIndex].brauchtEingabe();
	}

	/**
	 * Game-Loop des Spiels, es werden die Phasen nacheinander ausgefuehrt, bis das
	 * Ziel des Dungeons erreicht ist.
	 */
	public void dungeonAblaufSchleife()
	{
		while (!this.aktiverDungeon.aufgabeIstErfuellt())
		{
			if (this.brauchtEingabeFuerNaechstePhase())
			{
				this.getInput();
			}
			this.behandleNaechstePhase();
			this.rendern();
		}
	}

	public Dungeon getAktiverDungeon()
	{
		return this.aktiverDungeon;
	}

	/**
	 * @return the anzahlAktiverHelden
	 */
	public int getAnzahlAktiverHelden()
	{
		return this.anzahlAktiverHelden;
	}

	/**
	 * @return Die Helden dieses Spiels
	 */
	public Held[] getHelden()
	{
		return this.helden;
	}

	private void getInput()
	{
		Scanner inputScanner = new Scanner(System.in);
		DebugAusgabeKlasse.ausgeben("Geben Sie Input ein. (x = beenden)");
		if (inputScanner.nextLine().charAt(0) == 'x')
		{
			System.exit(0);
		}
	}

	public int getMaxAnzahlHelden()
	{
		return this.helden.length;
	}

	/**
	 * Fuegt einen Helden zu diesem Spiel hinzu
	 *
	 * @param held Der Held welcher hinzugefuegt werden soll.
	 */
	public void heldHinzufuegen(Held held)
	{
		if (held == null)
		{
			// TODO: Exception Message
			throw new NullPointerException();
		}
		synchronized (this)
		{
			if (this.anzahlAktiverHelden < this.getMaxAnzahlHelden())
			{
				// Synchronized da es sonst zu IndexOutOfBounds Exceptions kommen koennte
				this.helden[this.anzahlAktiverHelden++] = held;

			} else
			{
				// TODO: Exception message
				throw new IllegalStateException();
			}
		}
	}

	private void rendern()
	{
	}

	public void setAktiverDungeon(Dungeon aktiverDungeon)
	{
		this.aktiverDungeon = aktiverDungeon;
	}

}
