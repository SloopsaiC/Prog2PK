package de.pk.control.spiel;

import de.pk.control.spiel.phasen.Phase;
import de.pk.model.spiel.Spiel;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class SpielController
{
	private Spiel zuKontrollieren = null;
	private Phase[] phasen = null;
	private int naechstePhaseIndex = 0;

	public SpielController(Spiel zuKontrollieren)
	{
		this.zuKontrollieren = zuKontrollieren;
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
		// Test ob die Phase gueltig ist und die Position generell plausibel
		if (phase == null || position < 1)
		{
			return false;
		}
		// Teste ob die Position gueltig ist, nachdem die Phase eingefuegt wurde (length
		// + 1)
		if (position > this.phasen.length + 1)
		{
			return false;
		}
		return true;
	}

	/**
	 * Setzt eine Phase an eine bestimmte Stelle in einem PhasenArray.
	 * 
	 * @param ausgangsArray Das Array in welchem die Phase gesetzt werden soll
	 * @param zuSetzen      Die Phase welche gesetzt werden soll
	 * @param position      Die Position an welche die Phase im Array gesetzt werden
	 *                      soll (0 basierend)
	 */
	private static void setzePhaseAnPosition(Phase[] ausgangsArray, Phase zuSetzen, int position)
	{
		// Falls die Position frei ist setze die Phase einfach an die Stelle
		if (ausgangsArray[position] == null)
		{
			ausgangsArray[position] = zuSetzen;
			return;
		}
		// Sonst wird die Position von hinten aus "frei geschoben"
		for (int i = ausgangsArray.length - 1; i > position; i--)
		{
			ausgangsArray[i] = ausgangsArray[i - 1];
		}
		// Dann wird diese Methode wieder aufgerufen, die Position sollte nun frei sein
		setzePhaseAnPosition(ausgangsArray, zuSetzen, position);
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
		if (!testeArgumenteRegistierePhase(phase, position))
		{
			// TODO: Exception message
			throw new IllegalArgumentException();
		}
		if (this.phasen == null)
		{
			this.phasen = new Phase[]
			{ phase };
		} else
		{
			Phase[] neuesPhasenArray = new Phase[this.phasen.length + 1];
			System.arraycopy(this.phasen, 0, neuesPhasenArray, 0, this.phasen.length);
			setzePhaseAnPosition(neuesPhasenArray, phase, position);
		}
	}

	/*
	 * Registriert einen Helden bei einem Spiel.
	 * 
	 * @param spiel Das spiel bei welchem der Held registriert werden soll
	 * 
	 * @param held Der Held welcher registriert werden soll
	 **/
	public void regHeld(Held held)
	{
		if (held == null)
		{
			// TODO: Exception message
			throw new NullPointerException();
		}
		this.zuKontrollieren.heldHinzufuegen(held);
	}

	/**
	 * Aendert den im Spiel aktiven Dungeon. Wird aufgerufen, wenn der Spieler auf
	 * der Weltkarte einen Dungeon betritt, oder falls der momentan aktive Dungeon
	 * beendet wird.
	 * 
	 * @param index Der interne Index des Dungeon
	 */
	public void aendereAktivenDungeon(int index)
	{
		this.zuKontrollieren.aendereAktivenDungeon(this.zuKontrollieren.getWeltkarte().getDungeonBei(index));
	}

	public void behandleNaechstePhase()
	{
		// Laesst die naechste Phase ausfuehren
		this.phasen[this.naechstePhaseIndex].fuerePhaseAus(this.zuKontrollieren);
		// Erhoeht die naechste Aktive Phase um einen, falls der daraus folgende Index
		// ausserhalb der verfuegbaren Phasen sein sollte, wird er statdessen auf 0
		// gesetzt
		this.naechstePhaseIndex = (this.naechstePhaseIndex + 1) % this.phasen.length;
	}

}
