package de.pk.control.app;

import de.pk.control.spiel.phasen.HeldenPhase;
import de.pk.model.dungeon.Dungeon;
import de.pk.model.karte.Weltkarte;
import de.pk.model.spiel.Spiel;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Anwendung
{
	private Spiel aktivesSpiel = null;
	private boolean amLeben = false;

	public static void main(String[] args)
	{
		Anwendung a = new Anwendung();
		a.run();
	}

	/**
	 * Startet die Anwendung.
	 */
	private void start()
	{
		this.amLeben = true;
		// Nur fuers testen, spaeter wird ein Spiel erst initialisiert falls eins
		// geladen wird / der Startbildschirm verlassen wird um ein Spiel zu starten

		Weltkarte weltkarte = new Weltkarte(1);
		weltkarte.fuegeDungeonHinzu(new Dungeon(4));
		this.aktivesSpiel = new Spiel(weltkarte);
		initSpiel();
	}

	private void run()
	{
		this.start();
		anwendungsSchleife();
	}

	private void initSpiel()
	{
		this.aktivesSpiel.aendereAktivenDungeon(this.aktivesSpiel.getWeltkarte().getDungeonBei(0));
		this.aktivesSpiel.getAktiverDungeon().heldHinzufuegen(new Held());
		this.aktivesSpiel.getAktiverDungeon().registrierePhase(new HeldenPhase());
	}

	/**
	 * Sorgt dafuer, dass das aktuelle Spiel laueft und (gerendert) wird.
	 */
	private void anwendungsSchleife()
	{
		while (this.amLeben)
		{
			if (this.aktivesSpiel.getAktiverDungeon() != null)
			{
				this.aktivesSpiel.getAktiverDungeon().behandleNaechstePhase();
			}
		}
	}

}
