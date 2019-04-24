package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ListIterator;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.model.interaktion.Effekt;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;

public abstract class LebendigesObjektController extends SpielbrettObjektController
{
	private final LebendigesObjekt modell;

	protected LebendigesObjektController(LebendigesObjekt modell)
	{
		this.modell = modell;
	}

	public void fuegeEffekteHinzu(Effekt... hinzufuegen)
	{
		if (hinzufuegen != null)
		{
			for (Effekt effekt : hinzufuegen)
			{
				this.modell.fuegeEffektHinzu(effekt);
			}
		}
	}

	protected LebendigesObjekt getModell()
	{
		return this.modell;
	}

	public Vektor update()
	{
		Vektor positionsAenderung = new Vektor(0, 0);
		// While und List Iterator da hier ein Element waehrend des Iterierens aus der
		// Liste entfernt werden kann (Abgeklungende Effekte)
		ListIterator<Effekt> iterator = this.modell.getEffekte().listIterator();
		while (iterator.hasNext())
		{
			Effekt momentanerEffekt = iterator.next();
			this.modell.aendereRuestungsPunkte(momentanerEffekt.getRuestungsPunkteAenderung());
			this.modell.aendereBewegungsPunkte(momentanerEffekt.getBewegungsPunkteAenderung());
			this.modell.aendereLebensPunkte(momentanerEffekt.getLebensPunkteAenderung());
			// Update die Positionsaenderung die von allen Effekten
			// in Summe "gefordert" wird
			positionsAenderung = positionsAenderung.addiere(momentanerEffekt.getPositionsAenderung());
			momentanerEffekt.wurdeGewirkt();
			if (momentanerEffekt.istAbgeklungen())
			{
				iterator.remove();
			}
		}
		return positionsAenderung;
	}
}
