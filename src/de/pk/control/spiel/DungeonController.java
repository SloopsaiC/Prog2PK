package de.pk.control.spiel;

import java.util.ArrayList;

import de.pk.control.app.Main;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektController;
import de.pk.model.dungeon.Dungeon;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.Position;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.Spielbrett;
import de.pk.model.spielbrett.spielbrettTeile.Kachel;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.karte.generator.KartenGeneratorUtils;
import de.pk.utils.lokalisierung.DE_de;

/**
 * Verwaltet ein Dungeon und sorgt fuer den Ablauf des Spiels.
 *
 * @author Dylan
 */
public class DungeonController
{
	private Dungeon modell = null;

	public DungeonController(String dungeonName)
	{
		this(dungeonName, Spielkonstanten.STANDARD_PHASEN);
	}

	public DungeonController(String dungeonName, Phase[] phasen)
	{
		this.modell = new Dungeon(dungeonName);
		this.initModell(phasen);
		this.initSpielbrett();
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
	 * Game-Loop des Spiels, es werden die Phasen nacheinander ausgefuehrt, bis das
	 * Ziel des Dungeons erreicht ist.
	 */
	public void dungeonAblaufSchleife(HeldController[] helden)
	{
		this.modell.setHelden(helden);
		while (!this.modell.aufgabeIstErfuellt())
		{
			synchronized (this.modell)
			{
				Phase momentanePhase = this.modell.getMomentanePhase();
				while (!momentanePhase.istFertig())
				{
					if (this.brauchtEingabeFuerPhase())
					{
						this.getInput();
					}
					momentanePhase.phasenTick(this, this.modell.getAktivenHeld());
					this.lebendigeObjekteTick();
				}
				// rendern();
				momentanePhase.reset();
			}
			this.modell.naechstePhaseAktivieren();
		}
	}

	public void fuegeNeueKachelZuSpielbrettHinzu(Richtung richtung, Position momentanePos)
	{
		Kachel neueKachel = this.modell.getKartenGenerator().generiereNeueKachel(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y, momentanePos,
				richtung, this.getSpielbrett().getKachelBei(momentanePos));
		this.modell.getSpielbrett().setzeKachel(neueKachel,
				momentanePos.addiere(KartenGeneratorUtils.getVersatzVonRichtung(richtung)));
	}

	/**
	 * @return Die Helden dieses Spiels
	 */
	public HeldController[] getHelden()
	{
		return this.modell.getHelden();
	}

	/**
	 * Liest (Konsolen)-Input ein.
	 */
	private void getInput()
	{
		DebugAusgabeKlasse.ausgeben(DE_de.DUNGEON_ABLAUF_INPUT_AUFFORDERUNG);
		char eingabe = DebugEingabeKlasse.leseZeileEin().charAt(0);
		if (eingabe == 'x')
		{
			Main.anwendungBeenden();
		}
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
	}

	private void initSpielbrett()
	{
		this.modell.getSpielbrett().setzeKachel(this.modell.getKartenGenerator().generiereStartKachel(), new Position(
				Spielkonstanten.STANDARD_GROESSE_DUNGEON_X / 2, Spielkonstanten.STANDARD_GROESSE_DUNGEON_Y / 2));
	}

	private void lebendigeObjekteTick()
	{
		for (LebendigesObjektController objekt : this.modell.getSpielbrett().getAlleLebendigenObjekte())
		{
			Vektor positionsAenderung = objekt.update();
			if (positionsAenderung.laenge() > 0f)
			{
				this.modell.getSpielbrett().bewege(objekt, positionsAenderung);
			}
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

}
