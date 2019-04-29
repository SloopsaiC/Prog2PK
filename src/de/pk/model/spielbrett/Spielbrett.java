package de.pk.model.spielbrett;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import de.pk.control.karte.generator.KartenGeneratorKachelInterface;
import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektController;
import de.pk.model.position.KachelPosition;
import de.pk.model.position.Position;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.spielbrettTeile.Kachel;

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
		Position absolutePos = altePos.getPositionAufDerKachel().addiere(vek);
		Position positionNeueKachel = this.getPositionKachel(altePos.getKachel()).addiere(
				absolutePos.getX() / KartenGeneratorKachelInterface.KACHEL_GROESSE_X,
				absolutePos.getY() / KartenGeneratorKachelInterface.KACHEL_GROESSE_Y);
		// Rumgerechne mit doppeltem Modulo, damit z.B. eine -1 Die KachelGroesse -1
		// wird, also 3 == 3 und -3 == KachelGroesse - 3
		Position posAufDerNeuenKachel = new Position(
				((absolutePos.getX() % KartenGeneratorKachelInterface.KACHEL_GROESSE_X)
						+ KartenGeneratorKachelInterface.KACHEL_GROESSE_X)
						% KartenGeneratorKachelInterface.KACHEL_GROESSE_X,
				((absolutePos.getY() % KartenGeneratorKachelInterface.KACHEL_GROESSE_Y)
						+ KartenGeneratorKachelInterface.KACHEL_GROESSE_Y)
						% KartenGeneratorKachelInterface.KACHEL_GROESSE_Y);
		return new KachelPosition(this.getKachelBei(positionNeueKachel), posAufDerNeuenKachel);
	}

	public void bewege(SpielbrettObjektController zuBewegen, KachelPosition neuePosition)
	{
		this.entferneAusAlterPosition(zuBewegen);
		neuePosition.getKachel().stelleAufKachel(neuePosition.getPositionAufDerKachel(), zuBewegen);
	}

	public void bewege(SpielbrettObjektController zuBewegen, Position positionDerKachek, Position neuePositionAufKachel)
	{
		this.bewege(zuBewegen, new KachelPosition(this.getKachelBei(positionDerKachek), neuePositionAufKachel));
	}

	public void bewege(SpielbrettObjektController zuBewegen, Vektor positionsAenderung)
	{
		this.bewege(zuBewegen,
				this.bekommeKachelPositionMitVektor(this.findeSpielbrettObjekt(zuBewegen), positionsAenderung));
	}

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

	public Kachel getKachelBei(Position pos)
	{
		return this.spielbrettTeile.get(pos);
	}

	public Position getPositionKachel(Kachel kachel)
	{
		// Dreht die Map dank der Stream API um und sucht daraus die Position
		// TODO: Koennte langsam sein und sollte deshalb vielleicht vorab gemacht und
		// gespeichert werden
		return this.spielbrettTeile.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)).get(kachel);
	}

	public void setzeKachel(Kachel kachel, Position pos)
	{
		kachel.addObserver(this);
		this.spielbrettTeile.put(pos, kachel);
	}

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
