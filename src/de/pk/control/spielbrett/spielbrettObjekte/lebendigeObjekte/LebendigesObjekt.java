package de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte;

import java.util.ListIterator;
import java.util.Set;

import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.position.Vektor;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjektModell;
import de.pk.utils.Spielkonstanten;

public abstract class LebendigesObjekt extends SpielbrettObjekt
{

	private final LebendigesObjektModell modell;

	protected LebendigesObjekt(LebendigesObjektModell modell)
	{
		this.modell = modell;
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

	public void fuegeAktionHinzu(String name, Aktion hinzufuegen)
	{
		this.modell.fuegeAktionHinzu(name.toLowerCase(), hinzufuegen);
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

	public void fuehreAktionAus(String name, LebendigesObjekt ziel)
	{
		try
		{
			this.modell.getAktionMitNamen(name.toLowerCase()).wendeAn(this, ziel, Spielkonstanten.WUERFEL);
		} catch (NullPointerException nichtVorhanden)
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}

	}

	public Set<String> getAktionsNamen()
	{
		return this.modell.getAktionen().keySet();
	}

	protected LebendigesObjektModell getModell()
	{
		return this.modell;
	}

	@Override
	public boolean istLebendig()
	{
		return true;
	}

	public boolean kannSichUmXBewegen(int x)
	{
		return x <= this.modell.getBewegungsPunkte();
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

}
