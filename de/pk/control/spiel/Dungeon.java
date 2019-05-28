package de.pk.control.spiel;

import java.util.ArrayList;

import de.pk.control.interaktion.Wuerfel;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.Position;
import de.pk.model.spiel.dungeon.DungeonModell;
import de.pk.model.spielbrett.Kachel;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.karte.generator.KartenGeneratorUtils;

/**
 * Verwaltet ein Dungeon und sorgt fuer den Ablauf des Spiels.
 *
 * @author Dylan
 */
public class Dungeon
{
	private DungeonModell modell = null;
	private Wuerfel wuerfel = null;

	public Dungeon(String dungeonName)
	{
		this(dungeonName, Spielkonstanten.STANDARD_PHASEN);
	}

	public Dungeon(String dungeonName, Phase[] phasen)
	{
		this.modell = new DungeonModell(dungeonName);
		this.initModell(phasen);
		this.initSpielbrett();
		this.wuerfel = new Wuerfel();
	}

	/**
	 * Preuft, ob die als naechstes auszufuehrende Phase eine Eingabe benoetigt.
	 *
	 * @return
	 */
	public boolean brauchtEingabeFuerPhase()
	{
		return this.modell.getMomentanePhase().brauchtEingabe();
	}

	/**
	 * Generiert mit dem aktuellen KartenGenerator und fuegt eine neue Kachel in
	 * gegebener Richtung gesehen von gegebener Position zum Spielbrett hinzu
	 *
	 * @param richtung     Die Richtung in welche generiert werden soll
	 * @param momentanePos Die momentane Position
	 */
	public void generiereUndfuegeNeueKachelZuSpielbrettHinzu(Richtung richtung, Position momentanePos)
	{
		Kachel neueKachel = this.modell.getKartenGenerator().generiereNeueKachel(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y, momentanePos,
				richtung, this.getSpielbrett().getKachelBei(momentanePos));
		this.modell.getSpielbrett().setzeKachel(neueKachel,
				momentanePos.addiere(KartenGeneratorUtils.getVersatzVonRichtung(richtung)));
	}

	public Wuerfel getWuerfel()
	{
		return this.wuerfel;
	}

	/**
	 * @return Die Helden dieses Spiels
	 */
	public Held[] getHelden()
	{
		return this.modell.getHelden();
	}

	public ArrayList<Phase> getPhasen()
	{
		return this.modell.getPhasen();
	}

	public Spielbrett getSpielbrett()
	{
		return this.modell.getSpielbrett();
	}

	private void initModell(Phase[] phasen)
	{
		for (Phase phase : phasen)
		{
			this.registrierePhase(phase);
		}
		// Setze eine Kachel in die Mitte
		this.modell.getSpielbrett().setzeKachel(this.modell.getKartenGenerator().generiereStartKachel(), new Position(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X / 2, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y / 2));
	}

	private void initSpielbrett()
	{
		this.modell.getSpielbrett().setzeKachel(this.modell.getKartenGenerator().generiereStartKachel(), new Position(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X / 2, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y / 2));
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

	public void setPhasen(ArrayList<Phase> phasen)
	{
		this.modell.setPhasen(phasen);
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
	 * Ruft die "update" Methode auf allen LebendigesObjekt Instanzen des
	 * Spielbretts dieses Dungeons auf und bearbeitet deren Positionsaenderungen
	 */
	private void updateLebendigeObjekte()
	{
		for (LebendigesObjekt objekt : this.modell.getSpielbrett().getAlleLebendigenObjekte())
		{
			objekt.update();
		}
	}

}
