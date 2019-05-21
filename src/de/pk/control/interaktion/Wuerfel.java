package de.pk.control.interaktion;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

import de.pk.model.interaktion.WuerfelWurf;

/**
 * Uebernimmt die Aufgabe des Wuerfels. Stellt nur bereit, dass man ueberpruefen
 * kann ob ein Wuerfelwurf erfolgreich ist und vernachlaessigt das Konzept von
 * Augenzahlen etc. und ist somit nur ein sehr "abstrakter" Wuerfel. Es ist
 * moeglich einen Observer hinzuzufuegen, welcher auch den geworfenen Wert des
 * letzten Wurfes mitbekommt
 *
 * @author Mattheo
 */
public class Wuerfel extends Observable
{

	/**
	 * "Wuerfelt" aus ob etwas erfolgreich ist. Die Erfolgswahrscheinlichkeit muss
	 * zwischen 0 und 1 liegen. Benachrichtigt alle Observer dieses Wuerfels und
	 * teil ihnen den Ausgang des Wurfes mit.
	 *
	 * @param erfolgsWahrscheinlichkeit Die Wahrscheinlichkeit mit welcher der Wurf
	 *                                  erfolgreich ist. 0 bedeutet 0%, 1 bedeutet
	 *                                  100%.
	 *
	 * @return True, falls der Wuerfelwurf erfolgreich ist, sonst false
	 */
	public WuerfelWurf werfeWuerfel(float erfolgsWahrscheinlichkeit)
	{
		WuerfelWurf neuerWurf = new WuerfelWurf(erfolgsWahrscheinlichkeit, ThreadLocalRandom.current().nextFloat());
		this.hasChanged();
		this.notifyObservers(neuerWurf);
		return neuerWurf;
	}

}
