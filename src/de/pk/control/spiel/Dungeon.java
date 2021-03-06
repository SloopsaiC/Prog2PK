package de.pk.control.spiel;

import java.util.List;
import java.util.ListIterator;

import de.pk.control.interaktion.Wuerfel;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.KachelPosition;
import de.pk.model.position.Position;
import de.pk.model.spiel.dungeon.DungeonModell;
import de.pk.model.spielbrett.Kachel;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.utils.AusnahmeNachrichten;
import de.pk.utils.Spielkonstanten;

/**
 * Verwaltet ein Dungeon und sorgt fuer den Ablauf des Spiels.
 *
 * @author Dylan
 */
public class Dungeon
{
	private final DungeonModell modell;
	private Wuerfel wuerfel = null; // Der Wuerfel dieses Dungeons

	public Dungeon(String dungeonName)
	{
		this(dungeonName, Spielkonstanten.STANDARD_PHASEN);
	}

	public Dungeon(String dungeonName, Phase[] phasen)
	{
		this.modell = new DungeonModell(dungeonName, phasen);
		this.initModell(phasen);
		this.wuerfel = new Wuerfel();
	}

	/**
	 * Generiert mit dem aktuellen KartenGenerator und fuegt eine neue Kachel in
	 * gegebener Richtung gesehen von gegebener Position zum Spielbrett hinzu
	 *
	 * @param richtung     Die Richtung in welche generiert werden soll
	 * @param momentanePos Die momentane Position
	 */
	public void generiereUndFuegeNeueKachelZuSpielbrettHinzu(Richtung richtung, Position momentanePos)
	{
		Kachel neueKachel = this.modell.getKartenGenerator().generiereNeueKachel(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y, momentanePos,
				richtung, this.getSpielbrett().getKachelBei(momentanePos));
		this.modell.getSpielbrett().setzeKachel(neueKachel, momentanePos.addiere(richtung.getVersatz()));
	}

	public Phase getAktivePhase()
	{
		return this.getPhasen().get(this.modell.getMomentanePhaseIndex());
	}

	/**
	 * @return Die Helden dieses Spiels
	 */
	public Held[] getHelden()
	{
		return this.modell.getHelden();
	}

	public String getName()
	{
		return this.modell.getName();
	}

	public List<Phase> getPhasen()
	{
		return this.modell.getPhasen();
	}

	public Spielbrett getSpielbrett()
	{
		return this.modell.getSpielbrett();
	}

	public Wuerfel getWuerfel()
	{
		return this.wuerfel;
	}

	private void initModell(Phase[] phasen)
	{
		// Setze die Startkachel in die Mitte
		this.initSpielbrett();
	}

	private void initSpielbrett()
	{
		this.modell.getSpielbrett().setzeKachel(this.modell.getKartenGenerator().generiereStartKachel(), new Position(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X / 2, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y / 2));
		this.modell.getSpielbrett().setzeKachel(this.modell.getKartenGenerator().generiereStartKachel(), new Position(
				(Spielkonstanten.STANDARD_GROESSE_DUNGEON_X / 2) + 1, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y / 2));
		this.modell.getSpielbrett().setzeSpielbrettObjekt(
				new KachelPosition(this.modell.getSpielbrett().getKachelBei(new Position(15, 15)), new Position(0, 0)),
				Spielkonstanten.STANDARD_HELDEN[0]);
	}

	public void naechstePhase()
	{
		this.updateLebendigeObjekte();
		this.modell.naechstePhaseAktivieren();
		this.getAktivePhase().startePhaseMit(this.modell.getAktivenHeld());
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
			throw new IllegalArgumentException(AusnahmeNachrichten.DUNGEON_PHASEN_INDEX_NICHT_GUELTIG);
		}
		this.getPhasen().add(position, phase);
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
		ListIterator<LebendigesObjekt> iterator = this.modell.getSpielbrett().getAlleLebendigenObjekte().listIterator();
		while (iterator.hasNext())
		{
			LebendigesObjekt objekt = iterator.next();
			objekt.update();
			if (!objekt.istLebendig())
			{
				// Tote Objekte vom Spielbrett nehmen
				this.getSpielbrett().entferneSpielbrettObjektBei(this.getSpielbrett().findeSpielbrettObjekt(objekt));
				iterator.remove();
			}
		}
	}

}
