package de.pk.utils;

public class MatheUtils
{

	/**
	 * Passt einen Wert an zwei Grenzen an. Ist der Wert in diesen Grenzen, wird der
	 * Wert selbst zurueckgegeben. Liegt er auserhalb der Grenzen, werden die
	 * Grenzen zurueckgegeben, sodass der Wert auf dieses begrenzt wurde.
	 *
	 * @param wert         ein in Grenzen anzupassender Wert
	 * @param untereGrenze diese untereGrenze soll der Wert nicht unterschreiten
	 *                     duerfen.
	 * @param obereGrenze  diese obereGrenze soll der Wert nicht ueberschreiten
	 *                     duerfen.
	 * @return der angepasste Wert, er liegt in den Grenzen untereGrenze und
	 *         obereGrenze, sodass gilt untereGrenze >= wert >= obereGrenze.
	 */
	public static int begrenzeWertAufMinMax (int wert, int untereGrenze, int obereGrenze)
	{
		if (wert < untereGrenze)
		{
			return untereGrenze;
		}
		if (wert > obereGrenze)
		{
			return obereGrenze;
		}
		return wert;
	}
}
