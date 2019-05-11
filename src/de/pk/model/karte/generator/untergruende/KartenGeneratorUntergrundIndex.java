package de.pk.model.karte.generator.untergruende;

public enum KartenGeneratorUntergrundIndex
{
	Ecke(new Ecke()), Frei(new Frei()), Kartenrand(new Kartenrand()), Sackgasse(new Sackgasse()),
	Schlucht(new Schlucht()), Start(new Start());

	private KartenGeneratorUntergrund objekt = null;

	private KartenGeneratorUntergrundIndex(KartenGeneratorUntergrund objekt)
	{
		this.objekt = objekt;
	}

	public KartenGeneratorUntergrund getObjektKopie()
	{
		return this.objekt.clone();
	}
}
