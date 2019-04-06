package de.pk.model.interaktion;

import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.LebendigesObjekt;

public abstract class Effekt
{
	public abstract void wirke(LebendigesObjekt ziel);
}
