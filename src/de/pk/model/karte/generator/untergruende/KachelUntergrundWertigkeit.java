package de.pk.model.karte.generator.untergruende;

public enum KachelUntergrundWertigkeit
{
	/**
	 *
	 * Beizeichnung plus Erklaerung der Wertigkeiten:
	 */
	FREI, // 0 Für alle und jeden frei begehbar (normaler weg)
	LEICHT, // 1 Für alle begehbar, jedoch wird man verlangsamt oder ähnliches
	SCHWER, // 2 nicht für alle begehbar, zb nur für fliegende Objekte
	HELD_VERAENDERBAR, // 3 von niemandem begehbar, aber vom Held reduzierbar auf 2 o. 1
	KARTEN_EFFEKT_VERAENDERBAR, // 4 nicht begehbar und nicht veraenderbar, wenn dann aendert sich der wert um
								// 1/-2 bei erdbeben, oder ähnliches
	BUSCH, // 5 nicht begehbar, i.d.R. auch nicht veraenderbar (KARTENSTRUKTUR)
	BAUM, // 6 nicht begehbar, i.d.R. auch nicht veraenderbar (KARTENSTRUKTUR)
	FELS, // 7 nicht begehbar, nicht veraenderbar (KARTENSTRUKTUR)
	ENDE; // 8 nicht begehbar, nicht veraenderbar (KARTENSTRUKTUR)

	public int getIntegerWert()
	{
		return this.ordinal();
	}

	public boolean istBetretbar()
	{
		return this.compareTo(HELD_VERAENDERBAR) < 0;
	}
}
