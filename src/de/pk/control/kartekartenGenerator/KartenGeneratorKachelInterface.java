package de.pk.control.kartekartenGenerator;

import de.pk.control.kartekartenGenerator.untergruende.Ecke;
import de.pk.control.kartekartenGenerator.untergruende.Frei;
import de.pk.control.kartekartenGenerator.untergruende.Kartenrand;
import de.pk.control.kartekartenGenerator.untergruende.Sackgasse;
import de.pk.control.kartekartenGenerator.untergruende.Schlucht;
import de.pk.control.kartekartenGenerator.untergruende.Start;

public class KartenGeneratorKachelInterface
{
	// Kacheldimensionen in X und Y koordinaten:
	public static final int KACHEL_GROESSE_X = 5;
	public static final int KACHEL_GROESSE_Y = 5;

	public static final KartenGeneratorUntergrund STARTKACHEL = new Start();
	public static final KartenGeneratorUntergrund FREI_GROSS = new Frei();
	public static final KartenGeneratorUntergrund SCHLAUCH_GROSS = new Schlucht();
	public static final KartenGeneratorUntergrund SACKGASSE = new Sackgasse();
	public static final KartenGeneratorUntergrund ECKE_GROSS = new Ecke();
	public static final KartenGeneratorUntergrund KARTENRAND = new Kartenrand();
	public static final KartenGeneratorUntergrund[] ALLEKACHELN =
	{ new Frei(), new Schlucht(), new Sackgasse(), new Ecke(), new Kartenrand() };

}
