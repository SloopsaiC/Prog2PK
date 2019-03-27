package de.pk.control.app;

import de.pk.control.spiel.SpielController;
import de.pk.model.spiel.Spiel;

public class Anwendung
{
	private SpielController aktivesSpiel = null;
	private boolean amLeben = false;

	public static void main(String[] args)
	{
		new Anwendung().start();
	}

	/**
	 * Startet die Anwendung.
	 */
	private void start()
	{
		this.amLeben = true;
		// Nur fuers testen, spaeter wird ein Spiel erst initialisiert falls eins
		// geladen wird / der Startbildschirm verlassen wird um ein Spiel zu starten
		this.aktivesSpiel = new SpielController(new Spiel(4));
		spielSchleife();
	}

	/**
	 * Sorgt dafuer, dass das aktuelle Spiel laueft und (gerendert) wird.
	 * */
	private void spielSchleife()
	{
		while (this.amLeben)
		{
			this.aktivesSpiel.behandleNaechstePhase();
			//render();
		}
	}

}
