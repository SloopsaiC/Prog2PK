package de.pk.kartenGenerator;

import de.pk.kartenGenerator.kacheln.EckKachel;
import de.pk.kartenGenerator.kacheln.FreieKachelGross;
import de.pk.kartenGenerator.kacheln.KartenRandKachel;
import de.pk.kartenGenerator.kacheln.SackgasseKachel;
import de.pk.kartenGenerator.kacheln.SchlauchKachelGross;
import de.pk.kartenGenerator.kacheln.SchlauchKachelKlein;
import de.pk.kartenGenerator.kacheln.StartKachel;

public class KartenGeneratorKachelInterface
{
	// Kacheldimensionen in X und Y koordinaten:
	public static final int KACHEL_GROESSE_X = 5;
	public static final int KACHEL_GROESSE_Y = 5;

	// Objekte der unterschiedlichen Kacheln:
	// die Zahl hinter den Zeilen gibt die Durchschnittswertigkeit der Felder an
	// (0=frei bis 9=voll)

	public static final KartenGeneratorKachel STARTKACHEL = new StartKachel(); // 0
	public static final KartenGeneratorKachel FREI_GROSS = new FreieKachelGross(); // 0
	// TODO: freie Kachel Klein
	// TODO: Unebene freie Kachel (1-2) //0 < X < 4
	public static final KartenGeneratorKachel SCHLAUCH_GROSS = new SchlauchKachelGross(); // < 2
	public static final KartenGeneratorKachel SCHLAUCH_KLEIN = new SchlauchKachelKlein(); // < 2
	// TODO: Schlauchkacheln // 2 < X < 4
	// TODO: Schlauchkacheln // 4 < X < 9 //Geile idee, schlauchgassen mit 4ren in
	// der Mitte, diese wege
	// werden dann nur durch effekte wie zB Erdbeben begehbar
	// überlegen wie diese Teile dann an andere gelegt werden dürfen
	// zB 0 auf 4 ?!?!

	public static final KartenGeneratorKachel SACKGASSE = new SackgasseKachel(); // > 5
	public static final KartenGeneratorKachel ECKE_GROSS = new EckKachel(); // < 2
	// TODO: auch die Ecken noch in 2 < X < 4 und 4 < X < 9 implementieren
	public static final KartenGeneratorKachel KARTENRAND = new KartenRandKachel(); // 9

	public static final KartenGeneratorKachel[] alleKacheln =
	{ new FreieKachelGross(), new SchlauchKachelGross(), new SchlauchKachelKlein(), new SackgasseKachel(),
			new EckKachel(), new KartenRandKachel() };

}
