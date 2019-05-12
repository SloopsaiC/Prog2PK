package de.pk.model.karte.generator.untergruende;

import java.util.HashMap;

import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.Position;
import de.pk.utils.karte.generator.KachelUntergrundUtils;
import de.pk.utils.karte.generator.KartenGeneratorUntergrundKonstanten;
import de.pk.utils.karte.generator.Kondition;

public enum KartenGeneratorUntergrundEnum
{
	ECKE(new KachelUntergrundWertigkeit[][]
	{
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } })
	{

		@Override
		public float getVorkommensWahrscheinlichkeit(Position aktuellePosition, int maximaleGroesseX,
				int maximaleGroesseY)
		{
			// Erhoeht die Wahrscheinlichkeit wenn die Kachel naeher in einer Ecke ist
			return berechneVorkommensWahrscheinlichkeitAusKonditionUndAenderungen(
					(a, b, c) -> KachelUntergrundUtils.istInEcke(a, b, c), aktuellePosition, maximaleGroesseX,
					maximaleGroesseY, KartenGeneratorUntergrundKonstanten.ECKE_STANDARD_WAHRSCHEINLICHKEIT,
					KartenGeneratorUntergrundKonstanten.ECKE_WAHRSCHEINLICHKEITS_ERHOEHUNG_FALLS_KONDITIONEN_ERFUELLT_SIND);
		}

	},
	FREI(new KachelUntergrundWertigkeit[][]
	{
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } })
	{
		@Override
		public float getVorkommensWahrscheinlichkeit(Position aktuellePosition, int maximaleGroesseX,
				int maximaleGroesseY)
		{
			return berechneVorkommensWahrscheinlichkeitAusKonditionUndAenderungen(
					(a, b, c) -> KachelUntergrundUtils.istInDerMitteMitte(a, b, c), aktuellePosition, maximaleGroesseX,
					maximaleGroesseY, KartenGeneratorUntergrundKonstanten.FREI_STANDART_WAHRSCHEINLICHKEIT,
					KartenGeneratorUntergrundKonstanten.FREI_WAHRSCHEINLICHKEITS_REDUZIERUNG_FALLS_NICHT_IN_MITTE);
		}
	};
	private HashMap<Richtung, KachelUntergrundWertigkeit[][]> inhalt = null;

	private KartenGeneratorUntergrundEnum(KachelUntergrundWertigkeit[][] inhalt)
	{
		this.fuelleInhalt(inhalt);
	}

	private void fuelleInhalt(KachelUntergrundWertigkeit[][] nordenInhalt)
	{
		// Startet indem der gegebene Inhalt als Inhalt gespeichert wird, sollte die
		// Kachel nach "Norden" gedreht, also im Ausgangszustand sein.
		// Anschließend wird der Inhalt immer um einen weiter gedreht, da die Richtungen
		// in "Richtung" in der selben Reihenfolge angegeben sind
		// Dies wird für alle fortgesetzt
		this.inhalt.put(Richtung.NORDEN, nordenInhalt);
		for (int i = 1; i < Richtung.values().length; i++)
		{
			this.inhalt.put(Richtung.values()[i],
					KartenGeneratorUntergrundEnum.dreheNachRechts(this.getInhaltVonRichtung(Richtung.values()[i - 1])));
		}
	}

	public KachelUntergrundWertigkeit[][] getInhaltVonRichtung(Richtung zuBekommen)
	{
		return this.inhalt.get(zuBekommen);
	}

	private static KachelUntergrundWertigkeit[][] dreheNachRechts(KachelUntergrundWertigkeit[][] zuDrehen)
	{
		// Generiert den neuen Inhalt
		KachelUntergrundWertigkeit[][] neuerInhalt = new KachelUntergrundWertigkeit[zuDrehen.length][zuDrehen[0].length];
		for (int x = 0; x < zuDrehen[0].length; x++)
		{
			for (int y = 0; y < zuDrehen.length; y++)
			{

				// Tauscht X und Y abhaengig davon, ob links oder rechts
				// geaendert wird. Eins bis Maximum, minus die Werte bevor gedreht wird.
				neuerInhalt[x][zuDrehen.length - 1 - y] = zuDrehen[y][x];
			}
		}
		return neuerInhalt;
	}

	public abstract float getVorkommensWahrscheinlichkeit(Position aktuellePosition, int maximaleGroesseX,
			int maximaleGroesseY);

	protected static float berechneVorkommensWahrscheinlichkeitAusKonditionUndAenderungen(Kondition kondition,
			Position aktuellePosition, int maximaleGroesseX, int maximaleGroesseY, float standardWahrscheinlichkeit,
			float additionFallsKonditionErfuellt)
	{
		if (kondition.istErfuellt(aktuellePosition, maximaleGroesseX, maximaleGroesseY))
		{
			return standardWahrscheinlichkeit + additionFallsKonditionErfuellt;
		}
		return standardWahrscheinlichkeit;
	}
}
