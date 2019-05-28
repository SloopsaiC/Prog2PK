package de.pk.model.interaktion.aktionen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import de.pk.control.app.Anwendung;
import de.pk.control.interaktion.Wuerfel;
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
	private float grundErfolgsWahrscheinlichkeit = 1.0f;
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
	 * "Wirft einen Wuerfel" um herrauszufinden ob das Anzielen des Ziels
	 * erfolgreich ist.
	 *
	 * @return true, falls das anzielen erfolgreich war, sonst false
	 */
	private boolean anzielenErfolgreich(LebendigesObjekt zieler, Anzielbar ziel)
	{
		return this.wuerfelWurfErfolgreich(ziel.getTrefferWahrscheinlichkeit());
	}

	/**
	 * Prueft ob alle Ziele welche mit dieser Aktion angezielt wurden momentan
	 * anzielbar sind und dann ob der Spieler Glueck hatte und er auch trifft
	 *
	 * @return true, alle Ziele sind momentan legal und wurden nach dem WuerfelWurf
	 *         getroffen, sonst false
	 */
	private boolean ausfuehrenErfolgreich(LebendigesObjekt wirker, List<Anzielbar> ziele)
	{
		if (!this.wuerfelWurfErfolgreich(this.grundErfolgsWahrscheinlichkeit))
		{
			return false;
		}
		for (Anzielbar ziel : ziele)
		{
			if (!ziel.istGeschuetzt() && !this.anzielenErfolgreich(wirker, ziel))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Fuegt den Zielen die Effekte zu welche fuer sie in dieser Aktion vorgesehen
	 * wurden. Das erste Ziel bekommt auch den ersten Effekt, das zweite Ziel den
	 * zweiten usw.
	 *
	 * @param wirker Der Wirker dieser Aktion
	 * @param ziele  Die Ziele die diese Aktion anzielt
	 */
	private void fuegeEffekteZuZielenHinzu(LebendigesObjekt wirker, List<Anzielbar> ziele)
	{
		for (int i = 0; i < this.getAnzahlZiele(); i++)
		{
			ziele.get(i).fuegeEffekteHinzu(wirker, this.effekte.get(i));
		}
	}

	/**
	 * {@link de.pk.model.interaktion.aktionen.Aktion#fuehreAus(LebendigesObjekt, List)}
	 */
	public void fuehreAus(LebendigesObjekt wirker, Anzielbar... ziele)
	{
		this.fuehreAus(wirker, Arrays.asList(ziele));
	}

	/**
	 * Fuehrt diese Aktion mit den gegebenen Zielen aus.
	 *
	 * @param wirker Der Verursacher dieser Aktion
	 * @param ziel   Die Ziele dieser Aktion. Soll auf den Wirker auch ein Effekt
	 *               gelten, muss er hier auch als Ziel angegeben werden.
	 */
	public void fuehreAus(LebendigesObjekt wirker, List<Anzielbar> ziele)
	{
		if (ziele.size() != this.getAnzahlZiele())
		{
			throw new IllegalArgumentException(AusnahmeNachrichten.AKTION_FALSCHE_ANZAHL_ZIELE
					+ AusnahmeNachrichten.OBJEKT_REFERENZ_TRENNER + this.toString());
		}
		if (this.ausfuehrenErfolgreich(wirker, ziele))
		{
			this.fuegeEffekteZuZielenHinzu(wirker, ziele);
		}
	}

	/**
	 * Bestimmt die Anzahl der Ziele die diese Aktion haben muss. Hierfuer wird
	 * geschaut wie viele verschiedene Effekte diese Aktion hat
	 *
	 * @return Die Anzahl der Ziele die diese Aktion braucht um erfolgreich gewirkt
	 *         werden zu koennen
	 */
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

	private boolean wuerfelWurfErfolgreich(float erfolgsWahrscheinlichkeit)
	{
		Wuerfel wuerfel = Anwendung.getInstanz().getAktivesSpiel().getAktiverDungeon().getWuerfel();
		synchronized (wuerfel)
		{
			wuerfel.werfen(erfolgsWahrscheinlichkeit);
			return wuerfel.getValue().warErfolgreich();
		}
	}
}
