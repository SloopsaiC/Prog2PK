package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjektController;
import de.pk.model.interaktion.Effekt;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.utils.Spielkonstanten;

import java.util.ListIterator;

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

	public void entferneEffekt(Effekt entfernen)
	{
		if (entfernen != null)
		{
			if (!entfernen.istTickend())
			{
				this.modell.aendereRuestungsPunkte(-entfernen.getRuestungsPunkteAenderung());
				this.modell.aendereBewegungsPunkte(-entfernen.getBewegungsPunkteAenderung());
				this.modell.aendereLebensPunkte(-entfernen.getLebensPunkteAenderung());
				this.modell.aendereAngriffsPunkte(-entfernen.getAngriffsPunkteAenderung());
			}
			this.modell.entferneEffekt(entfernen);
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
		// Liste entfernt werden kann (Abgeklungene Effekte)
		ListIterator<Effekt> iterator = this.modell.getEffekte().listIterator();
		while (iterator.hasNext())
		{
			Effekt momentanerEffekt = iterator.next();
			if (momentanerEffekt.istTickend())
			{
				this.modell.aendereRuestungsPunkte(momentanerEffekt.getRuestungsPunkteAenderung());
				this.modell.aendereBewegungsPunkte(momentanerEffekt.getBewegungsPunkteAenderung());
				this.modell.aendereLebensPunkte(momentanerEffekt.getLebensPunkteAenderung());
				this.modell.aendereAngriffsPunkte(momentanerEffekt.getAngriffsPunkteAenderung());
				// Update die Positionsaenderung die von allen Effekten
				// in Summe "gefordert" wird
				positionsAenderung = positionsAenderung.addiere(momentanerEffekt.getPositionsAenderung());
				momentanerEffekt.wurdeGewirkt();
				if (momentanerEffekt.istAbgeklungen())
				{
					iterator.remove(); // wenn der Effekt abgeklungen ist, wird er entfernt.
				}
			}
		}
		return positionsAenderung;
	}

	public void fuehreAktionAus(int index, LebendigesObjektController ziel)
	{
		if ((!(index > 0 && this.modell.getAktionen().length > index)) || ziel != null)
		{
			throw new IllegalArgumentException();
		}
		this.modell.getAktionen()[index].wendeAn(this, ziel, Spielkonstanten.D20);
		
	}

	public boolean istLebendig()
	{
		return true;
	}

	public boolean kannSichUmXBewegen(int x)
	{
		return x <= this.modell.getBewegungsPunkte();
	}

}
