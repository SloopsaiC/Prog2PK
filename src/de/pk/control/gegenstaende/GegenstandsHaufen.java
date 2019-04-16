package de.pk.control.gegenstaende;

import de.pk.model.gegenstaende.Gegenstand;
import de.pk.model.gegenstaende.GegenstandsHaufenModell;
import de.pk.utils.Spielkonstanten;

public class GegenstandsHaufen
{
	private final GegenstandsHaufenModell modell;

	public GegenstandsHaufen(Gegenstand inhalt, int menge, int maximaleAnzahl)
	{
		this.modell = new GegenstandsHaufenModell(inhalt, menge, maximaleAnzahl);
	}

	public GegenstandsHaufen(Gegenstand inhalt, int menge)
	{
		this(inhalt, menge, Spielkonstanten.STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN);
	}

	public GegenstandsHaufen entnehmen(int anzahl)
	{
		try
		{
			this.modell.setMenge(this.modell.getMenge() - anzahl);
		} catch (IllegalArgumentException nichtGenugMenge)
		{
			return null;
		}
		return new GegenstandsHaufen(this.modell.getInhalt(), anzahl, this.modell.getMaximaleAnzahl());
	}

	private GegenstandsHaufen ueberflussBeimHinzutuen(GegenstandsHaufen ueberfluss)
	{
		ueberfluss.entnehmen(this.modell.getMaximaleAnzahl() - this.modell.getMenge());
		this.modell.setMenge(this.modell.getMaximaleAnzahl());
		return ueberfluss;
	}

	public GegenstandsHaufen hinzutuen(GegenstandsHaufen zusatzInhalt)
	{
		if (!(this.modell.getInhalt().equals(zusatzInhalt.getInhalt())))
		{
			// TODO: Exception Messages
			throw new IllegalArgumentException();
		}
		try
		{
			this.modell.setMenge(this.getMenge() + zusatzInhalt.getMenge());
			zusatzInhalt.entnehmen(zusatzInhalt.getMenge());
		} catch (IllegalArgumentException ueberfluss)
		{
			return ueberflussBeimHinzutuen(zusatzInhalt);
		}
		return null;
	}

	public Gegenstand getInhalt()
	{
		return this.modell.getInhalt();
	}

	public int getMenge()
	{
		return this.modell.getMenge();
	}
}
