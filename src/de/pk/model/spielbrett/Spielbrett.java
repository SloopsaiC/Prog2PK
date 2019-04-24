package de.pk.model.spielbrett;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.model.position.Position;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.spielbrett.spielbrettTeile.Kachel;

public class Spielbrett implements Observer
{
	private HashMap<Position, Kachel> spielbrettTeile = null;
	private ArrayList<LebendigesObjekt> alleLebendigenObjekte = new ArrayList<>();

	public Spielbrett(HashMap<Position, Kachel> spielbrettTeile)
	{
		this.spielbrettTeile = spielbrettTeile;
	}

	public Spielbrett()
	{
		this(new HashMap<Position, Kachel>());
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

	public void bewege(SpielbrettObjektController zuBewegen, Kachel neueKachel, Position neuePosition)
	{
		this.entferneAusAlterPosition(zuBewegen);
		neueKachel.stelleAufKachel(neuePosition, zuBewegen);
	}

	public void bewege(SpielbrettObjektController zuBewegen, Position kachelPosition, Position neuePositionAufKachel)
	{
		this.bewege(zuBewegen, this.getKachelBei(kachelPosition), neuePositionAufKachel);
	}

	@Override
	public void update(Observable arg0, Object arg1)
	{
		SpielbrettObjekt hinzugefuegtesObjekt = (SpielbrettObjekt) arg1;
		if (hinzugefuegtesObjekt.istLebendig())
		{
			this.alleLebendigenObjekte.add((LebendigesObjekt) hinzugefuegtesObjekt);
		}
	}

}
