package de.pk.model.karte.generator.untergruende;

import java.util.HashMap;

import de.pk.model.karte.generator.Richtung;
import de.pk.model.position.Position;
import de.pk.utils.karte.generator.KachelUntergrundUtils;
import de.pk.utils.karte.generator.KartenGeneratorUntergrundKonstanten;

public enum KartenGeneratorUntergrund
{
	ECKE(new KachelUntergrundWertigkeit[][] {
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } },
			(a, b, c) -> KachelUntergrundUtils.istInEcke(a, b, c),
			KartenGeneratorUntergrundKonstanten.ECKE_STANDARD_WAHRSCHEINLICHKEIT,
			KartenGeneratorUntergrundKonstanten.ECKE_WAHRSCHEINLICHKEITS_ERHOEHUNG_FALLS_KONDITIONEN_ERFUELLT_SIND),
	FREI(new KachelUntergrundWertigkeit[][] {
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } },
			(a, b, c) -> KachelUntergrundUtils.istInDerMitteMitte(a, b, c),
			KartenGeneratorUntergrundKonstanten.FREI_STANDART_WAHRSCHEINLICHKEIT,
			KartenGeneratorUntergrundKonstanten.FREI_WAHRSCHEINLICHKEITS_REDUZIERUNG_FALLS_NICHT_IN_MITTE),
	START(new KachelUntergrundWertigkeit[][] {
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } },
			KartenGeneratorUntergrundKonstanten.START_WAHRSCHEINLICHKEIT),
	SCHLUCHT(new KachelUntergrundWertigkeit[][] {
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT },
			{ KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS,
					KachelUntergrundWertigkeit.FELS, KachelUntergrundWertigkeit.FELS } },
			KartenGeneratorUntergrundKonstanten.SCHLUCHT_STANDARD_WAHRSCHEINLICHKEIT),
	SACKGASSE(new KachelUntergrundWertigkeit[][] {
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BUSCH, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM,
					KachelUntergrundWertigkeit.BAUM, KachelUntergrundWertigkeit.BAUM } },
			(a, b, c) -> !KachelUntergrundUtils.istInDerMitteMitte(a, b, c),
			KartenGeneratorUntergrundKonstanten.SACKGASSE_STANDARD_WAHRSCHEINLICHKEIT,
			KartenGeneratorUntergrundKonstanten.SACKGASSE_WAHRSCHEINLICHKEITS_AENDERUNG_FALLS_BEDINGUNG),
	KARTENRAND(new KachelUntergrundWertigkeit[][] {
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE,
					KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.ENDE, KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.SCHWER, KachelUntergrundWertigkeit.ENDE },
			{ KachelUntergrundWertigkeit.HELD_VERAENDERBAR, KachelUntergrundWertigkeit.SCHWER,
					KachelUntergrundWertigkeit.LEICHT, KachelUntergrundWertigkeit.LEICHT,
					KachelUntergrundWertigkeit.HELD_VERAENDERBAR },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI },
			{ KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI,
					KachelUntergrundWertigkeit.FREI, KachelUntergrundWertigkeit.FREI } },
			(a, b, c) -> KachelUntergrundUtils.istAmRand(a, b, c),
			KartenGeneratorUntergrundKonstanten.KARTENRAND_STANDARD_WAHRSCHEINLICHKEIT,
			KartenGeneratorUntergrundKonstanten.KARTENRAND_WAHRSCHEINLICHKEITS_ERHOEHUNG_FALLS_BEDINGUNG);

	/*
	 * ENDE DER DEKLARATION DER ENUM KONSTANTEN, ANFANG DER BESCHREIBUNG DES ENUMS
	 */
	private HashMap<Richtung, KachelUntergrundWertigkeit[][]> inhalt = null;
	private UntergrundWahrscheinlichkeitsBedingung bedingungWahrscheinlichkeitsAenderung = null;
	private float standardWahrscheinlichkeit = 0;
	private float wahrscheinlichkeitsAenderungFallsBedingungErfuellt = 0;


	private KartenGeneratorUntergrund (KachelUntergrundWertigkeit[][] inhalt,
			UntergrundWahrscheinlichkeitsBedingung bedingungWahrscheinlichkeitsAenderung,
			float standardWahrscheinlichkeit, float wahrscheinlichkeitsAenderungFallsBedingungErfuellt)
	{
		this.standardWahrscheinlichkeit = standardWahrscheinlichkeit;
		this.wahrscheinlichkeitsAenderungFallsBedingungErfuellt = wahrscheinlichkeitsAenderungFallsBedingungErfuellt;
		this.bedingungWahrscheinlichkeitsAenderung = bedingungWahrscheinlichkeitsAenderung;
		this.inhalt = new HashMap<>();
		this.fuelleInhalt(inhalt);
	}


	private KartenGeneratorUntergrund (KachelUntergrundWertigkeit[][] inhalt, float standardWahrscheinlichkeit)
	{
		this(inhalt, null, standardWahrscheinlichkeit, 0.0f);
	}


	private void fuelleInhalt (KachelUntergrundWertigkeit[][] nordenInhalt)
	{
		// Startet indem der gegebene Inhalt als Inhalt gespeichert wird, sollte die
		// Kachel nach "Norden" gedreht, also im Ausgangszustand sein.
		// Anschlie�end wird der Inhalt immer um einen weiter gedreht, da die Richtungen
		// in "Richtung" in der selben Reihenfolge angegeben sind
		// Dies wird f�r alle fortgesetzt
		this.inhalt.put(Richtung.NORDEN, nordenInhalt);
		for (int i = 1; i < Richtung.values().length; i++)
		{
			this.inhalt.put(Richtung.values()[i],
					KartenGeneratorUntergrund.dreheNachRechts(this.getInhaltVonRichtung(Richtung.values()[i - 1])));
		}
	}


	public KachelUntergrundWertigkeit[][] getInhaltVonRichtung (Richtung zuBekommen)
	{
		return this.inhalt.get(zuBekommen);
	}


	public KachelUntergrundWertigkeit getInhaltVonRichtungBei (Richtung richtung, Position bei)
	{
		return this.getInhaltVonRichtung(richtung)[bei.getY()][bei.getX()];
	}


	private static KachelUntergrundWertigkeit[][] dreheNachRechts (KachelUntergrundWertigkeit[][] zuDrehen)
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


	public float getVorkommensWahrscheinlichkeit (Position position, int maximaleGroesseX, int maximaleGroesseY)
	{
		if (this.bedingungWahrscheinlichkeitsAenderung != null
				&& this.bedingungWahrscheinlichkeitsAenderung.istErfuellt(position, maximaleGroesseX, maximaleGroesseY))
		{
			return this.standardWahrscheinlichkeit + this.wahrscheinlichkeitsAenderungFallsBedingungErfuellt;
		}
		return this.standardWahrscheinlichkeit;
	}
}
