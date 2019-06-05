package de.pk.utils.karte.generator;

public class KartenGeneratorUntergrundKonstanten
{
	public static final int XTEL_AB_WELCHEM_ETWAS_IN_DER_ECKE_IST_X_KOORD = 6;
	public static final int XTEL_AB_WELCHEM_ETWAS_IN_DER_ECKE_IST_Y_KOORD = 6;

	public static final int XTEL_AB_WELCHEM_ETWAS_IN_DER_MITTE_IST = 10;

	// Dies gibt jede Kachel zurueck, welche aus Gruenden der Mapintegritaet oder
	// Aehnlichem auf der momentanen Stelle generiert werden muss.
	public static final float MAXIMALE_GENERIERUNGS_WAHRSCHEINLICHKEIT = Float.MAX_VALUE;

	public static final float ECKE_STANDARD_WAHRSCHEINLICHKEIT = 0.1f;
	public static final float ECKE_WAHRSCHEINLICHKEITS_ERHOEHUNG_FALLS_KONDITIONEN_ERFUELLT_SIND = 0.5f;
	public static final float FREI_STANDART_WAHRSCHEINLICHKEIT = 0.6f;
	public static final float FREI_WAHRSCHEINLICHKEITS_REDUZIERUNG_FALLS_NICHT_IN_MITTE = -0.4f;
	public static final float START_WAHRSCHEINLICHKEIT = 0.0f;
	public static final float SCHLUCHT_STANDARD_WAHRSCHEINLICHKEIT = 0.3f;
	public static final float SACKGASSE_STANDARD_WAHRSCHEINLICHKEIT = 0.1f;
	public static final float SACKGASSE_WAHRSCHEINLICHKEITS_AENDERUNG_FALLS_BEDINGUNG = 0.04f;
	public static final float KARTENRAND_STANDARD_WAHRSCHEINLICHKEIT = 0.0f;
	public static final float KARTENRAND_WAHRSCHEINLICHKEITS_ERHOEHUNG_FALLS_BEDINGUNG = KartenGeneratorUntergrundKonstanten.MAXIMALE_GENERIERUNGS_WAHRSCHEINLICHKEIT;
	public static final float WAHRSCHEINLICHKEIT_GEGNER = 0.5f;
}
