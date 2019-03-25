package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.ausruestung.Accessoire;
import de.pk.model.gegenstaende.ausruestung.Ruestung;
import de.pk.model.gegenstaende.ausruestung.Waffe;
import de.pk.model.spielbrett.spielbrettObjekte.container.Container;

public class Held extends LebendigesObjekt
{
	private Container inventar = null; // Das Inventar dieses Helden
	private Waffe waffe = null; //Die Waffe dieses Helden
	private Ruestung ruestung = null; //Dir Ruestung die dieser Held angelegt hat
	private Accessoire[] accessoires = null; //Alle Accessiores die dieser Held traegt
	private Faehigkeit[] faehigkeiten = null;
	private int sterbeZaehler = 0;
}
