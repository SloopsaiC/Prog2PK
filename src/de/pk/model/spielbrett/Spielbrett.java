package de.pk.model.spielbrett;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektController;
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

	public void bewege(SpielbrettObjektController zuBewegen, Kachel neueKachel, Position neuePosition)
	{
		this.entferneAusAlterPosition(zuBewegen);
		neueKachel.stelleAufKachel(neuePosition, zuBewegen);
	}

	public void bewege(SpielbrettObjektController zuBewegen, Position kachelPosition, Position neuePositionAufKachel)
	{
		this.bewege(zuBewegen, this.getKachelBei(kachelPosition), neuePositionAufKachel);
	}

	public void bewege(SpielbrettObjektController zuBewegen, Vektor positionsAenderung)
	{
		for (Position posDerKachel : this.spielbrettTeile.keySet())
		{

			Position posAufKachel = null;
			Kachel k = this.spielbrettTeile.get(posDerKachel);
			try
			{
				posAufKachel = k.getPosition(zuBewegen);
			} catch (IllegalArgumentException exc)
			{
				continue;
			}
			if (k.istAufKachel(posAufKachel.addiere(positionsAenderung)))
			{
				this.bewege(zuBewegen, k, posAufKachel);
			} else
			{
				// TODO: Kachel bestimmen, schauen ob die existiert und die Position darauf
				// bestimmen
				this.bewege(zuBewegen, posDerKachel.addiere(positionsAenderung), null);
			}
		}

	}

	private void entferneAusAlterPosition(SpielbrettObjektController zuEntfernen)
	{
		for (Kachel k : this.spielbrettTeile.values())
		{
			try
			{
				k.entferneObjekt(zuEntfernen);
			} catch (IllegalArgumentException exc)
			{
				// Das Objekt ist nicht auf der aktuellen Kachel
				continue;
			}
			return;
		}
		// Das Argument ist nicht auf dem Spielbrett
		throw new IllegalArgumentException();
	}

	public Kachel getKachelBei(Position pos)
	{
		return this.spielbrettTeile.get(pos);
	}

	public void setzeKachel(Kachel kachel, Position pos)
	{
		kachel.addObserver(this);
		this.spielbrettTeile.put(pos, kachel);
	}

	public ArrayList<LebendigesObjektController> getAlleLebendigenObjekte()
	{
		return this.alleLebendigenObjekte;
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
