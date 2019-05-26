package de.pk.utils;

import java.util.InputMismatchException;

/**
 * Hilfsklasse, um zweidimensionale Arrays beliebigen Typs zu drehen, spiegeln
 * und Enum-Arrays zu vergleichen.
 *
 * @author Dylan
 */
public abstract class ZweidimensionaleArrayOperationen
{

	/**
	 * Dreht ein quadratisches, zweidimensionales Array vom Typ T anzahlDrehungen
	 * oft um 90 Grad im Uhrzeigersinn ("rechts herum"). Ist anzahlDrehungen < 1, so
	 * wird array unveraendert zureckgegeben.
	 *
	 * @param <T>             Der Typ, von dem sowohl array als auch das
	 *                        zurueckgegebene Array sind.
	 * @param array           Zu drehendes Array vom Typ T.
	 * @param anzahlDrehungen Die Anzahl, um die array im Uhrzeigersinn gedreht
	 *                        werden soll.
	 *
	 * @return Eine Kopie von array um anzahlDrehungen oft um 90 Grad im
	 *         Uhrzeigersinn gedreht oder array selbst, falls anzahlDerhungen < 1.
	 */
	public static <T extends Object> T[][] dreheQuadratisches2DArrayUm90Grad(T[][] array, int anzahlDrehungen)
	{
		if ((array[0].length != array.length))
		{
			throw new InputMismatchException("Das zu drehende 2D-Array ist nicht quadratisch.");
		}
		if (anzahlDrehungen < 1)
		{
			return array;
		}
		T[][] gedrehetesArray = array.clone();
		for (int i = 0; i < anzahlDrehungen; i++)
		{
			T[][] tempArray = gedrehetesArray.clone(); // temporaeres Array fuer das Mehrfachdrehen
			for (int y = 0; y < gedrehetesArray.length; y++)
			{
				tempArray[y] = gedrehetesArray[y].clone(); // clone auch die Elemente der Zeilen ("Deep-clone")
				gedrehetesArray[y] = array[y].clone();
				for (int x = 0; x < gedrehetesArray[0].length; x++)
				{
					gedrehetesArray[y][x] = tempArray[(gedrehetesArray.length - 1) - x][y];
				}
			}
		}
		return gedrehetesArray;
	}

	/**
	 * Spiegelt ein quadratisches, zweidimensionales Array vom Typ T vertikal
	 * (senkrecht).
	 *
	 * @param <T>   Typ des zu spiegelnden Arrays und des gespiegelten Arrays.
	 * @param array Ein zu spiegelndes Array vom Typ T.
	 *
	 * @return Eine an der vertikalen Spiegelachse gespiegelte Kopie von array.
	 */
	public static <T extends Object> T[][] spiegle2DArrayVertikal(T[][] array)
	{
		T[][] gespiegeltesArray = array.clone(); // clone Zeilenarrays und Grundstruktur ("Shallow-clone!")
		for (int y = 0; y < gespiegeltesArray.length; y++)
		{
			gespiegeltesArray[y] = array[y].clone(); // clone auch die einzelnen Spalten ("Deep-clone")
			for (int x = 0, i = gespiegeltesArray[0].length - 1; x < gespiegeltesArray[0].length; x++, i--)
			{
				gespiegeltesArray[y][x] = array[y][i];
			}
		}
		return gespiegeltesArray;
	}

	/**
	 * Vergleicht zwei 2D-Arrays eines Enum-Typen miteinander und liefert wahr, wenn
	 * beide Arrays den gleichen Inhalt auf genau den gleichen Indizes haben.
	 *
	 * @param <E>        Ein Enum-Typ, von dem beide zu vergleichende Arrays sind.
	 * @param enumArray1 zweidimensionales Array vom Typ E.
	 * @param enumArray2 zweidimensionales Array vom Typ E zum Vergleich mit
	 *                   enumArray1.
	 *
	 * @return wahr, wenn enumArray1 und enumArray2 identische Werte auf den
	 *         gleichen Indizes beinhalten.
	 */
	public static <E extends Enum<E>> boolean vergleiche(E[][] enumArray1, E[][] enumArray2)
	{
		for (int y = 0; y < enumArray2.length; y++)
		{
			for (int x = 0; x < enumArray2[0].length; x++)
			{
				if (enumArray1[y][x].compareTo(enumArray2[y][x]) != 0)
				{
					return false;
				}
			}
		}
		return true;
	}

}
