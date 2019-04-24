package de.pk.kartenGenerator;

import de.pk.kartenGenerator.kacheln.Ecke;
import de.pk.kartenGenerator.kacheln.Frei;
import de.pk.kartenGenerator.kacheln.Kartenrand;
import de.pk.kartenGenerator.kacheln.Sackgasse;
import de.pk.kartenGenerator.kacheln.Schlucht;
import de.pk.kartenGenerator.kacheln.Start;

public class KartenGeneratorKachelInterface
{
	// Kacheldimensionen in X und Y koordinaten:
	public static final int KACHEL_GROESSE_X = 5;
	public static final int KACHEL_GROESSE_Y = 5;

	public static final KartenGeneratorKachel STARTKACHEL = new Start();
	public static final KartenGeneratorKachel FREI_GROSS = new Frei();
	public static final KartenGeneratorKachel SCHLAUCH_GROSS = new Schlucht();
	public static final KartenGeneratorKachel SACKGASSE = new Sackgasse();
	public static final KartenGeneratorKachel ECKE_GROSS = new Ecke();
	public static final KartenGeneratorKachel KARTENRAND = new Kartenrand();
        public static final KartenGeneratorKachel[] ALLEKACHELN =
	{ new Frei(), new Schlucht(), new Sackgasse(),
			new Ecke(), new Kartenrand() };
}
