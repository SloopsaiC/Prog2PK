package de.pk.control.spiel;

import java.util.ArrayList;

import de.pk.control.app.Main;
import de.pk.control.spiel.phasen.Phase;
import de.pk.model.dungeon.Dungeon;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.Spielkonstanten;

/**
 * Verwaltet ein Dungeon und sorgt fuer den Ablauf des Spiels.
 *
 * @author Dylan
 */
public class DungeonController
{
	private Dungeon dungeonModell = null;

	public DungeonController(String dungeonName)
	{
		this(dungeonName, Spielkonstanten.STANDARD_PHASEN);
	}

	public DungeonController(String dungeonName, Phase[] phasen)
	{
		this.dungeonModell = new Dungeon(dungeonName);
		this.initModell(phasen);
	}

	/**
	 * Fuehrt die jeweils naechste Phase des Dungeons aus.
	 */
	private void behandlePhase()
	{
		this.dungeonModell.getMomentanePhase().fuerePhaseAus(this, this.dungeonModell.getAktivenHeld());
	}

	/**
	 * Preuft, ob die als naechstes auszufuehrende Phase eine Eingabe benoetigt.
	 *
	 * @return
	 */
	public boolean brauchtEingabeFuerPhase()
	{
		return this.dungeonModell.getMomentanePhase().brauchtEingabe();
	}

	/**
	 * Game-Loop des Spiels, es werden die Phasen nacheinander ausgefuehrt, bis das
	 * Ziel des Dungeons erreicht ist.
	 */
	public void dungeonAblaufSchleife(Held[] helden)
	{
		this.dungeonModell.setHelden(helden);
		while (!this.dungeonModell.aufgabeIstErfuellt())
		{
			if (this.brauchtEingabeFuerPhase())
			{
				this.getInput();
			}
			this.behandlePhase();
			this.rendern();
			this.dungeonModell.naechstePhaseAktivieren();
		}
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
		DebugAusgabeKlasse.ausgeben("Geben Sie Input ein. (x = beenden)");
		char eingabe = DebugEingabeKlasse.leseZeileEin().charAt(0);
		if (eingabe == 'x')
		{
			Main.anwendungBeenden();
		}
	}

	public ArrayList<Phase> getPhasen()
	{
		return this.dungeonModell.getPhasen();
	}

	private void initModell(Phase[] phasen)
	{
		for (Phase phase : phasen)
		{
			this.registrierePhase(phase);
		}
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

	private void rendern()
	{
	}

	public void setPhasen(ArrayList<Phase> phasen)
	{
		this.dungeonModell.setPhasen(phasen);
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

}
