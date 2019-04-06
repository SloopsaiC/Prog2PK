package de.pk.control.spiel;

import java.util.List;
import java.util.Scanner;

import de.pk.control.spiel.phasen.Phase;
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
	private Dungeon dungeonModell = null;

	public DungeonController(String dungeonName, int maxAnzahlHelden)
	{
		this.dungeonModell = new Dungeon(dungeonName, maxAnzahlHelden);
	}

	/**
	 * Fuehrt die jeweils naechste Phase des Dungeons aus.
	 */
	private void behandleNaechstePhase()
	{
		this.dungeonModell.getNaechstePhase().fuerePhaseAus(this);
		this.dungeonModell.naechstePhaseAktivieren();
	}

	/**
	 * Preuft, ob die als naechstes auszufuehrende Phase eine Eingabe benoetigt.
	 *
	 * @return
	 */
	public boolean brauchtEingabeFuerNaechstePhase()
	{
		return this.dungeonModell.getNaechstePhase().brauchtEingabe();
	}

	/**
	 * Game-Loop des Spiels, es werden die Phasen nacheinander ausgefuehrt, bis das
	 * Ziel des Dungeons erreicht ist.
	 */
	public void dungeonAblaufSchleife()
	{
		while (!this.dungeonModell.aufgabeIstErfuellt())
		{
			if (this.brauchtEingabeFuerNaechstePhase())
			{
				this.getInput();
			}
			this.behandleNaechstePhase();
			this.rendern();
		}
	}

	/**
	 * @return the anzahlAktiverHelden
	 */
	public int getAnzahlAktiverHelden()
	{
		return this.dungeonModell.getAnzahlAktiverHelden();
	}

	/**
	 * @return Die Helden dieses Spiels
	 */
	public Held[] getHelden()
	{
		return this.dungeonModell.getHelden();
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
		return this.dungeonModell.getHelden().length;
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
		this.dungeonModell.heldHinzufuegen(held);
	}

	/**
	 * Testet ob die Argumente fuer die Methode registrierePhase(Phase, int) gueltig
	 * sind.
	 *
	 * @param phase   Das Phasen-Argument welches getestet wird
	 * @param positon Die Position welche geprueft wird
	 *
	 * @return True falls die Argumente gueltig sind, sonst false
	 */
	private boolean testeArgumenteRegistierePhase(Phase phase, int position)
	{
		// Test ob die Phase gueltig und die Position generell plausibel ist
		if ((phase == null) || (position < 0))
		{
			return false;
		}
		// Teste ob die Position gueltig ist, nachdem die Phase eingefuegt wurde (length
		// + 1)
		if (position > (this.getPhasen().size() + 1))
		{
			return false;
		}
		return true;
	}

	/**
	 * Registriert eine Phase die dieser SpielController auf sein Spiel anwenden
	 * wird. Die angebebene Position (0 basierend) ist die Position an der die Phase
	 * ausgefuehrt werden soll.
	 *
	 * @param phase    Die Phase welche registriert wird,
	 * @param position Die Position an welche diese Phase im Phasenzyklus gesetzt
	 *                 wird (0 basierend)
	 */
	public void registrierePhase(Phase phase, int position)
	{
		if (!this.testeArgumenteRegistierePhase(phase, position))
		{
			// TODO: Exception message
			throw new IllegalArgumentException();
		}
		this.getPhasen().add(position, phase);
	}

	/**
	 * Registriert das Argument als momentan letzte Phase.
	 *
	 * @param phase Die Phase welche registriert wird
	 */
	public void registrierePhase(Phase phase)
	{
		this.registrierePhase(phase, this.getPhasen().size());
	}

	public List<Phase> getPhasen()
	{
		return this.dungeonModell.getPhasen();
	}

	public void setPhasen(List<Phase> phasen)
	{
		this.dungeonModell.setPhasen(phasen);
	}

	private void rendern()
	{
	}

}
