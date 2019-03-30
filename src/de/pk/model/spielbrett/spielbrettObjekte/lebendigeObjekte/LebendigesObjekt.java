package de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte;

import de.pk.model.interaktion.Aktion;
import de.pk.model.interaktion.StatusEffekt;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;

public abstract class LebendigesObjekt extends SpielbrettObjekt
{
	private int bewegungsPunkte = 0;
	private int ruestungsPunkte = 0;
	private int lebensPunkte = 0;
	private Aktion[] aktionen = null; //Alle Aktionen die dieses lebendige Objekt ausfuehren kann
	private StatusEffekt[] statusEffekte = null; //Alle Statuseffekte die auf dieses Objekt wirken
	
	
}
