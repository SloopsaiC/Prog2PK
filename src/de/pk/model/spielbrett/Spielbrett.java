package de.pk.model.spielbrett;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektController;
import de.pk.model.position.KachelPosition;
import de.pk.model.position.Position;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.spielbrettTeile.Kachel;
import de.pk.utils.Spielkonstanten;

public class Spielbrett implements Observer
{
	private HashMap<Position, Kachel> spielbrettTeile = null;
	private ArrayList<LebendigesObjektController> alleLebendigenObjekte = new ArrayList<>();

	public Spielbrett()
	{
		this(new HashMap<Position, Kachel>());
	}

	public Spielbrett(HashMap<Position, Kachel> spielbrettTeile)
	{
		this.spielbrettTeile = spielbrettTeile;
	}

	/**
	 * Bekommt die KachelPosition welche aus der Addition des Vektors resultiert
	 * 
	 * @param altePos Die alte KachelPosition
	 * @param vek     Der Vektor welcher addiert wird
	 * 
	 * @return KachelPosition, Die resultierende Position
	 */
	private KachelPosition bekommeKachelPositionMitVektor(KachelPosition altePos, Vektor vek)
	{
		// Eigentlich nur ne Geschwindigkeitsoptimierung, es musst nichts "kompliziert"
		// gebaut werden was einfach geht
		try
		{
			return new KachelPosition(altePos.getKachel(), altePos.getPositionAufDerKachel().addiere(vek));
		} catch (IllegalArgumentException nichtGueltig)
		{
			// Wir sind auf einer anderen Kachel
		}
		// Berechne die "absolute Position", welche ueber diese Kachel hinaussreicht
		Position absolutePos = altePos.getPositionAufDerKachel().addiere(vek);
		// Berechne die Position der Kachel auf welcher die absolute Position sich
		// befindet
		Position positionNeueKachel = this.getPositionKachel(altePos.getKachel()).addiere(
				absolutePos.getX() / Spielkonstanten.KACHEL_GROESSE_X,
				absolutePos.getY() / Spielkonstanten.KACHEL_GROESSE_Y);
		// Rumgerechne mit doppeltem Modulo, damit z.B. eine -1 Die KachelGroesse -1
		// wird, also 3 == 3 und -3 == KachelGroesse - 3
		Position posAufDerNeuenKachel = new Position(
				((absolutePos.getX() % Spielkonstanten.KACHEL_GROESSE_X) + Spielkonstanten.KACHEL_GROESSE_X)
						% Spielkonstanten.KACHEL_GROESSE_X,
				((absolutePos.getY() % Spielkonstanten.KACHEL_GROESSE_Y) + Spielkonstanten.KACHEL_GROESSE_Y)
						% Spielkonstanten.KACHEL_GROESSE_Y);
		return new KachelPosition(this.getKachelBei(positionNeueKachel), posAufDerNeuenKachel);
	}

	/**
	 * Bewegt ein Objekt an eine neue KachelPosition, ueberprueft ob diese Kachel
	 * begehbar ist
	 * 
	 * @param zuBewegen    Das zu bewegene Objekt
	 * @param neuePosition Die neue Position
	 * 
	 */
	public void bewege(SpielbrettObjektController zuBewegen, KachelPosition neuePosition)
	{
		if (!neuePosition.getKachel().getUntergrundBei(neuePosition.getPositionAufDerKachel()).istBetretbar())
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		this.entferneAusAlterPosition(zuBewegen);
		neuePosition.getKachel().stelleAufKachel(neuePosition.getPositionAufDerKachel(), zuBewegen);
	}

	/**
	 * Ueberladungs zu
	 * {@link de.pk.model.spielbrett.Spielbrett#bewege(SpielbrettObjektController, KachelPosition)}
	 */
	public void bewege(SpielbrettObjektController zuBewegen, Position positionDerKachek, Position neuePositionAufKachel)
	{
		this.bewege(zuBewegen, new KachelPosition(this.getKachelBei(positionDerKachek), neuePositionAufKachel));
	}

	/**
	 * Ueberladungs zu
	 * {@link de.pk.model.spielbrett.Spielbrett#bewege(SpielbrettObjektController, KachelPosition)}
	 */
	public void bewege(SpielbrettObjektController zuBewegen, Vektor positionsAenderung)
	{
		this.bewege(zuBewegen,
				this.bekommeKachelPositionMitVektor(this.findeSpielbrettObjekt(zuBewegen), positionsAenderung));
	}

	/**
	 * Entfernt ein Objekt aus einer Position
	 * 
	 * @param zuEntfernen Das zu entfernende Objekt
	 */
	private void entferneAusAlterPosition(SpielbrettObjektController zuEntfernen)
	{
		try
		{
			this.findeSpielbrettObjekt(zuEntfernen).getKachel().entferneObjekt(zuEntfernen);
		} catch (NullPointerException nichtAufSpielbrett)
		{
			// TODO: Exception messages
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Findet ein Objekt auf dem Spielbrett
	 * 
	 * @param zuFinden Das zu findene Objekt
	 * 
	 * @return KachelPosition, Die KachelPosition auf welcher sich das Objekt
	 *         befindet, oder null falls es nicht auf dem Spielbrett ist
	 */
	public KachelPosition findeSpielbrettObjekt(SpielbrettObjektController zuFinden)
	{
		for (Kachel kachel : this.spielbrettTeile.values())
		{
			if (kachel.objektIstAufKachel(zuFinden))
			{
				return new KachelPosition(kachel, kachel.getPosition(zuFinden));
			}
		}
		return null;
	}

	public ArrayList<LebendigesObjektController> getAlleLebendigenObjekte()
	{
		return this.alleLebendigenObjekte;
	}

	/**
	 * Gibt die Kachel an dieser Position wieder
	 * 
	 * @param pos Die Position welche abgefragt wird
	 * @return Kachel, die Kachel an dieser Position
	 */
	public Kachel getKachelBei(Position pos)
	{
		return this.spielbrettTeile.get(pos);
	}

	/**
	 * Sucht eine Kachel auf dem Spielbrett
	 * 
	 * @param kachel Die zu suchende Kachel
	 * 
	 * @return Position Die position dieser Kachel, sollte sie auf dem Spielbrett
	 *         sein
	 */
	public Position getPositionKachel(Kachel kachel)
	{
		// Dreht die Map dank der Stream API um und sucht daraus die Position
		// TODO: Koennte langsam sein und sollte deshalb vielleicht vorab gemacht und
		// gespeichert werden
		return this.spielbrettTeile.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)).get(kachel);
	}

	/**
	 * Setzt eine Kachel an die bestimmte Position
	 * 
	 * @param kachel Die zu setztende Kachel
	 * @param pos    Die Position an welche gesetzt werden soll
	 */
	public void setzeKachel(Kachel kachel, Position pos)
	{
		kachel.addObserver(this);
		this.spielbrettTeile.put(pos, kachel);
	}

	/**
	 * Wird aufgerufen, falls einer Kachel ein neues Objekt hinzugefuegt wird, wird
	 * die Liste mit allen lebendigen Objekten geupdatet
	 * 
	 * @see Observer#update(Observable, Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1)
	{
		SpielbrettObjektController hinzugefuegtesObjekt = (SpielbrettObjektController) arg1;
		if (hinzugefuegtesObjekt.istLebendig())
		{
			this.alleLebendigenObjekte.add((LebendigesObjektController) hinzugefuegtesObjekt);
		}
	}

}
