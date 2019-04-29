package de.pk.model.interaktion;

import java.util.concurrent.ThreadLocalRandom;

public class Wuerfel
{

	/**
	 * Die maximale Augenzahl dieses Wuerfels (die "Art" des Wuerfels).
	 */
	private int maxAugenZahl = 0;
	/**
	 * Die zuletzt gewuerfelte Augenzahl.
	 */
	private int letzteAugenZahl = 0;

	/**
	 * Erstellt einen neuen Wuerfel mit maxAugenZahl an Seiten und Augenzahlen.
	 *
	 * @param maxAugenZahl die Anzahl der Seiten des Wuerfels.
	 */
	public Wuerfel(int maxAugenZahl)
	{
		this.maxAugenZahl = maxAugenZahl;
	}

	/**
	 * Gibt die zuletzt gewuerfelte Augenzahl als int wieder.
	 *
	 * @return zuletzt gewuerfelte Augenzahl
	 */
	public int getLetzteAugenZahl()
	{
		return this.letzteAugenZahl;
	}

	/**
	 * Gibt die maximal moegliche Anzahl an Augenzahlen wieder.
	 *
	 * @return maximale Anzahl Augenzahlen (Seiten des Wuefrels)
	 */
	public int getMaxAugenZahl()
	{
		return this.maxAugenZahl;
	}

	/**
	 * Gibt die zuletzt gewuerfelte Augenzahl als Verhaeltnis zur maximalen
	 * Augenzahl als float wieder. Es wird also die relative Augenzahl zur Anzahl
	 * der Seiten berechnet.
	 *
	 * @return Verhaeltnis von zuletzt gewuerfelter und maximaler Augenzahl als
	 *         float.
	 */
	public float letzteAugenZahlAlsFloat()
	{
		return (float) this.getLetzteAugenZahl() / (float) this.getMaxAugenZahl();
	}

	/**
	 * Gibt an, ob die letzte Augenzahl fuer diesen Wuerfel maximal war.
	 *
	 * @return true, wenn die zuletzt gewuerfelte Augenzahl die maximale Augenzahl
	 *         war.
	 */
	public boolean letzteAugenZahlIstMaximal()
	{
		return this.getLetzteAugenZahl() == this.maxAugenZahl;
	}

	/**
	 * Dieser Wurfel wird neu gewuerfelt, sodass eine neue, zufaellige Augenzahl des
	 * Wuerfels ueber seine entsprechenden Methoden abgefragt werden kann.
	 *
	 * @return die neu gewuerfelte Augenzahl als int.
	 */
	public int wuerfeln()
	{
		this.letzteAugenZahl = ThreadLocalRandom.current().nextInt(0, this.maxAugenZahl + 1);
		return this.letzteAugenZahl;
	}

}
