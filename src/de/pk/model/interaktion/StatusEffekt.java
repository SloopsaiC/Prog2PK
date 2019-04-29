package de.pk.model.interaktion;

public class StatusEffekt extends Effekt
{

	private boolean tickt = false;

	public StatusEffekt(int bewegungsPunkteAenderung, int angriffsPunkteAenderung, int ruestungsPunkteAenderung,
			int lebensPunkteAenderung)
	{
		super(bewegungsPunkteAenderung, angriffsPunkteAenderung, ruestungsPunkteAenderung, lebensPunkteAenderung,
				Integer.MAX_VALUE);
		this.tickt = true;
	}

	@Override
	public boolean istAbgeklungen()
	{
		return false;
	}

	@Override
	public boolean istTickend()
	{
		return this.tickt;
	}

	@Override
	public void wurdeGewirkt()
	{
		this.tickt = false;
	}

}
