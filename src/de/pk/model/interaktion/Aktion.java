package de.pk.model.interaktion;

import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;

/**
 * Aktionen haben selbst- und ziel-Effekte, die beim Ausfuehren der Aktion auf
 * den Ausfuehrenden sowie auf denjenigen, dem die Aktion gewidmet ist,
 * uebertragen werden. Zudem kann eine ErfolgsWahrscheinlichkeit definiert
 * werden, mit der die Aktion erst beim Wuerfeln einer hoeheren relativen
 * Augenzahl ausgefuehrt wird.
 */
public class Aktion
{

	// TODO: Sollte noch getrennt werden
	/**
	 * Die Effekte, welche auf das ausfuehrende Objekt angewendet werden.
	 */
	private Effekt selbstEffekt = null;
	/**
	 * Die Effekte, welche auf das von dieser Aktion angezielte Objekt angewendet
	 * werden.
	 */
	private Effekt zielEffekt = null;
	/**
	 * Die ErfolgsWahrscheinlichkeit definiert, ab welcher relativen
	 * Wuerfelaugenzahl die Aktion erst ausgefuehrt wird.
	 */
	private float grundErfolgsWahrscheinlichkeit = 0.0f;

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
	public Aktion(Effekt selbstEffekt, Effekt zielEffekt, float erfolgsWahrscheinlichkeit)
	{
		this.selbstEffekt = selbstEffekt;
		this.zielEffekt = zielEffekt;
		this.grundErfolgsWahrscheinlichkeit = erfolgsWahrscheinlichkeit;
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

	/**
	 * Ueberprueft ob der Wirker diese Aktion ueberhaupt ausfuehren kann
	 *
	 * @param Der Wirker dieser Aktion
	 *
	 * @return True, falls es fuer den Wirker moeglich ist diese Aktion
	 *         auszufuehren, sonst false
	 */
	private boolean ueberpruefeAktion(LebendigesObjekt wirker)
	{

		return wirker.kannSichUmXBewegen(this.selbstEffekt.getBewegungsPunkteAenderung() * (-1));
	}

	/**
	 * Wendet eine Aktion auf ein Ziel und auf den Ausfuehrenden an. Der Erfolg wird
	 * dabei durch einen Wuerfel bestimmt.
	 *
	 * @param wirker  Das ausfuehrende LebendigeObjekt.
	 * @param ziel    Das Ziel dieser Aktion.
	 * @param wuerfel Der Wuerfel der fuer diese Aktion genutzt wird.
	 *
	 * @return true, falls die Aktion erfolgreich ausgefuehrt wurde, sonst false.
	 */
	public boolean wendeAn(LebendigesObjekt wirker, LebendigesObjekt ziel, Wuerfel wuerfel)
	{
		if (this.ueberpruefeAktion(wirker)
				&& this.wuerfelWurfErfolgreich(wuerfel, this.berechneErfolgsWahrscheinlichkeit(wirker, ziel)))
		{
			wirker.fuegeEffekteHinzu(this.selbstEffekt);
			if (ziel != null)
			{
				ziel.fuegeEffekteHinzu(this.zielEffekt);
			}
			return true;
		}
		return false;
	}

	/**
	 * Gibt an, ob ein WuerfelWurf erfolgreich war. Dies ist der Fall, wenn eine
	 * niedrigere relative Augenzahl gewuerfelt wurde, als die angegebene
	 * erfolgsWahrscheinlichkeit.
	 *
	 * @param wuerfel                   Der Wuerfel, mit dem gewuerfelt werden soll.
	 * @param erfolgsWahrscheinlichkeit Dieses Verhaeltnis darf der Wuerfel nicht
	 *                                  ueberschreiten, sonst wurde nicht
	 *                                  erfolgreich gewuerfelt.
	 * @return true, wenn ine niedrigere relative Augenzahl gewuerfelt wurde, als
	 *         die angegebene erfolgsWahrscheinlichkeit.
	 */
	private boolean wuerfelWurfErfolgreich(Wuerfel wuerfel, float erfolgsWahrscheinlichkeit)
	{
		synchronized (wuerfel)
		{
			wuerfel.wuerfeln();
			return wuerfel.letzteAugenZahlAlsFloat() < erfolgsWahrscheinlichkeit;
		}
	}

}
