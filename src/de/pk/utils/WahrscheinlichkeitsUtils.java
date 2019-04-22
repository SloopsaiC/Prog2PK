package de.pk.utils;

import java.util.concurrent.ThreadLocalRandom;

public class WahrscheinlichkeitsUtils
{

	/**
	 * Addiert ein Float array und gibt die Summe zurueck.
	 * 
	 * @param array Das zu addierende Array
	 * 
	 * @return Die Summe dieses Arrays
	 */
	private static float addiereFloatArray(float[] array)
	{
		float sum = 0f;

		for (Float f : array)
		{
			sum += f;
		}
		return sum;
	}

	/**
	 * Bestimmt basierend auf gegebenen Wahrscheinlichkeiten einen Index mit
	 * Gewichtung.
	 * 
	 * @param wahrscheinlichkeiten Die Wahrscheinlichkeiten der einzelnen Indexe.
	 * 
	 * @return Ein Index aus dem Array der "zufaellig" generiert wurde
	 */
	public static int getIndexAusWahrscheinlichkeiten(float... wahrscheinlichkeiten)
	{
		float summe = addiereFloatArray(wahrscheinlichkeiten);
		float zufallsZahl = ThreadLocalRandom.current().nextFloat() * summe;
		float momentaneSumme = 0f;
		for (int i = 0; i < wahrscheinlichkeiten.length; i++)
		{
			momentaneSumme += wahrscheinlichkeiten[i];
			if (momentaneSumme >= zufallsZahl)
			{
				return i;
			}
		}
		return -1;
	}
}
