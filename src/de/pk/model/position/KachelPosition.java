package de.pk.model.position;

import de.pk.control.app.Anwendung;
import de.pk.control.spielbrett.spielbrettObjekte.SpielbrettObjekt;
import de.pk.model.interaktion.Anzielbar;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.model.interaktion.effekt.EffektTyp;
import de.pk.model.karte.generator.Richtung;
import de.pk.model.spielbrett.Kachel;
import de.pk.utils.AusnahmeNachrichten;
import de.pk.utils.Spielkonstanten;

public class KachelPosition implements Anzielbar
{
	private static boolean ueberpruefePosition(Position pos)
	{
		return ((pos.getX() < Spielkonstanten.KACHEL_GROESSE_X) && (pos.getY() < Spielkonstanten.KACHEL_GROESSE_Y)
				&& (pos.getX() >= 0) && (pos.getY() >= 0));
	}

	private Kachel kachel = null;

	private Position positionAufDerKachel = null;

	public KachelPosition(Kachel kachel, Position positionAufDerKachel)
	{
		if (!KachelPosition.ueberpruefePosition(positionAufDerKachel))
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.KACHEL_POSITION_NICHT_GUELTIGE_POSITION);
		}
		this.kachel = kachel;
		this.positionAufDerKachel = positionAufDerKachel;
	}

	@Override
	public void fuegeEffekteHinzu(SpielbrettObjekt verursacher, Effekt... hinzufuegen)
	{
		// Eine Kachel kann keinen Effekt haben, sie sorgt dafuer dass der Verursacher
		// dieses Effektes hier her bewegt wird.
		if (hinzufuegen[0].getTyp() != EffektTyp.BEWEGUNG)
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.KACHEL_POSITION_NICHT_GUELTIGES_ZIEL_FUER_EFFEKT);
		}
		Anwendung.getInstanz().getAktivesSpiel().getAktiverDungeon().getSpielbrett().bewege(verursacher, this);
	}

	/**
	 * @return the kachel
	 */
	public Kachel getKachel()
	{
		return this.kachel;
	}

	/**
	 * Gibt die Richtung der Kante wieder, sollte die Position auf der Kachel an
	 * einer liegen
	 *
	 * @return Richtung, Die Richtung der Kante
	 */
	public Richtung getKantenRichtungFallsAnKante()
	{
		if (this.positionAufDerKachel.getX() == 0)
		{
			return Richtung.WESTEN;
		}
		if (this.positionAufDerKachel.getX() == (Spielkonstanten.KACHEL_GROESSE_X - 1))
		{
			return Richtung.OSTEN;
		}
		if (this.positionAufDerKachel.getY() == 0)
		{
			return Richtung.NORDEN;
		}
		if (this.positionAufDerKachel.getY() == (Spielkonstanten.KACHEL_GROESSE_Y - 1))
		{
			return Richtung.SUEDEN;
		}
		return null;
	}

	/**
	 * @return the positionAufDerKachel
	 */
	public Position getPositionAufDerKachel()
	{
		return this.positionAufDerKachel;
	}

	@Override
	public float getTrefferWahrscheinlichkeit()
	{
		return 1f;
	}

	@Override
	public boolean istGeschuetzt()
	{
		return this.getKachel().getSpielbrettObjektBei(this.positionAufDerKachel) != null;
	}

}
