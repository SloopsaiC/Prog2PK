package de.pk.model.dungeon;

import de.pk.control.spiel.phasen.Phase;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Dungeon
{
	private Spielbrett spielbrett = null;
	private String name = null;

	private Held[] helden = null;
	private int anzahlAktiverHelden = 0;

	private Phase[] phasen = null;
	private int naechstePhaseIndex = 0;

	public Dungeon(int maxAnzahlHelden)
	{
		this.spielbrett = new Spielbrett();
		this.name = "Test";
		this.helden = new Held[maxAnzahlHelden];
		this.phasen = new Phase[0];
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

	public boolean brauchtEingabeFuerNaechstePhase()
	{
		return this.phasen[this.naechstePhaseIndex].brauchtEingabe();
	}

	public void behandleNaechstePhase()
	{
		synchronized (this)
		{
			// Laesst die naechste Phase ausfuehren
			this.phasen[this.naechstePhaseIndex].fuerePhaseAus(this);
			// Erhoeht die naechste Aktive Phase um einen, falls der daraus folgende Index
			// ausserhalb der verfuegbaren Phasen sein sollte, wird er statdessen auf 0
			// gesetzt
			this.naechstePhaseIndex = (this.naechstePhaseIndex + 1) % this.phasen.length;
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
		if (phase == null || position < 0)
		{
			return false;
		}
		// Teste ob die Position gueltig ist, nachdem die Phase eingefuegt wurde (length
		// + 1)
		if (position > this.getPhasen().length + 1)
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
		if (!testeArgumenteRegistierePhase(phase, position))
		{
			// TODO: Exception message
			throw new IllegalArgumentException();
		}
		synchronized (this)
		{
			Phase[] neuesPhasenArray = new Phase[this.phasen.length + 1];
			System.arraycopy(this.phasen, 0, neuesPhasenArray, 0, this.phasen.length);
			neuesPhasenArray = setzePhaseAnPosition(neuesPhasenArray, phase, position);
			this.phasen = neuesPhasenArray;
		}
	}

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
	 * @return Die Helden dieses Spiels
	 */
	public Held[] getHelden()
	{
		return this.helden;
	}

	/**
	 * @return the spielbrett
	 */
	public Spielbrett getSpielbrett()
	{
		return this.spielbrett;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @return the anzahlAktiverHelden
	 */
	public int getAnzahlAktiverHelden()
	{
		return this.anzahlAktiverHelden;
	}

	/**
	 * @return the phasen
	 */
	public Phase[] getPhasen()
	{
		return this.phasen;
	}

	public int getMaxAnzahlHelden()
	{
		return this.helden.length;
	}

}
