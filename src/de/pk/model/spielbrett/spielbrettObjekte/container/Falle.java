package de.pk.model.spielbrett.spielbrettObjekte.container;

import de.pk.control.gegenstaende.GegenstandsHaufen;
import de.pk.utils.Spielkonstanten;

public class Falle extends SpielbrettObjektContainer
{
	public Falle()
	{
		super(Spielkonstanten.MAX_ANZAHL_INHALT_FALLE);
	}

	public GegenstandsHaufen ausloesen()
	{
		return super.getInhalt().entferneInhalt(0);
	}

	public boolean istAusgeloest()
	{
		return super.getInhalt(0) == null;
	}
}
