package de.pk.control.karte.generator;

import de.pk.model.karte.generator.untergruende.Ecke;
import de.pk.model.karte.generator.untergruende.Frei;
import de.pk.model.karte.generator.untergruende.KartenGeneratorUntergrund;
import de.pk.model.karte.generator.untergruende.Kartenrand;
import de.pk.model.karte.generator.untergruende.Sackgasse;
import de.pk.model.karte.generator.untergruende.Schlucht;
import de.pk.model.karte.generator.untergruende.Start;

public class KartenGeneratorKachelInterface
{
	public static final KartenGeneratorUntergrund STARTKACHEL = new Start();
	public static final KartenGeneratorUntergrund FREI_GROSS = new Frei();
	public static final KartenGeneratorUntergrund SCHLAUCH_GROSS = new Schlucht();
	public static final KartenGeneratorUntergrund SACKGASSE = new Sackgasse();
	public static final KartenGeneratorUntergrund ECKE_GROSS = new Ecke();
	public static final KartenGeneratorUntergrund KARTENRAND = new Kartenrand();
	public static final KartenGeneratorUntergrund[] ALLEKACHELN =
	{ new Frei(), new Schlucht(), new Sackgasse(), new Ecke(), new Kartenrand() };

}
