package de.pk.model.spielbrett.spielbrettObjekte.container;

import de.pk.control.gegenstaende.GegenstandsHaufen;
import de.pk.model.spielbrett.spielbrettObjekte.SpielbrettObjekt;

public abstract class SpielbrettObjektContainer extends SpielbrettObjekt
{
	private Container inhalt = null;

	protected SpielbrettObjektContainer(int maxInhalt)
	{
		this.inhalt = new Container(maxInhalt);
	}

	protected Container getInhalt()
	{
		return this.inhalt;
	}

	protected GegenstandsHaufen getInhalt(int bei)
	{
		return this.inhalt.getInhalt(bei);
	}
}
