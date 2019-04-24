package de.pk.model.interaktion;

import java.util.concurrent.ThreadLocalRandom;

public class Wuerfel
{
	private int maxAugenZahl = 0;
	private int letzteAugenZahl = 0;

	public Wuerfel(int maxAugenZahl)
	{
		this.maxAugenZahl = maxAugenZahl;
	}

	public int getLetzteAugenZahl()
	{
		return this.letzteAugenZahl;
	}

	public int getMaxAugenZahl()
	{
		return this.maxAugenZahl;
	}

	public float letzteAugenZahlAlsFloat()
	{
		return (float) this.getLetzteAugenZahl() / (float) this.getMaxAugenZahl();
	}

	public boolean letzteAugenZahlIstMaximal()
	{
		return this.getLetzteAugenZahl() == this.maxAugenZahl;
	}

	public int wuerfeln()
	{
		this.letzteAugenZahl = ThreadLocalRandom.current().nextInt(0, this.maxAugenZahl + 1);
		return this.letzteAugenZahl;
	}

}
