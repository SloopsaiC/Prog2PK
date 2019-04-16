package de.pk.kartenGenerator.kacheln;

public enum KachelWertigkeit
{
	/**
	 * 
	 * Beizeichnung plus Erklaerung der Wertigkeiten:
	 */
	FREI, // 0 Für alle und jeden frei begehbar (normaler weg)
	LEICHT, // 1 Für alle begehbar, jedoch wird man verlangsamt oder ähnliches
	SCHWER, // 2 nicht für alle begehbar, zb nur für fliegende Objekte
	HELDEN_VERAENDERBAR, // 3 von niemandem begehbar, aber vom Held reduzierbar auf 2 o. 1
	KARTEN_EFFEKT_VERAENDERBAR, // 4 nicht begehbar und nicht veraenderbar, wenn dann aendert sich der wert um
								// -1/-2 bei erdbeben, oder ähnlichem
	WASSER, // 5 (vielleicht ne kack idee)
	BAUM, // 6 nicht begehbar, i.d.R. auch nicht veraenderbar (KARTENSTRUKTUR)
	FELSEN, // 7 nicht begehbar, nicht veraenderbar (KARTENSTRUKTUR)
	ENDE; // 8 nicht begehbar, nicht veraenderbar (KARTENSTRUKTUR)

	public int getIntegerWert()
	{
		return this.ordinal();
	}

	public boolean istBetretbar()
	{
		return this.compareTo(HELDEN_VERAENDERBAR) < 0;
	}
}
