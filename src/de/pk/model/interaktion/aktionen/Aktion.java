package de.pk.model.interaktion.aktionen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;
import de.pk.model.interaktion.Anzielbar;
import de.pk.model.interaktion.effekt.Effekt;
import de.pk.utils.AusnahmeNachrichten;

/**
 * Aktionen haben selbst- und ziel-Effekte, die beim Ausfuehren der Aktion auf
 * den Ausfuehrenden sowie auf denjenigen, dem die Aktion gewidmet ist,
 * uebertragen werden. Zudem kann eine ErfolgsWahrscheinlichkeit definiert
 * werden, mit der die Aktion erst beim Wuerfeln einer hoeheren relativen
 * Augenzahl ausgefuehrt wird.
 */
public class Aktion
{

	private List<Effekt> effekte = null;

	/**
	 * Die ErfolgsWahrscheinlichkeit definiert, ab welcher relativen
	 * Wuerfelaugenzahl die Aktion erst ausgefuehrt wird.
	 */
	private float grundErfolgsWahrscheinlichkeit = 0.0f;
	private int reichweite = 0;

	/**
	 * Erstellt eine neue Aktion mit Namen, einer erfolgsWahrscheinlichkeit, sowie
	 * mehreren selbst- und ziel-Effekten.
	 *
	 * @param name                      Die Bezeichnung dieser Aktion.
	 * @param selbstEffekt              Der Effekt, welcher auf das ausfuehrende
	 *                                  Objekt angewendet wird.
	 * @param zielEffekt                Der Effekt welcher auf das von dieser Aktion
	 *                                  angezielte Objekt angewendet wird.
	 * @param erfolgsWahrscheinlichkeit bestimmt ab welcher relativen
	 *                                  Wuerfelaugenzahl die Aktion erst ausgefuehrt
	 *                                  wird.
	 */
	public Aktion(float erfolgsWahrscheinlichkeit, int reichweite, Effekt... effekte)
	{
		this.effekte = Collections.synchronizedList(new ArrayList<Effekt>());
		this.effekte.addAll(Arrays.asList(effekte));
		this.grundErfolgsWahrscheinlichkeit = erfolgsWahrscheinlichkeit;
		this.reichweite = reichweite;
	}

	/**
	 * Berechnet die Wahrscheinlichkeit mit der diese Aktion erfolgreich sein wird
	 * aus der Grundwahrscheinlichkeit und eventuellen Modifikatoren des Wirkers
	 * oder Ziels
	 *
	 * @param wirker Der Wirker dieser Aktion
	 * @param ziel   Das Ziel dieser Aktion
	 *
	 * @return Ein Float zwischen 0 und 1 der die Wahrscheinlichkeit angibt mit der
	 *         diese Aktion erfolgreich ist
	 */
	private float berechneErfolgsWahrscheinlichkeit(LebendigesObjekt wirker, LebendigesObjekt ziel)
	{
		return this.grundErfolgsWahrscheinlichkeit;
	}

	public void fuehreAus(LebendigesObjekt wirker, Anzielbar... ziele)
	{
		this.fuehreAus(wirker, Arrays.asList(ziele));
	}

	public void fuehreAus(LebendigesObjekt wirker, List<Anzielbar> ziele)
	{
		if (ziele.size() != this.getAnzahlZiele())
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.AKTION_FALSCHE_ANZAHL_ZIELE
					+ AusnahmeNachrichten.OBJEKT_REFERENZ_TRENNER + this.toString());
		}
		for (int i = 0; i < this.getAnzahlZiele(); i++)
		{
			ziele.get(i).fuegeEffekteHinzu(wirker, this.effekte.get(i));
		}
	}

	public int getAnzahlZiele()
	{
		return this.effekte.size();
	}

	/**
	 * Ueberprueft ob der Wirker diese Aktion ueberhaupt ausfuehren kann
	 *
	 * @param Der Wirker dieser Aktion
	 *
	 * @return True, falls es moeglich ist dieses Ziel mit dieser Aktion anzuzielen
	 *         auszufuehren, sonst false
	 */
	public boolean istLegalesZiel(Anzielbar ziel, int entfernung)
	{
		return !ziel.istGeschuetzt() && (entfernung <= this.reichweite);
	}
}
