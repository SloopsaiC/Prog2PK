package de.pk.model.karte.generator.untergruende;

import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.Position;
import de.pk.utils.AusnahmeNachrichten;

public class KartenGeneratorUntergrundMitRichtung
{
	private KartenGeneratorUntergrund untergrund = null;
	private Richtung richtung = null;

	public KartenGeneratorUntergrundMitRichtung(KartenGeneratorUntergrund untergrund, Richtung richtung)
	{
		this.untergrund = untergrund;
		this.richtung = richtung;
	}

	public void drehe(Richtung richtung)
	{
		if ((richtung != Richtung.OSTEN) && (richtung != Richtung.WESTEN))
		{
			throw new IllegalArgumentException(
					AusnahmeNachrichten.KARTEN_GENERATOR_UNTERGRUND_MIT_RICHTUNG_DREHUNG_NICHT_NACH_RECHTS_ODER_LINKS);
		}
		this.richtung = Richtung.values()[(this.richtung.ordinal() + richtung.ordinal()) % Richtung.values().length];
	}

	public KachelUntergrundWertigkeit getInhaltBei(Position pos)
	{
		return this.untergrund.getInhaltVonRichtungBei(this.richtung, pos);
	}
}
