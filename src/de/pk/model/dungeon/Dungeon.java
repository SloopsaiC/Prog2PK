package de.pk.model.dungeon;

import de.pk.control.spiel.phasen.Phase;
import de.pk.model.spielbrett.Spielbrett;

public class Dungeon
{

	/**
	 * Setzt eine Phase an eine bestimmte Stelle in einem PhasenArray.
	 *
	 * @param ausgangsArray Das Array in welchem die Phase gesetzt werden soll
	 * @param zuSetzen      Die Phase welche gesetzt werden soll
	 * @param position      Die Position an welche die Phase im Array gesetzt werden
	 *                      soll (0 basierend)
	 */
	private static Phase[] setzePhaseAnPosition(Phase[] ausgangsArray, Phase zuSetzen, int position)
	{
		Phase[] clone = ausgangsArray.clone();
		// Falls die Position frei ist setze die Phase einfach an die Stelle
		if (clone[position] == null)
		{
			clone[position] = zuSetzen;
			return clone;
		}
		// Sonst wird die Position von hinten aus "frei geschoben"
		for (int i = ausgangsArray.length - 1; i > position; i--)
		{
			clone[i] = clone[i - 1];
		}
		// Dann wird die Phase an die nun "freie" Position gesetzt
		clone[position] = zuSetzen;
		return clone;
	}

	private Spielbrett spielbrett = null;

	private String name = null;

	private Phase[] phasen = null;

	public Dungeon(String name)
	{
		this.spielbrett = new Spielbrett();
		this.name = name;
		this.phasen = new Phase[0];
	}

	public boolean aufgabeIstErfuellt()
	{
		return false;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @return the phasen
	 */
	public Phase[] getPhasen()
	{
		return this.phasen;
	}

	/**
	 * @return the spielbrett
	 */
	public Spielbrett getSpielbrett()
	{
		return this.spielbrett;
	}

	/**
	 * Registriert das Argument als momentan letzte Phase.
	 *
	 * @param phase Die Phase welche registriert wird
	 */
	public void registrierePhase(Phase phase)
	{
		this.registrierePhase(phase, this.getPhasen().length);
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
		synchronized (this)
		{
			Phase[] neuesPhasenArray = new Phase[this.phasen.length + 1];
			System.arraycopy(this.phasen, 0, neuesPhasenArray, 0, this.phasen.length);
			neuesPhasenArray = Dungeon.setzePhaseAnPosition(neuesPhasenArray, phase, position);
			this.phasen = neuesPhasenArray;
		}
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
		if (position > (this.getPhasen().length + 1))
		{
			return false;
		}
		return true;
	}

}
